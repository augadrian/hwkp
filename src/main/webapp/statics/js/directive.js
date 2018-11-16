app.directive('tablescroll', function () {
    return {
        restrict: 'AE',
        link: function (scope, element) {
            var bodyHeight = document.body.clientHeight;
            var elHeight = bodyHeight - 356 - 90;
            element.css('height', elHeight);
        }
    }
});
app.directive('listcroll', function () {
    return {
        restrict: 'AE',
        link: function (scope, element) {
            var bodyHeight = document.body.clientHeight;
            var elHeight = bodyHeight - 356 - 24;
            element.css('height', elHeight);
        }
    }
});
app.directive('scroll', function () {
    return {
        restrict: 'AE',
        link: function (scope, element) {
            var bodyHeight = document.body.clientHeight;
            var elHeight = bodyHeight + 64;
            element.css('height', elHeight);
        }
    }
});
app.directive('tabscontentcroll', function () {
    return {
        restrict: 'AE',
        link: function (scope, element) {
            var bodyHeight = document.body.clientHeight;
            console.log(bodyHeight);
            var elHeight = bodyHeight - 64 * 5;
            element.css('height', elHeight);
        }
    }
});
app.directive('panelcontentscroll', function () {
    return {
        restrict: 'AE',
        link: function (scope, element) {
            var bodyHeight = angular.element('.member-detail-panel').height();
            var elHeight = bodyHeight-64-48;
            element.css('height', elHeight);
        }
    }
});
app.directive('panellistcontentscroll', function () {
    return {
        restrict: 'AE',
        link: function (scope, element) {
            var bodyHeight = angular.element('.member-detail-panel').height();
            var elHeight = bodyHeight-64*2-48;
            element.css('height', elHeight);
        }
    }
});
app.directive('dialogscroll', function () {
    return {
        restrict: 'AE',
        link: function (scope, element) {
            var bodyHeight = document.body.clientHeight;
            console.log(bodyHeight);
            var elHeight = bodyHeight - 64 * 4;
            element.css('height', elHeight);
        }
    }
});
app.directive('panelscroll', function () {
    return {
        restrict: 'AE',
        link: function (scope, element) {
            var bodyHeight = document.body.clientHeight;
            console.log(bodyHeight);
            var elHeight = bodyHeight - 64;
            element.css('height', elHeight);
        }
    }
});


//会所编号是否已存在
app.directive('storenumifexist', function (storeService, $q) {
    return {
        restrict: 'AE',
        require: 'ngModel',
        link: function (scope, element, attributes, ngModel) {
            ngModel.$asyncValidators.storenumifexist = function (modelValue) {
                var store = {storeId: scope.storeID, storeNum: modelValue};
                return storeService.checkStoreNumIsExist(store).then(function (data) {
                    console.log(data.msg);
                    if (data.msg == 'exist') {
                        return $q.reject('exist');
                    } else {
                        return $q.resolve('no_exist');
                    }
                })
            }
        }
    }
})

/**
 * 判断充值卡号是否存在
 */
app.directive('rechargeinfodata', function (CardRecordListService, $q, $stateParams) {
    return {
        restrict: 'AE',
        require: 'ngModel',
        link: function (scope, element, attributes, ngModel) {
            ngModel.$asyncValidators.rechargeinfodata = function (modelValue) {
                return CardRecordListService.getRecharge(modelValue).then(function (data) {
                    if (data == null) {
                        return $q.reject('exist');
                    } else {
                        return $q.resolve('no_exist');
                    }
                })
            }
        }
    }
})

//储物号是否已存在
app.directive('lockernumifexist', function (lockerService, $q) {
    return {
        restrict: 'AE',
        require: 'ngModel',
        link: function (scope, element, attributes, ngModel) {
            ngModel.$asyncValidators.lockernumifexist = function (modelValue) {
                return lockerService.changelockerNoData(modelValue).then(function (data) {
                    console.log(data)
                    if (data == "error") {
                        return $q.reject('exist');
                    } else {
                        return $q.resolve('no_exist');
                    }
                })
            }
        }
    }
});

//验证卡种编号是否存在
app.directive('checkcardnoexist',function(memberCardListService,$q){
   return {
       restrict:'AE',
       require:'ngModel',
       link:function(scope,element,attributes,ngModel){
           ngModel.$asyncValidators.checkcardnoexist=function(modelValue){
               return memberCardListService.findCardByCardNo(modelValue,scope.card.cardId).then(function(data){
                   if(data=='0'){
                       return $q.reject('exist');
                   }else{
                       return $q.resolve('no_exist');
                   }
               })
           }
       }
   }
});

//分页
app.directive('page', function () {
    return {
        restrict: 'AE',
        replace: true,
        templateUrl: ' template/page.html',
        link: function ($scope, elem, attrs) {
            $scope.pageSize = $scope.ps;//从控制器获取每页显示记录数
            $scope.currentPageNo = 1;//设置当前页页码初始值
            $scope.$on(attrs.method, function () {
                $scope.pageData = $scope[attrs.method];//从指令属性中获取数据
                $scope.pages = [];
                $scope.itemCount = $scope.pageData.itemCount;//获取总记录数
                $scope.pageTotal = Math.ceil($scope.pageData.itemCount / $scope.pageSize);//获取总页数
                $scope.cpn = parseInt($scope.cpn);
                $scope.getPage = function () {
                    if ($scope.pageTotal <= 7) {
                        for (var i = 1; i < $scope.pageTotal + 1; i++) {
                            $scope.pages.push(i);
                        }
                    } else if ($scope.cpn < 4) {
                        $scope.pages = [1, 2, 3, 4, 5, '...', $scope.pageTotal];
                    } else if (($scope.pageTotal - $scope.cpn) <= 3) {
                        $scope.pages = [
                            $scope.pageTotal - 6,
                            $scope.pageTotal - 5,
                            $scope.pageTotal - 4,
                            $scope.pageTotal - 3,
                            $scope.pageTotal - 2,
                            $scope.pageTotal - 1,
                            $scope.pageTotal
                        ]
                    } else {
                        $scope.pages = [
                            $scope.cpn - 2,
                            $scope.cpn - 1,
                            $scope.cpn,
                            $scope.cpn + 1,
                            $scope.cpn + 2,
                            '...',
                            $scope.pageTotal
                        ]
                    }
                }
                $scope.getPage();
            })
        }
    }
})

//账号是否存在
app.directive('isaccountnameavailable', function (authSettingListService, $q) {
    return {
        restrict: 'AE',
        require: 'ngModel',
        link: function (scope, element, attributes, ngModel) {
            ngModel.$asyncValidators.isaccountnameavailable = function (modelValue) {
                var adminName = {adminId: scope.adminId, adminName: modelValue};
                return authSettingListService.checkMangerExist(adminName.adminName, scope.updateAccountPage).then(function (data) {
                    if (data.msg == 'exist') {
                        return $q.reject('exist');
                    } else {
                        return $q.resolve('no_exist');
                    }
                })
            }
        }
    }
});

//获取会所列表
app.directive('belongstoreselect', function ($q, storeService,$cookies,$location) {
    var now = new Date();
    var expireDate = new Date(now);
    expireDate.setSeconds(expireDate.getSeconds() +60*30);
    return {
        restrict: 'AE',
        replace: true,
        scope: {
            selecttype: '='
        },
        templateUrl: 'template/belong-store.html',
        link: function (scope) {
            if($cookies.getObject("login_admin")!=null){
                scope.storeID=$cookies.getObject("login_admin").storeIds;
                scope.adminRole=$cookies.getObject("login_admin").adminRole;
                //console.log('cookes:'+scope.storeID);
            }
            scope.$on("updateAccount",function (event,da) {//权限更新账户
                  $cookies.putObject("update",da, {'expires': expireDate});
            });
            storeService.getStoreList(0, 0, null).then(function (data) {
                var routeUrls=['/member-card-process-list','/login','privately-purchase-list','privately-sign-list','sales-record-list','member-card-list','employee-list','auth-setting-list'];
                for(var i=0;i<routeUrls.length;i++){
                    if($location.path().indexOf(routeUrls[i])>=0){
                        scope.showAllStore="login";
                    }
                }
                    scope.$on("addSign",function (event,da) {
                        if(da=='addSign')
                            $cookies.putObject("addSign","addSign", {'expires': expireDate});
                    });
                    if($cookies.getObject("addSign")=='addSign')
                        scope.showAllStore='';
                if($cookies.getObject("update")!=undefined){
                    scope.belongStore=$cookies.getObject("update");
                    scope.permissionStore=1;
                }

                $cookies.remove("addSign");
                $cookies.remove("update");
                scope.dataList = data;
            })
        }
    }
})

//全局搜索
app.directive('globalsearch', function (globalSearchService,$state) {
    return {
        restrict: 'AE',
        replace: true,
        templateUrl: 'template/global-search.html',
        link: function (scope) {
            scope.searchInptChange = function (val) {
                scope.resultData='';
                globalSearchService.globalSearching(val).then(function(data){
                    scope.hasData=true;
                    scope.noResult=data.msg;//状态码
                    scope.resultData=data.globalSearchResult;//结果集
                    if(val==''){
                        scope.resultData='';
                        scope.hasData=false;
                    }
                });

            }
            //点击任意处关闭菜单
            angular.element(document).bind('click', function () {
                $('#noResult').hide();
                scope.cloaseGlobalSearch();
                scope.hasData=false;
                scope.$apply();
            })
            //跳转会员列表
            scope.jumpMemberList=function(cardNo){
                $state.go('index.member-list',{pageNo:1,pageSize:10,searchObj:angular.toJson({cardNo:cardNo})})
            }
            //跳转会员卡交易列表
            scope.jumpMemberTradeList=function(cardNo){
                $state.go('index.member-trade-list',{pageNo:1,pageSize:10,searchObj:angular.toJson({c_cardNo:cardNo})})
            }
            //跳转储物柜出租列表
            scope.jumpLockerRenList=function(lockerNo){
                $state.go('index.locker-list',{pageNo:1,pageSize:10,searchObj:angular.toJson({lockerNo:lockerNo})})
            }
            //跳转储物柜设置列表
            scope.jumpLockerSettingList=function(lockerNo){
                $state.go('index.locker-setting-list',{pageNo:1,pageSize:10,searchObj:angular.toJson({lockerNo:lockerNo})})
            }
            //跳转私教购买列表
            scope.jumpPrivatelyBuyList=function(memberName){
                $state.go('index.privately-purchase-list',{pageNo:1,pageSize:10,searchObj:angular.toJson({memberName:memberName})})
            }
            //跳转私教卡设置列表
            scope.jumpPrivateCourseCardList=function(privatelyClassName){
                $state.go('index.privately-class-setting',{pageNo:1,pageSize:10,searchObj:angular.toJson({privatelyClassName:privatelyClassName})})
            }
            //跳转销售业绩列表
            scope.jumpSalesPerformanceList=function(){
                //TODO
                $state.go('index.sales-record-index',{pageNo:1,pageSize:10,searchObj:angular.toJson({})})
            }
            //跳转投诉列表
            scope.jumpComplaintList=function(name){
                $state.go('index.complaint-list',{pageNo:1,pageSize:10,searchObj:angular.toJson({cp_name:name})})
            }
            //跳转会员卡列表
            scope.jumpMemberCardList=function(cardNo){
                $state.go('index.member-card-list',{pageNo:1,pageSize:10,searchObj:angular.toJson({cardNo:cardNo})})
            }
            //跳转人事档案列表
            scope.jumpEmployeeList=function(employeeName){
                $state.go('index.employee-list',{pageNo:1,pageSize:10,searchObj:angular.toJson({employeeName:employeeName})})
            }
            //跳转到菜单
            scope.jumpMenu=function(router){
                $state.go(router,{pageNo:1,pageSize:10});
            }
        }
    }
})

//上传头像
app.directive('uploadavatar', function (uploadService,$mdToast,$mdDialog,$stateParams,$timeout,memberService) {
    return {
        restrict: 'AE',
        replace: true,
        require:'ngModel',
        scope: {
            fileread: '=',
            filetype: '=',
            filesize:'=',
            uploadpath: '='
        },
        templateUrl: 'template/upload-avatar.html',
        link: function (scope, elem, attrs,ngModel) {
            var uploadPath=attrs.uploadpath;//获取上传的路径
            scope.defaultAvatarUrl='../../statics/images/icon/icon_default_avatar.svg';

            /*编辑时获取头像*/
            if ($stateParams.id > 0||$stateParams.eid > 0) {
                ngModel.$render = function() {
                    if(ngModel.$viewValue===undefined||ngModel.$viewValue===''||ngModel.$viewValue===scope.defaultAvatarUrl){
                        scope.avatarUrl=scope.defaultAvatarUrl;
                        scope.enableDelete=true;
                    }else{
                        scope.avatarUrl=ngModel.$viewValue;
                        scope.enableDelete=false;
                    }
                };
            }else{
                scope.avatarUrl=scope.defaultAvatarUrl;
            }

            /*删除用户头像*/
            scope.deleteMemberAvatar=function () {
                memberService.deleteMemberAvatar($stateParams.id).then(function (response) {
                    if(response.status===200){
                        scope.avatarUrl=scope.defaultAvatarUrl;
                        ngModel.$setViewValue(scope.avatarUrl);
                        scope.enableDelete=true;
                        $mdToast.show(
                            $mdToast.simple()
                                .textContent('头像删除成功')
                                .position('top right')
                                .hideDelay(2000)
                        );
                    }
                })
            };

            //拍照上传
            scope.snapPhoto=function(ev){
                $mdDialog.show({
                    controller: uploadAvatarCtrl,
                    templateUrl: 'template/camera.html',
                    parent: angular.element(document.body),
                    targetEvent: ev,
                    clickOutsideToClose: false
                }).then(function (img) {
                    scope.avatarUrl=img;
                })
                //location.href = "template/camera.html";
            };

            function uploadAvatarCtrl(scope) {
                scope.type = '拍照';
                $timeout(function(){
                    var canvas=document.getElementById('canvas'),
                        context=canvas.getContext('2d'),
                        video=document.getElementById('video'),
                        videoObj={'video':true},
                        errBack=function(error){
                            console.log('video capture error:',error.code);
                        }
                    navigator.myGetUserMedia=navigator.getUserMedia||navigator.webkitGetUserMedia||navigator.mozGetUserMedia||navigator.msGetUserMedia;

                    navigator.myGetUserMedia(videoObj,function(localMediaStream){
                        /*并不是每个window都有URL对象,要加上浏览器前缀
                         **video.src=window.URL.createObjectURL(localMediaStream);
                         * */
                        window.URL=window.URL||window.webkitURL||window.mozURL||window.msURL;
                        video.src=window.URL.createObjectURL(localMediaStream);
                        video.play();
                    },errBack);

                    document.getElementById("picture").addEventListener("click", function () {
                        context.drawImage(video, 0, 0, 360, 270);
                    });
                });

                scope.upData=function(img){
                     var canvans = document.getElementById("canvas");
                     var imgData = canvans.toDataURL();
                     var base64Data = imgData.substr(22);
                        uploadService.photoUpload(base64Data,uploadPath).then(function(data){
                        var mes=angular.fromJson(data);
                        if(mes.status=="200"){
                            $mdToast.show(
                                $mdToast.simple()
                                    .textContent('头像上传成功')
                                    .position('top right')
                                    .hideDelay(2000)
                            );
                            img=mes.imagePath;
                            scope.hideDialog(img);
                            ngModel.$setViewValue(img);
                        }else{
                            $mdToast.show(
                                $mdToast.simple()
                                    .textContent('上传失败')
                                    .position('top right')
                                    .hideDelay(2000)
                            );
                            scope.hideDialog();
                        }
                    })
                };
                //取消对话框
                scope.cancelDialog = function () {
                    $mdDialog.cancel();
                };
                //关闭对话框
                scope.hideDialog = function (img) {
                    $mdDialog.hide(img);
                    scope.avatarUrl=img;
                };
            }

            if(attrs.uploadpath==''||attrs.filetype==''||attrs.filesize==''){
                $mdToast.show(
                    $mdToast.simple()
                        .textContent('指令参数有误!')
                        .position('top right')
                        .hideDelay(2000)
                );
                scope.uploadAvatarValid=true;
            }

            elem.find('input').bind('change', function (ev) {
                scope.$apply(function () {
                    var fileread = ev.target.files[0];//获取上传文件对象
                    var fileSize=(fileread.size/102400)/100;//转换文件大小
                    var allowfiletype=attrs.filetype;//获取允许上传的文件类型
                    var allowfileSize=attrs.filesize;//获取允许上传的文件大小
                    var extension=fileread.name.substring(fileread.name.lastIndexOf(".")+1,fileread.name.length);
                    if(allowfiletype.indexOf(extension)<0){
                        console.log(allowfiletype.indexOf(extension));
                        $mdToast.show(
                            $mdToast.simple()
                                .textContent('上传的文件格式仅支持'+allowfiletype+'!')
                                .position('top right')
                                .hideDelay(2000)
                        );
                    }else if(fileSize>allowfileSize){
                        $mdToast.show(
                            $mdToast.simple()
                                .textContent('上传的文件大小仅允许在'+allowfileSize+'M以内!')
                                .position('top right')
                                .hideDelay(2000)
                        );
                    }
                    else{
                        scope.uploadAvatarLoading=true;
                        scope.uploadAvatarValid=true;
                        uploadService.uploadFile(fileread,uploadPath).then(function (data) {
                            if(data.status==1){
                                scope.enableDelete=false;
                                scope.avatarUrl=data.finalFileName;
                                ngModel.$setViewValue(data.finalFileName);
                                scope.uploadAvatarLoading=false;
                                scope.uploadAvatarValid=false;
                                $mdToast.show(
                                    $mdToast.simple()
                                        .textContent('头像上传成功')
                                        .position('top right')
                                        .hideDelay(2000)
                                );
                            }
                        },function () {
                            scope.uploadAvatarLoading=false;
                            $mdToast.show(
                                $mdToast.simple()
                                    .textContent('上传头像失败，请重试！')
                                    .position('top right')
                                    .hideDelay(2000)
                            );
                        })
                    }
                });
            })
        }
    }
})
//检测登陆
app.directive('loginaccountcheck', function ($q, authSettingListService) {
    return {
        restrict: 'AE',
        require: 'ngModel',
        link: function (scope, element, attributes, ngModel) {
            ngModel.$asyncValidators.loginaccountcheck = function (modelValue) {
                var login = {
                    userName: scope.login.userName,
                    passWord: modelValue,
                    belongStore: scope.login.belongStore
                };
                return authSettingListService.adminLogin(login,1).then(function (data) {
                    //console.log(data.msg)
                    scope.msg = data.msg;
                    if (data.msg == 'success') {
                        return $q.resolve('success');
                    } else {
                        return $q.reject('no_exist');
                    }
                })

            }
        }
    }
})
//检测员工工号是否存在
app.directive('jobnumberexist', function ($q, employeeService) {
    return {
        restrict: 'AE',
        require: 'ngModel',
        link: function (scope, element, attributes, ngModel) {
            ngModel.$asyncValidators.jobnumberexist = function (modelValue) {
                return employeeService.checkJobNumberExist(modelValue, scope.employee.id).then(function (data) {
                    if (data.msg == '0') {
                        return $q.resolve('0');
                    } else {
                        return $q.reject('1');
                    }
                })

            }
        }
    }
})

/*转课次数是否大于课时*/
app.directive('transferCount', function () {
    return {
        restrict: 'AE',
        require: 'ngModel',
        link: function (scope, element, attr, ngModel) {
            $(element).bind('input',function () {
                var compareObj=scope.$eval(attr.compareTo);
                ngModel.$validators.isLarge = function(value) {
                    if(value>parseInt(compareObj)){
                        return false;
                    }else{
                        return true;
                    }
                }
            })
        }
    }
})

