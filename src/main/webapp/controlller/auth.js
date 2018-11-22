angular.module('app').controller('authSettingListCtrl',
    ['$scope', '$state', '$log', 'authSettingListService', '$mdDialog', '$mdToast', '$mdSidenav', '$stateParams',
        function ($scope, $state, $log, authSettingListService, $mdDialog, $mdToast, $mdSidenav, $stateParams) {

            //表头排序
            $scope.sortItem = 'id';//默认显示的排序表头
            $scope.desc = false;
            //获取管理员列表
            var currentPageNo = 1;//当前页
            $scope.ps = $stateParams.pageSize;
            $scope.pno = $stateParams.pageNo;
            $scope.getAdminList = function (currentPageNo, pageSize, searchObj) {
                authSettingListService.loadList(currentPageNo, $scope.ps, searchObj).then(function (data) {

                    $scope.accountList = data;//分页数据
                    $scope.cpn = currentPageNo;
                    $scope.totalNum = $scope.ps;//将路由的值存入页面
                    //绑定搜索条件
                    if ($stateParams.searchObj != undefined && $stateParams.searchObj != '') {
                        $scope.obj = angular.fromJson($stateParams.searchObj);
                        $scope.search = {
                            'accountName': $scope.obj.accountName,
                            'accountStatus': $scope.obj.accountStatus,
                            'permissionStatus': $scope.obj.permissionStatus,
                        }
                    }
                    $scope.$broadcast('accountList', data);
                });
            };

            //跳转分页
            $scope.jumpPage = function (currentPageNo) {
                $state.go('index.auth-setting-list', {
                    pageNo: currentPageNo,
                    pageSize: $scope.ps,
                    searchObj: $stateParams.searchObj
                });
            }
            $scope.authSettingListExcel = function (data) {
                console.log(data);
                var confirm = $mdDialog.confirm()
                    .title('你确定要导出当前列表码？')
                    .content('导出速度取决于要导出的会员数量，数量过多时会花费更多的时间')
                    .targetEvent(data)
                    .ok('确认')
                    .cancel('取消');
                $mdDialog.show(confirm).then(function () {
                    var form = $("<form>");
                    form.attr("style", "display:none");
                    form.attr("target", "");
                    form.attr("method", "post");
                    form.attr("action", "admin_manager/authSettingListExcel");
                    var input1 = $("<input>");
                    input1.attr("type", "hidden");
                    input1.attr("name", "accountList");
                    input1.attr("value", angular.toJson(data));
                    $("body").append(form);
                    form.append(input1);
                    form.submit();
                    //window.location.href="admin_manager/authSettingListExcel?accountList="+angular.toJson(data);
                });
            }
            //搜索
            $scope.searchAccount = function (searchObj) {
                $state.go('index.auth-setting-list', {
                    pageNo: currentPageNo,
                    pageSize: $scope.ps,
                    searchObj: angular.toJson(searchObj)
                });
                //$scope.getAdminList($scope.cpn,$scope.ps,searchObj);
                // $state.go('index.auth-setting-list', {
                //     pageNo: currentPageNo,
                //     pageSize: $scope.ps,
                //     searchObj: angular.toJson(searchObj)
                // })
                $mdSidenav('searchSideNav').close();
            }

            //是否传搜索条件执行的方法
            $scope.loadList = function () {
                if ($stateParams.searchObj == '') {
                    $scope.getAdminList($scope.pno, $scope.ps);
                } else {
                    $scope.getAdminList($scope.pno, $scope.ps, $stateParams.searchObj);
                }
            }
            $scope.loadList();

            //获取自定义每页显示记录数
            $scope.pageChange = function (pageNum, searchObj) {
                $scope.ps = pageNum;//将页面的值存入路由
                var newPageToTal = Math.ceil($scope.itemCount / $scope.ps);
                if (newPageToTal <= $scope.pageTotal) {
                    $scope.pageTotal = newPageToTal;
                    if (newPageToTal <= $scope.pno) {
                        $scope.pno = newPageToTal;
                    }
                }
                $state.go('index.auth-setting-list', {
                    pageNo: $scope.pno,
                    pageSize: $scope.ps,
                    searchObj: $stateParams.searchObj
                });
            }

            //设置账户状态
            $scope.setStatus = function (status, adminId, ev) {
                var accountStatus = status == '0' ? '启用' : '禁用';
                var confirm = $mdDialog.confirm()
                    .title('是否' + accountStatus + '此账户')
                    .targetEvent(ev)
                    .ok('确认')
                    .cancel('取消');

                $mdDialog.show(confirm).then(function () {
                    //修改账户状态
                    authSettingListService.updateAccountStatus(status, adminId).then(function (data) {
                        if (data.msg == "success") {
                            $mdToast.show(
                                $mdToast.simple()
                                    .textContent('账号' + accountStatus + '成功!')
                                    .position('top right')
                                    .hideDelay(3000)
                            );
                            //$scope.getAdminList($scope.pageNoJump>0?$scope.pageNoJump:1,$scope.searchObj);
                            $state.go('index.auth-setting-list', {
                                    pageNo: $stateParams.pageNo,
                                    pageSize: $scope.ps,
                                    searchObj: $stateParams.searchObj
                                },
                                {
                                    reload: true
                                });
                        } else {
                            $mdToast.show(
                                $mdToast.simple()
                                    .textContent('账号' + accountStatus + '失败!')
                                    .position('top right')
                                    .hideDelay(3000)
                            );

                        }
                    });

                })

            }

            //新增或跟新会所信息
            $scope.operateAccount = function (ev, id) {
                $scope.accountID = id;
                $mdDialog.show({
                    controller: operateAccountCtrl,
                    templateUrl: 'template/operate-account.html',
                    parent: angular.element(document.body),
                    targetEvent: ev,
                    clickOutsideToClose: false,
                    locals: {
                        id: $scope.accountID
                    }
                }).then(function () {
                    //回调函数可以用于刷新列表数据
                    //获取管理人员列表
                    //$scope.getAdminList($scope.pageNoJump>0?$scope.pageNoJump:1, $scope.searchObj);
                    $state.go('index.auth-setting-list', {
                            pageNo: $stateParams.pageNo,
                            pageSize: $scope.ps,
                            searchObj: $stateParams.searchObj,
                            adminId: id
                        },
                        {
                            reload: true
                        });
                })
            }
            //新增账户
            function operateAccountCtrl($scope, id) {
                $scope.adminId = id;
                if (id != undefined) {
                    $scope.type = '更新账户信息';
                    $scope.updateAccountPage = 1;
                    authSettingListService.findAdminById(id).then(function (data) {
                        $scope.account = data;
                        $scope.$broadcast("updateAccount", $scope.account.belongStore);
                    });
                    $scope.saveAccount = function (account, ev) {
                        authSettingListService.updateAdmin(account, $scope.adminId).then(function (data) {

                        });
                        var obj = ev.currentTarget;
                        obj.disabled = true;
                        obj.innerHTML = '正在更新账户信息...';
                        $mdToast.show(
                            $mdToast.simple()
                                .textContent('账户更新成功，即将返回账户列表')
                                .position('top right')
                                .hideDelay(1000)
                        );
                        setTimeout(function () {
                            $scope.coloseDialog();
                        }, 1000)
                    }
                } else {//新增账户
                    $scope.updateAccountPage = 0;
                    $scope.type = '新增账户'
                    $scope.saveAccount = function (account, ev) {
                        ///增加管理员
                        authSettingListService.addManager(account).then(function (data) {
                            if (data.msg == 'success') {
                                var obj = ev.currentTarget;
                                obj.disabled = true;
                                obj.innerHTML = '正在保存账户信息...';
                                $mdToast.show(
                                    $mdToast.simple()
                                        .textContent('账户新增成功,即将返回账户列表')
                                        .position('top right')
                                        .hideDelay(1000)
                                );

                                setTimeout(function () {
                                    $scope.coloseDialog();
                                }, 1000)

                            } else {
                                var obj = ev.currentTarget;
                                obj.disabled = true;
                                obj.innerHTML = '正在保存账户信息...';
                                $mdToast.show(
                                    $mdToast.simple()
                                        .textContent('账户新增失败,即将返回账户列表')
                                        .position('top right')
                                        .hideDelay(1000)
                                );
                                setTimeout(function () {
                                    $scope.coloseDialog();
                                }, 1000)
                            }


                        });
                    }
                }//新增账户
                //取消对话框
                $scope.cancelDialog = function () {
                    $mdDialog.cancel();
                }
                //关闭对话框
                $scope.coloseDialog = function () {
                    $mdDialog.hide();
                }
            }

            //删除管理员
            $scope.deleteAccount = function (ev, id) {
                var confirm = $mdDialog.confirm()
                    .title('是否删除此账户')
                    .targetEvent(ev)
                    .ok('确认')
                    .cancel('取消');

                $mdDialog.show(confirm).then(function () {

                    authSettingListService.deleteAdmin(id).then(function (data) {
                        if (data.msg == "success") {
                            $mdToast.show(
                                $mdToast.simple()
                                    .textContent('账号删除成功!')
                                    .position('top right')
                                    .hideDelay(3000)
                            );
                            if ($scope.cpn == $scope.pageTotal && $scope.accountList.dataList.length == 0) {
                                if ($scope.pno > 1) {
                                    $state.go('index.', {
                                            pageNo: $scope.pno - 1,
                                            pageSize: $scope.ps,
                                            searchObj: $stateParams.searchObj,
                                        },
                                        {
                                            reload: true
                                        });
                                } else {
                                    $state.go('index.auth-setting-list', {
                                            pageNo: $scope.pno,
                                            pageSize: $scope.ps,
                                            searchObj: $stateParams.searchObj,
                                        },
                                        {
                                            reload: true
                                        });
                                }
                            } else {
                                $state.go('index.auth-setting-list', {
                                        pageNo: $scope.pno,
                                        pageSize: $scope.ps,
                                        searchObj: $stateParams.searchObj,
                                    },
                                    {
                                        reload: true
                                    });
                            }
                        } else {
                            $mdToast.show(
                                $mdToast.simple()
                                    .textContent('账号删除失败!')
                                    .position('top right')
                                    .hideDelay(3000)
                            );
                        }

                    });

                })
            }

            $scope.goAuthSetting = function (id) {
                $state.go('index.auth-setting', {
                    id: id,
                    pageNo: $scope.pno,
                    pageSize: $scope.ps,
                    searchObj: $stateParams.searchObj,
                });
            }

        }]);

//用户登录验证
angular.module('app').controller('loginCtrl',
    ['$scope', '$state', '$log', 'authSettingListService', '$cookies', '$rootScope',
        function ($scope, $state, $log, authSettingListService, $cookies, $rootScope) {

            document.onkeydown = function () {
                if (event.keyCode === 13) {
                    document.getElementById('btnLogin').click();
                }
            };

            $scope.validLogin = function (login, ev) {
                var obj = ev.currentTarget;
                obj.disabled = true;
                obj.innerHTML = '正在登陆...';
                authSettingListService.adminLogin(login, 0).then(function (data) {
                    $scope.loginObj = login;
                    if (data.message === 'success') {
                        $scope.isFailedLogin = true;
                        $cookies.remove("navList");
                        $cookies.remove("login_admin");
                        $cookies.remove("days");
                        $cookies.remove("salesDays");
                        //清楚之前cookie
                        var now = new Date();
                        var expireDate = new Date(now);
                        expireDate.setSeconds(expireDate.getSeconds() + data.SESSION_TIME);//30分钟
                        $cookies.putObject("login_admin", data.loginUser[0], {'expires': expireDate});
                        if (data.pageButtons !== null || angular.equals({}, data.pageButtons)) {
                            $cookies.putObject("navList", data.pageButtons[0], {'expires': expireDate});
                        }
                        $state.go('index.main');
                    } else {
                        obj.innerHTML = data.msg;//'用户名或密码错误';
                        obj.style.color = '#f44330';
                        obj.disabled = true;
                        setTimeout(function () {
                            obj.innerHTML = '登陆';
                            obj.style.color = '#fff';
                            obj.disabled = false;
                        }, 2000)
                    }
                });
            };
        }]);


angular.module('app').controller('authSettingCtrl', ['$scope', '$rootScope', '$state', '$stateParams', '$mdToast', 'authSettingListService', function ($scope, $rootScope, $state, $stateParams, $mdToast, authSettingListService) {
    $scope.authSelect = function (flag, selectType) {

        $rootScope.selectPages(selectType, flag);
        if (selectType == 0) {
            $scope.auth.allOnePage = flag;
            $scope.auth.allFirstPage = flag;
            $scope.auth.allSecondPage = flag;
            $scope.auth.allThirdPage = flag;
            $scope.auth.allFourthPage = flag;
            $scope.auth.allFivePage = flag;
            $scope.auth.allSixPage = flag;
            $scope.auth.allSevenPage = flag;
        }
    }
    //权限赋初始值
    if ($stateParams.id != undefined) {
        authSettingListService.adminPermissionSet($stateParams.id).then(function (data) {
            $rootScope.auth = data.webPageButtonsModel;
            $rootScope.adminId = data.adminEntityModel.adminId;
            $rootScope.selectPages(null, null);

            //添加权限.修改
            $scope.savePermission = function (auth, adminId, ev) {
                authSettingListService.adminPermissionSave(auth, adminId).then(function (data) {
                    if (data.msg == 1) {
                        $mdToast.show(
                            $mdToast.simple()
                                .textContent('权限添加成功!')
                                .position('top right')
                                .hideDelay(3000)
                        );
                        $state.go('index.auth-setting-list', {
                                pageNo: $stateParams.pno != undefined ? $stateParams.pno : 1,
                                pageSize: $stateParams.ps != undefined ? $stateParams.ps : 10,
                                searchObj: $stateParams.searchObj != undefined ? $stateParams.searchObj : null,
                            },
                            {
                                reload: true
                            });
                    } else if (data.msg == 0) {
                        $mdToast.show(
                            $mdToast.simple()
                                .textContent('权限添加失败!')
                                .position('top right')
                                .hideDelay(3000)
                        );
                    }

                });
            }
        });
    }
    $rootScope.selectPages = function (selectType, boolean) {
        if (selectType != null || $rootScope.auth != null) {
            if ($rootScope.auth == undefined || $rootScope.auth == null)
                $rootScope.auth = [];
            /**
             * 首页
             */
            if (selectType == null || selectType == 0 || selectType == -1) {
                //会员统计
                $scope.auth.pageSecondNameF0_S0 = selectType != null ? boolean : $scope.checkboxPages('F0_S0');//查看

            }
            /**
             * 会员
             */
            if (selectType == null || selectType == 0 || selectType == 1) {
                //会员统计
                $scope.auth.pageSecondNameF1_S1 = selectType != null ? boolean : $scope.checkboxPages('F1_S1');//查看
                //会员入场
                $scope.auth.pageSecondNameF1_S2 = selectType != null ? boolean : $scope.checkboxPages('F1_S2');//查看
                $scope.auth.buttonsF1_S2S = selectType != null ? boolean : $scope.checkboxButtons('F1_S2S');//查询
                $scope.auth.buttonsF1_S2E = selectType != null ? boolean : $scope.checkboxButtons('F1_S2E');//导出
                $scope.auth.buttonsF1_S2L = selectType != null ? boolean : $scope.checkboxButtons('F1_S2L');//查看
                $scope.auth.buttonsF1_S2A = selectType != null ? boolean : $scope.checkboxButtons('F1_S2A');//添加
                $scope.auth.buttonsF1_S2G = selectType != null ? boolean : $scope.checkboxButtons('F1_S2G');//离场
                //会员列表
                $scope.auth.pageSecondNameF1_S3 = selectType != null ? boolean : $scope.checkboxPages('F1_S3');//查看
                $scope.auth.buttonsF1_S3S = selectType != null ? boolean : $scope.checkboxButtons('F1_S3S');//查询
                $scope.auth.buttonsF1_S3E = selectType != null ? boolean : $scope.checkboxButtons('F1_S3E');//导出
                $scope.auth.buttonsF1_S3A = selectType != null ? boolean : $scope.checkboxButtons('F1_S3A');//添加
                $scope.auth.buttonsF1_S3L = selectType != null ? boolean : $scope.checkboxButtons('F1_S3L');//查看
                $scope.auth.buttonsF1_S3U = selectType != null ? boolean : $scope.checkboxButtons('F1_S3U');//编辑
                //即将到期会员
                $scope.auth.pageSecondNameF1_S4 = selectType != null ? boolean : $scope.checkboxPages('F1_S4');//查看;
                $scope.auth.buttonsF1_S4S = selectType != null ? boolean : $scope.checkboxButtons('F1_S4S');//查询
                $scope.auth.buttonsF1_S4E = selectType != null ? boolean : $scope.checkboxButtons('F1_S4E');//导出
                $scope.auth.buttonsF1_S4Sd = selectType != null ? boolean : $scope.checkboxButtons('F1_S4Sd');//群发
                $scope.auth.buttonsF1_S4L = selectType != null ? boolean : $scope.checkboxButtons('F1_S4L');//查看
                $scope.auth.buttonsF1_S4U = selectType != null ? boolean : $scope.checkboxButtons('F1_S4U');//编辑
                //已到期会员
                $scope.auth.pageSecondNameF1_S5 = selectType != null ? boolean : $scope.checkboxPages('F1_S5');//查看
                $scope.auth.buttonsF1_S5S = selectType != null ? boolean : $scope.checkboxButtons('F1_S5S');//查询
                $scope.auth.buttonsF1_S5E = selectType != null ? boolean : $scope.checkboxButtons('F1_S5E');//导出
                $scope.auth.buttonsF1_S5Sd = selectType != null ? boolean : $scope.checkboxButtons('F1_S5Sd');//群发
                $scope.auth.buttonsF1_S5L = selectType != null ? boolean : $scope.checkboxButtons('F1_S5L');//查看
                $scope.auth.buttonsF1_S5U = selectType != null ? boolean : $scope.checkboxButtons('F1_S5U');//编辑
                //会员生日
                $scope.auth.pageSecondNameF1_S6 = selectType != null ? boolean : $scope.checkboxPages('F1_S6');//查看
                $scope.auth.buttonsF1_S6S = selectType != null ? boolean : $scope.checkboxButtons('F1_S6S');//查询
                $scope.auth.buttonsF1_S6E = selectType != null ? boolean : $scope.checkboxButtons('F1_S6E');//导出
                $scope.auth.buttonsF1_S6Sd = selectType != null ? boolean : $scope.checkboxButtons('F1_S6Sd');//群发
                $scope.auth.buttonsF1_S6W = selectType != null ? boolean : $scope.checkboxButtons('F1_S6W');//祝福短信
                //会员卡处理
                $scope.auth.pageSecondNameF1_S7 = selectType != null ? boolean : $scope.checkboxPages('F1_S7');//查看
                $scope.auth.buttonsF1_S7S = selectType != null ? boolean : $scope.checkboxButtons('F1_S7S');//查询
                $scope.auth.buttonsF1_S7E = selectType != null ? boolean : $scope.checkboxButtons('F1_S7E');//导出
                $scope.auth.buttonsF1_S7A = selectType != null ? boolean : $scope.checkboxButtons('F1_S7A');//新增
                $scope.auth.buttonsF1_S7L = selectType != null ? boolean : $scope.checkboxButtons('F1_S7L');//查看
                $scope.auth.buttonsF1_S7U = selectType != null ? boolean : $scope.checkboxButtons('F1_S7U');//编辑
            }
            /**
             * 会员卡交易
             */
            if (selectType == null || selectType == 0 || selectType == 2) {
                //会员统计
                $scope.auth.pageSecondNameF2_S1 = selectType != null ? boolean : $scope.checkboxPages('F2_S1');//查看
                ////会员卡交易记录
                //$scope.auth.pageSecondNameF2_S2 = selectType != null ? boolean : $scope.checkboxPages('F2_S2');//查看
                //$scope.auth.buttonsF2_S2S = selectType != null ? boolean : $scope.checkboxButtons('F2_S2S');//查询
                //$scope.auth.buttonsF2_S2E = selectType != null ? boolean : $scope.checkboxButtons('F2_S2E');//导出
                //$scope.auth.buttonsF2_S2A = selectType != null ? boolean : $scope.checkboxButtons('F2_S2A');//新增
                //$scope.auth.buttonsF2_S2Rd = selectType != null ? boolean : $scope.checkboxButtons('F2_S2Rd');//退款
                //$scope.auth.buttonsF2_S2L = selectType != null? boolean : $scope.checkboxButtons('F2_S2L');//查看
                //会员充值排行榜
                $scope.auth.pageSecondNameF2_S2 = selectType != null ? boolean : $scope.checkboxPages('F2_S2');//查看
                $scope.auth.buttonsF2_S2S = selectType != null ? boolean : $scope.checkboxButtons('F2_S2S');//查询
                $scope.auth.buttonsF2_S2E = selectType != null ? boolean : $scope.checkboxButtons('F2_S2E');//导出
            }
            /**
             * 储物柜
             */
            if (selectType == null || selectType == 0 || selectType == 3) {

                //储物柜出租
                $scope.auth.pageSecondNameF3_S1 = selectType != null ? boolean : $scope.checkboxPages('F3_S1');//查看
                $scope.auth.buttonsF3_S1S = selectType != null ? boolean : $scope.checkboxButtons('F3_S1S');//查询
                $scope.auth.buttonsF3_S1E = selectType != null ? boolean : $scope.checkboxButtons('F3_S1E');//导出
                $scope.auth.buttonsF3_S1A = selectType != null ? boolean : $scope.checkboxButtons('F3_S1A');//新增
                $scope.auth.buttonsF3_S1Rd = selectType != null ? boolean : $scope.checkboxButtons('F3_S1Rd');//退柜
                $scope.auth.buttonsF3_S1U = selectType != null ? boolean : $scope.checkboxButtons('F3_S1U');//编辑
                //储物柜设置
                $scope.auth.pageSecondNameF3_S2 = selectType != null ? boolean : $scope.checkboxPages('F3_S2');//查看
                $scope.auth.buttonsF3_S2S = selectType != null ? boolean : $scope.checkboxButtons('F3_S2S');//查询
                $scope.auth.buttonsF3_S2E = selectType != null ? boolean : $scope.checkboxButtons('F3_S2E');//导出
                $scope.auth.buttonsF3_S2A = selectType != null ? boolean : $scope.checkboxButtons('F3_S2A');//新增
                $scope.auth.buttonsF3_S2D = selectType != null ? boolean : $scope.checkboxButtons('F3_S2D');//删除
                $scope.auth.buttonsF3_S2U = selectType != null ? boolean : $scope.checkboxButtons('F3_S2U');//编辑
                //储物柜出租记录
                $scope.auth.pageSecondNameF3_S3 = selectType != null ? boolean : $scope.checkboxPages('F3_S3');//查看
                $scope.auth.buttonsF3_S3S = selectType != null ? boolean : $scope.checkboxButtons('F3_S3S');//查询
                $scope.auth.buttonsF3_S3E = selectType != null ? boolean : $scope.checkboxButtons('F3_S3E');//导出
            }
            /**
             * 教练管理
             */
            if (selectType == null || selectType == 0 || selectType == 4) {
                //私教购买记录
                $scope.auth.pageSecondNameF4_S1 = selectType != null ? boolean : $scope.checkboxPages('F4_S1');//查看
                $scope.auth.buttonsF4_S1S = selectType != null ? boolean : $scope.checkboxButtons('F4_S1S');//查询
                $scope.auth.buttonsF4_S1A = selectType != null ? boolean : $scope.checkboxButtons('F4_S1A');//新增
                $scope.auth.buttonsF4_S1L = selectType != null ? boolean : $scope.checkboxButtons('F4_S1L');//查看
                $scope.auth.buttonsF4_S1U = selectType != null ? boolean : $scope.checkboxButtons('F4_S1U');//修改时间
                //私教卡设置
                $scope.auth.pageSecondNameF4_S2 = selectType != null ? boolean : $scope.checkboxPages('F4_S2');//查看
                $scope.auth.buttonsF4_S2S = selectType != null ? boolean : $scope.checkboxButtons('F4_S2S');//查询
                $scope.auth.buttonsF4_S2E = selectType != null ? boolean : $scope.checkboxButtons('F4_S2E');//导出
                $scope.auth.buttonsF4_S2A = selectType != null ? boolean : $scope.checkboxButtons('F4_S2A');//新增
                $scope.auth.buttonsF4_S2D = selectType != null ? boolean : $scope.checkboxButtons('F4_S2D');//删除
                $scope.auth.buttonsF4_S2U = selectType != null ? boolean : $scope.checkboxButtons('F4_S2U');//编辑
                //私教签课记录
                $scope.auth.pageSecondNameF4_S3 = selectType != null ? boolean : $scope.checkboxPages('F4_S3');//查看
                $scope.auth.buttonsF4_S3S = selectType != null ? boolean : $scope.checkboxButtons('F4_S3S');//查询
                $scope.auth.buttonsF4_S3E = selectType != null ? boolean : $scope.checkboxButtons('F4_S3E');//导出
                $scope.auth.buttonsF4_S3A = selectType != null ? boolean : $scope.checkboxButtons('F4_S3A');//新增
                $scope.auth.buttonsF4_S3D = selectType != null ? boolean : $scope.checkboxButtons('F4_S3D');//撤销
                $scope.auth.buttonsF4_S3L = selectType != null ? boolean : $scope.checkboxButtons('F4_S3L');//查看
                //私教购买排行榜
                $scope.auth.pageSecondNameF4_S4 = selectType != null ? boolean : $scope.checkboxPages('F4_S4');//查看
                $scope.auth.buttonsF4_S4S = selectType != null ? boolean : $scope.checkboxButtons('F4_S4S');//查询
                $scope.auth.buttonsF4_S4E = selectType != null ? boolean : $scope.checkboxButtons('F4_S4E');//导出
                $scope.auth.buttonsF4_S4L = selectType != null ? boolean : $scope.checkboxButtons('F4_S4L');//查看详情
            }
            /**
             * 销售管理
             */
            if (selectType == null || selectType == 0 || selectType == 5) {
                //销售业绩数据统计
                $scope.auth.pageSecondNameF5_S1 = selectType != null ? boolean : $scope.checkboxPages('F5_S1');//查看
                //销售业绩记录
                $scope.auth.pageSecondNameF5_S2 = selectType != null ? boolean : $scope.checkboxPages('F5_S2');//查看
                $scope.auth.buttonsF5_S2S = selectType != null ? boolean : $scope.checkboxButtons('F5_S2S');//查询
                $scope.auth.buttonsF5_S2E = selectType != null ? boolean : $scope.checkboxButtons('F5_S2E');//导出
                $scope.auth.buttonsF5_S2L = selectType != null ? boolean : $scope.checkboxButtons('F5_S2L');//查看
            }
            /**
             * 基础信息
             */
            if (selectType == null || selectType == 0 || selectType == 6) {
                //投诉列表
                $scope.auth.pageSecondNameF6_S1 = selectType != null ? boolean : $scope.checkboxPages('F6_S1');//查看
                $scope.auth.buttonsF6_S1S = selectType != null ? boolean : $scope.checkboxButtons('F6_S1S');//查询
                $scope.auth.buttonsF6_S1E = selectType != null ? boolean : $scope.checkboxButtons('F6_S1E');//导出
                $scope.auth.buttonsF6_S1A = selectType != null ? boolean : $scope.checkboxButtons('F6_S1A');//新增
                $scope.auth.buttonsF6_S1U = selectType != null ? boolean : $scope.checkboxButtons('F6_S1U');//编辑
                $scope.auth.buttonsF6_S1D = selectType != null ? boolean : $scope.checkboxButtons('F6_S1D');//删除
                //会员卡列表
                $scope.auth.pageSecondNameF6_S2 = selectType != null ? boolean : $scope.checkboxPages('F6_S2');//查看
                $scope.auth.buttonsF6_S2S = selectType != null ? boolean : $scope.checkboxButtons('F6_S2S');//查询
                $scope.auth.buttonsF6_S2E = selectType != null ? boolean : $scope.checkboxButtons('F6_S2E');//导出
                $scope.auth.buttonsF6_S2A = selectType != null ? boolean : $scope.checkboxButtons('F6_S2A');//新增
                $scope.auth.buttonsF6_S2D = selectType != null ? boolean : $scope.checkboxButtons('F6_S2D');//删除
                $scope.auth.buttonsF6_S2U = selectType != null ? boolean : $scope.checkboxButtons('F6_S2U');//编辑
            }
            /**
             * 系统设置
             */
            if (selectType == null || selectType == 0 || selectType == 7) {
                //投诉列表
                $scope.auth.pageSecondNameF7_S2 = selectType != null ? boolean : $scope.checkboxPages('F7_S2');//查看
                $scope.auth.buttonsF7_S2S = selectType != null ? boolean : $scope.checkboxButtons('F7_S2S');//查询
                $scope.auth.buttonsF7_S2E = selectType != null ? boolean : $scope.checkboxButtons('F7_S2E');//导出
                $scope.auth.buttonsF7_S2A = selectType != null ? boolean : $scope.checkboxButtons('F7_S2A');//新增
                $scope.auth.buttonsF7_S2U = selectType != null ? boolean : $scope.checkboxButtons('F7_S2U');//编辑
                //后台日志
                $scope.auth.pageSecondNameF7_S4 = selectType != null ? boolean : $scope.checkboxPages('F7_S4');//查看
                $scope.auth.buttonsF7_S4S = selectType != null ? boolean : $scope.checkboxButtons('F7_S4S');//查询
                $scope.auth.buttonsF7_S4E = selectType != null ? boolean : $scope.checkboxButtons('F7_S4E');//导出
                $scope.auth.buttonsF7_S4D = selectType != null ? boolean : $scope.checkboxButtons('F7_S4D');//新增
            }
        }
    }
    //页面复选框
    $scope.checkboxPages = function (content) {
        if ($rootScope.auth.pageSecondName != null && $rootScope.auth.pageSecondName.indexOf(content) >= 0)//查看
            return true;
        else return false;
    }
    //按钮复选框
    $scope.checkboxButtons = function (content) {
        if ($rootScope.auth.buttons != null) {
            if ($rootScope.auth.buttons.indexOf(content) >= 0) {//查询
                return true;
            } else return false;
        }
        return false;
    }
}]);