angular.module('app').controller('mainCtrl', ['$scope', '$rootScope', '$mdSidenav', '$log', '$cookies',
    '$state', 'authSettingListService','$location','authSettingListService','$timeout','$mdDialog',

    function ($scope, $rootScope, $mdSidenav, $log, $cookies, $state, authSettingListService,$location,authSettingListService,$timeout
        ,memberListService,lockerService,employeeListService,memberService,$mdDialog) {
        // 登陆过期
        $scope.againLogin=function () {//重新d登陆
            $state.go("login");
        };

        setInterval(function(){//监控cookie过期
            var overCookie=$cookies.getObject("login_admin");
            if(overCookie==null||angular.equals({},overCookie)){
                $scope.isAgainLogin=true;
                $scope.login_admin="";
                $state.go("login");
            }
        },10);//1分钟
        this.openMenu = function ($mdOpenMenu) {
            $mdOpenMenu();
        };

        //侧边栏展现与隐藏
        $scope.isSideNavOpen = true;
        $scope.sideNavVisible = false;
        $scope.sideNavTooltip = "关闭左侧菜单";
        $scope.toggleSideNav = function () {
            $scope.sideNavVisible = !$scope.sideNavVisible;
            !$scope.sideNavVisible ? $scope.sideNavTooltip = "关闭左侧菜单" : $scope.sideNavTooltip = "打开左侧菜单";
        };



        //显示系统设置菜单
        $scope.toggleSystemSettingPanel=function (ev) {
            $scope.systemSettingPanelShow='show';
            ev.stopPropagation();
        };

        $scope.cloaseGlobalSearch = function () {
            $scope.toggleGlobalSearch = false;
            $scope.hasData=false;
        };

        //点击任意处关闭菜单
        angular.element(document).bind('click', function () {
            $scope.systemSettingPanelShow='';
            $scope.$apply();
        });

        //管理员
        $scope.login_admin = $cookies.getObject("login_admin");
        $scope.test=function () {
            $scope.width=90;
        };

        $scope.loginHavePermission=$cookies.getObject("navList");
        var permission= $scope.loginHavePermission;
        if(permission!=undefined){
            $scope.navList = [
                {
                    navName:permission.navName.indexOf("F1")>=0?'会员管理':"",
                    subNavList: [
                        {
                            subNavName: permission.subNavName.indexOf("F1_S1")>=0?'会员数据统计':'',
                            subNavIcon: permission.subNavName.indexOf("F1_S1")>=0?'icon-member-index':"",
                            subNavUrl: 'index.member-index'
                        },
                        {
                            subNavName: permission.subNavName.indexOf("F1_S2")>=0?'会员入场记录':'',
                            subNavIcon: permission.subNavName.indexOf("F1_S2")>=0?'icon-member-entrance-list':'',
                            subNavUrl: 'index.member-entrance-list({pageNo:1,pageSize:10})'
                        },
                        {
                            subNavName: permission.subNavName.indexOf("F1_S3")>=0?'会员列表':'',
                            subNavIcon: permission.subNavName.indexOf("F1_S3")>=0?'icon-member-list':"",
                            subNavUrl: 'index.member-list({pageNo:1,pageSize:10})'
                        },
                        {
                            subNavName: permission.subNavName.indexOf("F1_S4")>=0?'即将到期会员':'',
                            subNavIcon: permission.subNavName.indexOf("F1_S4")>=0?'icon-almost-expire-member-list':"",
                            subNavUrl: 'index.almost-expire-member-list({pageNo:1,pageSize:10})'
                        },
                        {
                            subNavName: permission.subNavName.indexOf("F1_S5")>=0?'已到期会员':'',
                            subNavIcon:  permission.subNavName.indexOf("F1_S5")>=0?'icon-expire-member-list':"",
                            subNavUrl: 'index.expire-member-list({pageNo:1,pageSize:10})'
                        },
                        {
                            //subNavName: permission.subNavName.indexOf("F1_S6")>=0?'会员生日':'',
                            //subNavIcon: permission.subNavName.indexOf("F1_S6")>=0?'icon-birthday-member-list':"",
                            //subNavUrl: 'index.member-birthday-list({pageNo:1,pageSize:10})'
                        },
                        {
                            subNavName: permission.subNavName.indexOf("F1_S7")>=0?'会员卡处理':"",
                            subNavIcon:  permission.subNavName.indexOf("F1_S7")>=0?'icon-member-card-process-list':"",
                            subNavUrl: 'index.member-card-process-list({pageNo:1,pageSize:10})'
                        }
                    ]
                },
                {
                    navName: permission.navName.indexOf("F2")>=0?'会员卡交易':"",
                    subNavList: [
                        {
                            subNavName:permission.subNavName.indexOf("F2_S1")>=0? '交易数据统计':"",
                            subNavIcon:permission.subNavName.indexOf("F2_S1")>=0? 'icon-member-trade-index':"",
                            subNavUrl: 'index.member-trade-index'
                        },
                       // {
                          //  subNavName: permission.subNavName.indexOf("F2_S2")>=0?'会员卡交易记录':'',
                          //  subNavIcon: permission.subNavName.indexOf("F2_S2")>=0?'icon-member-trade-list':'',
                          //  subNavUrl: 'index.member-trade-list({pageNo:1,pageSize:10})'
                       // },
                        {
                            subNavName:permission.subNavName.indexOf("F2_S2")>=0? '会员充值排行榜':"",
                            subNavIcon:permission.subNavName.indexOf("F2_S2")>=0? 'icon-member-trade-index':"",
                            subNavUrl: 'index.member-trade-ranking-list'
                        },
                    ]
                },
                {
                    //navName: permission.navName.indexOf("F3")>=0?'储物柜':"",
                    subNavList: [
                        //{
                            //subNavName: permission.subNavName.indexOf("F3_S1")>=0?'储物柜出租':'',
                            //subNavIcon:permission.subNavName.indexOf("F3_S1")>=0? 'icon-locker-list':"",
                            //subNavUrl: 'index.locker-list({pageNo:1,pageSize:10})'
                        //},
                        //{
                            //subNavName: permission.subNavName.indexOf("F3_S3")>=0?'储物柜出租记录':'',
                            //subNavIcon:permission.subNavName.indexOf("F3_S3")>=0? 'icon-locker-record-list':"",
                            //subNavUrl: 'index.locker-record-list({pageNo:1,pageSize:10})'
                        //},
                        //{
                            //subNavName: permission.subNavName.indexOf("F3_S2")>=0?'储物柜设置':'',
                            //subNavIcon: permission.subNavName.indexOf("F3_S2")>=0?'icon-locker-setting-list':"",
                            //subNavUrl: 'index.locker-setting-list({pageNo:1,pageSize:10})'
                        //}
                    ]
                },
                {
                    navName:permission.navName.indexOf("F4")>=0? '教练管理':"",
                    subNavList: [
                        {
                            subNavName: permission.subNavName.indexOf("F4_S1")>=0?'私教购买记录':"",
                            subNavIcon:permission.subNavName.indexOf("F4_S1")>=0? 'icon-privately-purchase-list':'',
                            subNavUrl: 'index.privately-purchase-list({pageNo:1,pageSize:10})'
                        },
                        {
                            subNavName: permission.subNavName.indexOf("F4_S2")>=0?'私教卡设置':'',
                            subNavIcon:  permission.subNavName.indexOf("F4_S2")>=0?'icon-privately-class-setting':"",
                            subNavUrl: 'index.privately-class-setting({pageNo:1,pageSize:10})'
                        },
                        {
                            subNavName: permission.subNavName.indexOf("F4_S3")>=0?'私教签课记录':"",
                            subNavIcon: permission.subNavName.indexOf("F4_S3")>=0?'icon-privately-sign-list':"",
                            subNavUrl: 'index.privately-sign-list({pageNo:1,pageSize:10})'
                        },
                        //{
                            //subNavName: permission.subNavName.indexOf("F4_S4")>=0?'私教购买排行榜':"",
                            //subNavIcon: permission.subNavName.indexOf("F4_S4")>=0?'icon-privately-sign-list':"",
                            //subNavUrl: 'index.privately-purchase-ranking-list({pageNo:1,pageSize:10})'
                        //},
                        //{
                            //subNavName: permission.subNavName.indexOf("F4_S4")>=0?'私教转让记录':"",
                            //subNavIcon: permission.subNavName.indexOf("F4_S4")>=0?'icon-privately-class-tranfer-list':"",
                            //subNavUrl: 'index.privately-class-transfer-list({pageNo:1,pageSize:10})'
                        //}
                    ]
                },
                {
                    //navName: permission.navName.indexOf("F5")>=0?'销售管理':"",
                    subNavList: [
                       // {
                            //subNavName: permission.subNavName.indexOf("F5_S1")>=0?'销售业绩数据统计':"",
                            //subNavIcon:permission.subNavName.indexOf("F5_S1")>=0? 'icon-sales-record-index':"",
                            //subNavUrl: 'index.sales-record-index'
                       // },
                       // {
                            //subNavName: permission.subNavName.indexOf("F5_S2")>=0?'销售业绩记录':'',
                            //subNavIcon: permission.subNavName.indexOf("F5_S2")>=0?'icon-sales-record-list':"",
                            //subNavUrl: 'index.sales-record-list({pageNo:1,pageSize:10})'
                        //}
                    ]
                },
                {
                    navName: permission.navName.indexOf("F6")>=0?'基础信息':'',
                    subNavList: [
                        //{
                            //subNavName: permission.subNavName.indexOf("F6_S1")>=0?'投诉列表':"",
                            //subNavIcon: permission.subNavName.indexOf("F6_S1")>=0?'icon-complaint-list':"",
                            //subNavUrl: 'index.complaint-list({pageNo:1,pageSize:10})'
                       // },
                        {
                            subNavName:permission.subNavName.indexOf("F6_S2")>=0? '会员卡列表':'',
                            subNavIcon:permission.subNavName.indexOf("F6_S2")>=0? 'icon-member-card-list':"",
                            subNavUrl: 'index.member-card-list({pageNo:1,pageSize:10})'
                        }
                    ]
                }
            ]
        }
        else {
            $scope.navList=[];
        }
        Highcharts.theme = {
            colors: ['#7cb5ec', '#f7a35c', '#90ee7e', '#7798BF', '#aaeeee', '#ff0066', '#eeaaee',
                '#55BF3B', '#DF5353', '#7798BF', '#aaeeee'],
            chart: {
                backgroundColor: null,
                style: {
                    fontFamily: 'Dosis, sans-serif'
                }
            },
            title: {
                style: {
                    fontSize: '16px',
                    fontWeight: 'bold',
                    textTransform: 'uppercase'
                }
            },
            tooltip: {
                borderWidth: 0,
                backgroundColor: 'rgba(219,219,216,0.8)',
                shadow: false
            },
            legend: {
                itemStyle: {
                    fontWeight: 'bold',
                    fontSize: '13px'
                }
            },
            xAxis: {
                gridLineWidth: 1,
                labels: {
                    style: {
                        fontSize: '12px'
                    }
                }
            },
            yAxis: {
                minorTickInterval: 'auto',
                title: {
                    style: {
                        textTransform: 'uppercase'
                    }
                },
                labels: {
                    style: {
                        fontSize: '12px'
                    }
                }
            },
            plotOptions: {
                candlestick: {
                    lineColor: '#404048'
                }
            },


            // General
            background2: '#F0F0EA'

        };
        $scope.snapPhoto=function(){
            alert("弹弹弹弹");
        }
        Highcharts.setOptions(Highcharts.theme);
        $scope.logout = function () {
            if ($cookies.getObject("login_admin") == undefined){
                $state.go("login");
            } else {
                authSettingListService.logout($cookies.getObject("login_admin")).then(function (data) {
                    if (data.msg == "success") {
                        $cookies.remove("login_admin");
                        $cookies.remove("navList");
                        $state.go("login");
                    }
                    else
                        $state.go("main");
                });
            }

        };
        //登录SESSION
        $rootScope.getLoginAdmin=function(){
            authSettingListService.getLoginAdminSession().then(function (data) {
                if (data.msg == 'success'){
                    if ($cookies.getObject("navList") != null) {
                        $cookies.remove("navList");
                        $cookies.remove("login_admin");
                        $cookies.remove("days");
                    }//清楚之前cookie
                    var now = new Date();
                    var expireDate = new Date(now);
                    expireDate.setSeconds(expireDate.getSeconds() +data.SESSION_TIME);//30分钟
                    $cookies.putObject("login_admin", data.loginUser[0], {'expires': expireDate});
                    if (data.pageButtons != null || angular.equals({}, data.pageButtons)) {
                        $cookies.putObject("navList", data.pageButtons[0], {'expires': expireDate});
                      var time= new Date(now).getHours()+":"+ new Date(now).getMinutes()+":"+ new Date(now).getSeconds();
                        console.log("getLoginUser   "+time);
                    }
                }else{
                    $cookies.remove("navList");
                    $cookies.remove("login_admin");
                    $state.go("login");

                }

            });
        };
        /**
         *
         * main 统计
         */
        if($cookies.getObject("navList").subNavName.indexOf("F0_S0")>=0||$cookies.getObject("login_admin").adminRole==1){
            $scope.indexMain=true;
        }else $scope.indexMain=false;
        var days=0;
        var salesDays=0;
        $scope.selectDays=0;//总计
        $scope.selectSalesDays=0;//金额
        if($cookies.getObject("days")!=null)
            days=$cookies.getObject("days");
        if($cookies.getObject("salesDays")!=null)
            salesDays=$cookies.getObject("salesDays");
        //会员统计（人）
        $scope.searchMember=function (searchTime) {
            if(searchTime==0)
                days=7;
            else if(searchTime==1)
                days=30;
            else if(searchTime==2)
                days=0;

            var now = new Date();
            var expireDate = new Date(now);
            expireDate.setHours(expireDate.getHours() +24);//30分钟
            $cookies.putObject("days",days,{'expires': expireDate});
            $rootScope.getLoginAdmin();
            memberListService.memberStatisticsNum(days).then(function (data) {//会员统计
                if($cookies.getObject("days")!=undefined){
                    $scope.selectDays=$cookies.getObject("days");
                }
                //会员统计
                $scope.yestodays=data.yestodays||0;
                $scope.todays=data.todays||0;
                $scope.memberTotal=data.memberTotal||0;
            });
        };
        memberListService.memberStatisticsNum(days).then(function (data) {//会员统计
            if($cookies.getObject("days")!=undefined){
                $scope.selectDays=$cookies.getObject("days");
            }
            //会员统计
            $scope.yestodays=data.yestodays||0;
            $scope.todays=data.todays||0;
            $scope.memberTotal=data.memberTotal||0;
        });
        //金额统计
        $scope.searchSalesMoney=function (searchTime) {
            if(searchTime==0)
                salesDays=7;
            else if(searchTime==1)
                salesDays=30;
            else if(searchTime==2)
                salesDays=0;

            var now = new Date();
            var expireDate = new Date(now);
            expireDate.setHours(expireDate.getHours() +24);//30分钟
            $cookies.putObject("salesDays",salesDays,{'expires': expireDate});
            $rootScope.getLoginAdmin();
            memberListService.getSalesMoney(salesDays).then(function (data) {
                if($cookies.getObject("salesDays")!=undefined){
                    $scope.selectSalesDays=$cookies.getObject("salesDays");
                }
                //销售金额
                $scope.salesMoneyYesterday=data.salesMoneyYesterday||0;
                $scope.salesMoneyToday=data.salesMoneyToday||0;
                $scope.salesTotalMoney=data.salesTotalMoney||0;
            });
        };
        memberListService.getSalesMoney(salesDays).then(function (data) {
            if($cookies.getObject("salesDays")!=undefined){
                $scope.selectSalesDays=$cookies.getObject("salesDays");
            }
            //销售金额
            $scope.salesMoneyYesterday=data.salesMoneyYesterday||0;
            $scope.salesMoneyToday=data.salesMoneyToday||0;
            $scope.salesTotalMoney=data.salesTotalMoney||0;
        });
       //储物柜统计
        /*$scope.lockerRefresh=function () {
            $rootScope.getLoginAdmin();
            lockerService.lockerStatistics().then(function (data) {
                $scope.lockerTotalNum=data.lockerTotalNum||0;
                $scope.currentRentNum=data.currentRentNum||0;
                $scope.fixNum=data.fixNum||0;
            });
        };
        lockerService.lockerStatistics().then(function (data) {
            $scope.lockerTotalNum=data.lockerTotalNum||0;
            $scope.currentRentNum=data.currentRentNum||0;
            $scope.fixNum=data.fixNum||0;
        });*/
       // 员工统计

        employeeListService.getEmployeeStatisticsNum().then(function (data) {
            $scope.employeeNum=data.employeeNum||0;
            $scope.employeeMail=data.employeeMail||0;
            $scope.employeeWomen=data.employeeWomen||0;
        });
        //会员到期统计
        $scope.memberRefresh=function () {
            $rootScope.getLoginAdmin();
            memberListService.memberExpiryStatistics().then(function (data) {
                $scope.memberTotalS=data.memberTotal||0;
                $scope.comingExpire=data.comingExpire||0;
                $scope.expireMember=data.expireMember||0;
            });
        };
        memberListService.memberExpiryStatistics().then(function (data) {
            $scope.memberTotalNum=data.memberTotal||0;
            $scope.comingExpire=data.comingExpire||0;
            $scope.expireMember=data.expireMember||0;
        });
        //会员卡充值分布统计
        //$scope.rechargeTimesRefresh=function () {
        //    $rootScope.getLoginAdmin();
        //    memberListService.memberRechargeTimes().then(function (data) {
        //        $scope.rechargeTimes=data.rechargeTimes||0;
        //        $scope.rechargeTimesTotal=data.rechargeTimesTotal||0;
        //    });
        //};
        //memberListService.memberRechargeTimes().then(function (data) {
        //    $scope.rechargeTimes=data.rechargeTimes||0;
        //    $scope.rechargeTimesTotal=data.rechargeTimesTotal||0;
        //
        //});
        //会员卡充值分布统计
        $scope.rechargeTimesRefresh=function () {
            $rootScope.getLoginAdmin();
            memberListService.memberRechargeTimes().then(function (data) {
                $scope.rechargeTimes=data.rechargeTimes||0;
                $scope.rechargeTimesTotal=data.rechargeTimesTotal||0;
            });
        };
        memberListService.memberRechargeTimes().then(function (data) {
            $scope.rechargeTimes=data.rechargeTimes||0;
            $scope.rechargeTimesTotal=data.rechargeTimesTotal||0;

        });
        //导航栏超链接设置
        //1、跳回主页面
        $rootScope.goIndexMain=function(){
            $state.go('index.main');
        }
        //$scope.memberDetail=function(cardNo,ev) {
        //
        //    if (cardNo != ""&&cardNo.length==8) {
        //        $scope.cardNum = cardNo;
        //        $mdDialog.show({
        //            controller: brushCardDetailCtrl,
        //            templateUrl: 'template/member-detail.html',
        //            parent: angular.element(document.body),
        //            targetEvent: ev,
        //            clickOutsideToClose: false,
        //            locals: {
        //                cardNo: $scope.cardNum
        //            }
        //        });
        //
        //    }
        //}
        ////刷卡显示详情
        //function brushCardDetailCtrl($scope, $mdDialog, cardNo) {
        //    if (cardNo != undefined) {
        //        //获取ID后绑定会员数据
        //        memberService.finCardNoUser(cardNo).then(function (data) {
        //            var rentalExpire="";
        //            if(data.rentalExpire.length>=1){
        //                for(var i=0;i<data.rentalExpire.length;i++){
        //                    rentalExpire+="柜号"+data.rentalExpire[i].lockerNo+"剩余"+data.rentalExpire[i].surplus+"天过期("+data.rentalExpire[i].expire+")"
        //                }
        //                alert(rentalExpire);
        //            }
        //            $scope.member = data.user;
        //            memberService.finRecordCardNo(data.cardNo).then(function (data) {
        //                $scope.recordCardNo = data.cardRecordEntities;
        //                $scope.ProcessCardNo = data.cardProcessEntities;
        //            })
        //        })
        //    }
        //
        //    //关闭对话框
        //    $scope.hideDialog = function () {
        //        $mdDialog.hide();
        //    };
        //}
    }]);

