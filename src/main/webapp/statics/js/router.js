//路由事件
app.run(['$rootScope', '$log', '$timeout', function ($rootScope, $log, $timeout) {
    $rootScope.$on('$stateChangeSuccess', function () {

        //从页面底部返回时跳转到页面顶部
        $timeout(function () {
            var obj = document.getElementById('scroll_bar');
            if(obj!=undefined){
                obj.scrollTop = 0;
            }
        })
    });

    $rootScope.$on('$routeChangeStart', function(){
        $rootScope.loading=true;
    });
    $rootScope.$on('$routeChangeSuccess', function () {
        $rootScope.loading=false;
    });
    //即将到期会员、到期会员跳转会员编辑回调原页面的函数
    $rootScope.$on('$stateChangeSuccess',function(event, toState, toParams, fromState, fromParams){
        $rootScope.previousState=fromState.name;
        $rootScope.fromParams=fromParams
    })
}]);
app.config(['$stateProvider', '$urlRouterProvider', '$ocLazyLoadProvider', '$httpProvider','$locationProvider',
    function ($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, $httpProvider,$locationProvider) {
        $ocLazyLoadProvider.config({
            debug: false,
            events: false
        });

        //$httpProvider.interceptors.push('globalLoading');
      $httpProvider.interceptors.push('adminIntercepter');

        ///路由配置
        // $locationProvider.html5Mode(true);
        $urlRouterProvider.otherwise('/login');
        $stateProvider
        //登陆页
            .state('login', {
                url: '/login',
                views: {
                    'login': {
                        controller: 'loginCtrl',
                        templateUrl: 'views/auth/login.html'
                    }
                },
                resolve: {
                    loginCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/auth.js','service/auth.js','service/store.js']);
                    }]
                }
            })
            //后台主页
            .state('index', {
                url: "/",
                views: {
                    "main": {
                        controller: 'mainCtrl as userMenuCtrl',
                        templateUrl: 'template/layout-content.html'
                    }
                },
                resolve: {
                    mainCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/main.js', 'service/auth.js','service/global-search.js','service/member.js','service/sales.js','service/locker.js','service/employee.js']);
                    }]
                }
            })
            //后台首页
            .state('index.main', {
                url: 'main',
                views: {
                    'layoutContent': {
                        templateUrl: 'main.html'
                    }
                }
            })
            //会员数据统计
            .state('index.member-index', {
                url: "member-index",
                views: {
                    "layoutContent": {
                        controller: 'memberIndexCtrl',
                        templateUrl: 'views/member/index.html'
                    }
                },
                resolve: {
                    memberIndexCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member.js', 'service/member.js']);
                    }]
                }
            })
            //会员入场记录
            .state('index.member-entrance-list', {
                url: "member-entrance-list/pn-:pageNo/ps-:pageSize/:searchObj/:goEntrance",
                views: {
                    "layoutContent": {
                        controller: 'memberEntranceListCtrl',
                        templateUrl: 'views/member/member-entrance-list.html'
                    }
                },
                resolve: {
                    memberEntranceListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member.js', 'service/member.js']);
                    }]
                }
            })
            //会员列表页
            .state('index.member-list', {
                url: "member-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'memberListCtrl',
                        templateUrl: 'views/member/member-list.html'
                    }
                },
                resolve: {
                    memberListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member.js', 'service/member.js','service/employee.js','service/upload.js','service/coach.js']);
                    }]
                }
            })
            //即将到期会员列表页
            .state('index.almost-expire-member-list', {
                url: "almost-expire-member-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'almostExpireMemberListCtrl',
                        templateUrl: 'views/member/almost-expire-member-list.html'
                    }
                },
                resolve: {
                    almostExpireMemberListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member.js', 'service/member.js','service/employee.js']);
                    }]
                }
            })
            //已到期会员列表页
            .state('index.expire-member-list', {
                url: "expire-member-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'expireMemberListCtrl',
                        templateUrl: 'views/member/expire-member-list.html'
                    }
                },
                resolve: {
                    expireMemberListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member.js', 'service/member.js','service/employee.js']);
                    }]
                }
            })
            //生日会员列表
            .state('index.member-birthday-list', {
                url: "member-birthday-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'memberBirthdayListCtrl',
                        templateUrl: 'views/member/member-birthday-list.html'
                    }
                },
                resolve: {
                    memberBirthdayListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member-birthday.js', 'service/member-birthday.js']);
                    }]
                }
            })
            //会员卡处理列表页
            .state('index.member-card-process-list', {
                url: "member-card-process-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'memberCardProcessListCtrl',
                        templateUrl: 'views/member/member-card-process-list.html'
                    }
                },
                resolve: {
                    memberCardProcessListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member-process.js', 'service/member-process.js','service/store.js','service/member-card.js']);
                    }]
                }
            })
            //新建会员卡处理
            .state('index.operate-member-card-process', {
                url: "operate-member-card-process/:pageNo/:pageSize",
                views: {
                    "layoutContent": {
                        controller: 'operateMemberCardProcessCtrl',
                        templateUrl: 'views/member/operate-member-card-process.html'
                    }
                },
                resolve: {
                    operateMemberCardProcessCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member-process.js', 'service/member-process.js','service/member-trade.js','service/member-card.js']);
                    }]
                }
            })
            //会员卡处理详情
            .state('index.check-member-card-process', {
                url: "check-member-card-process/:processID/:pageNo/:pageSize/:type",
                views: {
                    "layoutContent": {
                        controller: 'operateMemberCardProcessCtrl',
                        templateUrl: 'views/member/operate-member-card-process.html'
                    }
                },
                resolve: {
                    operateMemberCardProcessCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member-process.js', 'service/member-process.js','service/member-trade.js','service/employee.js','service/member.js']);
                    }]
                }
            })
            //录入会员
            .state('index.operate-member', {
                url: "operate-member/:pageNo/:pageSize",
                views: {
                    "layoutContent": {
                        controller: 'operateMemberCtrl',
                        templateUrl: 'views/member/operate-member.html'
                    }
                },
                resolve: {
                    operateMemberCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member.js', 'service/member.js','service/member-card.js','service/employee.js','service/upload.js','service/store.js']);
                    }]
                }
            })
            //更新会员
            .state('index.edit-member', {
                url: "edit-member/:id/:pageNo/:pageSize",
                views: {
                    "layoutContent": {
                        controller: 'operateMemberCtrl',
                        templateUrl: 'views/member/operate-member.html'
                    }
                },
                resolve: {
                    operateMemberCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member.js', 'service/member.js','service/member-card.js','service/employee.js','service/upload.js','service/store.js']);
                    }]
                }
            })
            //投诉列表
            .state('index.complaint-list', {
                url: "complaint-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'complaintListCtrl',
                        templateUrl: 'views/complaint/complaint-list.html'
                    }
                },
                resolve: {
                    complaintListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/complaint.js', 'service/complaint.js']);
                    }]
                }
            })
            //录入投诉
            .state('index.operate-complaint', {
                url: "operate-complaint/:pageNo/:pageSize",
                views: {
                    "layoutContent": {
                        controller: 'operateComplaintCtrl',
                        templateUrl: 'views/complaint/operate-complaint.html'
                    }
                },
                resolve: {
                    operateComplaintCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/complaint.js', 'service/complaint.js','service/member-trade.js','service/store.js']);
                    }]
                }
            })
            //更新投诉
            .state('index.edit-complaint', {
                url: "edit-complaint/:cp_id/:pageNo/:pageSize",
                views: {
                    "layoutContent": {
                        controller: 'operateComplaintCtrl',
                        templateUrl: 'views/complaint/operate-complaint.html'
                    }
                },
                resolve: {
                    operateComplaintCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/complaint.js', 'service/complaint.js','service/member-trade.js','service/store.js']);
                    }]
                }
            })
            //会员卡列表
            .state('index.member-card-list', {
                url: "member-card-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'memberCardListCtrl',
                        templateUrl: 'views/card/member-card-list.html'
                    }
                },
                resolve: {
                    memberCardListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member-card.js', 'service/member-card.js','service/store.js']);
                    }]
                }
            })
            //录入会员卡
            .state('index.operate-member-card', {
                url: "operate-member-card/:pageNo/:pageSize",
                views: {
                    "layoutContent": {
                        controller: 'operateMemberCardCtrl',
                        templateUrl: 'views/card/operate-member-card.html'
                    }
                },
                resolve: {
                    operateMemberCardCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member-card.js', 'service/member-card.js','service/store.js']);
                    }]
                }
            })
            //更新会员卡
            .state('index.update-member-card', {
                url: "update-member-card/:cardId/:pageNo/:pageSize",
                views: {
                    "layoutContent": {
                        controller: 'operateMemberCardCtrl',
                        templateUrl: 'views/card/operate-member-card.html'
                    }
                },
                resolve: {
                    operateMemberCardCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member-card.js', 'service/member-card.js','service/store.js']);
                    }]
                }
            })
            //会员卡交易数据统计
            .state('index.member-trade-index', {
                url: "member-trade-index",
                views: {
                    "layoutContent": {
                        controller: 'memberTradeIndexCtrl',
                        templateUrl: 'views/trade/index.html'
                    }
                },
                resolve: {
                    memberTradeIndexCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member-trade.js', 'service/member-trade.js']);
                    }]
                }
            })
            //会员卡交易列表
            .state('index.member-trade-list', {
                url: "member-trade-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'memberTradeListCtrl',
                        templateUrl: 'views/trade/member-trade-list.html'
                    }
                },
                resolve: {
                    memberRechargeListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member-trade.js', 'service/member-trade.js']);
                    }]
                }
            })
            //会员卡充值排行榜
            .state('index.member-trade-ranking-list', {
                url: "member-trade-ranking-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'memberTradeRankingListCtrl',
                        templateUrl: 'views/trade/member-trade-ranking-list.html'
                    }
                },
                resolve: {
                    memberRechargeListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member-trade.js', 'service/member-trade.js']);
                    }]
                }
            })
            //新增充值
            .state('index.operate-trade', {
                url: "operate-trade/:type/:pageNo/:pageSize",
                views: {
                    "layoutContent": {
                        controller: 'operateTradeCtrl',
                        templateUrl: 'views/trade/operate-trade.html'
                    }
                },
                resolve: {
                    operateTradeCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member-trade.js', 'service/member-trade.js']);
                    }]
                }
            })
            //充值退款详情
            .state('index.trade-detail', {
                url: "trade-detail/:type/:id/:pageNo/:pageSize",
                views: {
                    "layoutContent": {
                        controller: 'tradeDetailCtrl',
                        templateUrl: 'views/trade/trade-detail.html'
                    }
                },
                resolve: {
                    tradeDetailCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member-trade.js', 'service/member-trade.js']);
                    }]
                }
            })
            //充值详情
            .state('index.check-recharge', {
                url: "check-recharge/:cid",
                views: {
                    "layoutContent": {
                        controller: 'operateRechargeCtrl',
                        templateUrl: 'views/recharge/check-recharge.html'
                    }
                },
                resolve: {
                    operateRechargeCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/member-recharge.js', 'service/member-recharge.js']);
                    }]
                }
            })
            //会所列表
            .state('index.store-list', {
                url: "store-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'storeListCtrl',
                        templateUrl: 'views/store/store-list.html'
                    }
                },
                resolve: {
                    storeListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/store.js', 'service/store.js']);
                    }]
                }
            })
            //录入会所
            .state('index.operate-store', {
                url: "operate-shop",
                views: {
                    "layoutContent": {
                        controller: 'operateStoreCtrl',
                        templateUrl: 'views/store/operate-store.html'
                    }
                },
                resolve: {
                    operateStoreCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/store.js', 'service/store.js']);
                    }]
                }
            })
            //更新会所
            .state('index.update-store', {
                url: "update-store/:storeID",
                views: {
                    "layoutContent": {
                        controller: 'operateStoreCtrl',
                        templateUrl: 'views/store/operate-store.html'
                    }
                },
                resolve: {
                    operateShopCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/store.js', 'service/store.js']);
                    }]
                }
            })
            //员工列表
            .state('index.employee-list', {
                url: "employee-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'employeeListCtrl',
                        templateUrl: 'views/employee/employee-list.html'
                    }
                },
                resolve: {
                    employeeListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/employee.js', 'service/employee.js','service/store.js']);
                    }]
                }
            })
            //录入员工
            .state('index.operate-employee', {
                url: "operate-employee/:pageNo/:pageSize",
                views: {
                    "layoutContent": {
                        controller: 'operateEmployeeCtrl',
                        templateUrl: 'views/employee/operate-employee.html'
                    }
                },
                resolve: {
                    operateEmployeeCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/employee.js', 'service/employee.js','service/store.js','service/upload.js','service/store.js']);
                    }]
                }
            })
            //更新员工
            .state('index.edit-employee', {
                url: "edit-employee/:eid/:pageNo/:pageSize",
                views: {
                    "layoutContent": {
                        controller: 'operateEmployeeCtrl',
                        templateUrl: 'views/employee/operate-employee.html'
                    }
                },
                resolve: {
                    operateEmployeeCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/employee.js', 'service/employee.js','service/store.js','service/upload.js','service/store.js']);
                    }]
                }
            })
            //储物柜设置
            .state('index.locker-setting-list', {
                url: "locker-setting-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'lockerSettingListCtrl',
                        templateUrl: 'views/locker/locker-setting-list.html'
                    }
                },
                resolve: {
                    lockerSettingListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/locker.js', 'service/locker.js','service/store.js']);
                    }]
                }
            })
            //储物柜列表
            .state('index.locker-list', {
                url: "locker-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'lockerListCtrl',
                        templateUrl: 'views/locker/locker-list.html'
                    }
                },
                resolve: {
                    lockerListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/locker.js', 'service/locker.js','service/member-trade.js']);
                    }]
                }
            })
            //储物柜出租记录
            .state('index.locker-record-list', {
                url: "locker-record-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'lockerListCtrl',
                        templateUrl: 'views/locker/locker-record-list.html'
                    }
                },
                resolve: {
                    lockerListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/locker.js', 'service/locker.js','service/member-trade.js']);
                    }]
                }
            })
            //积分排行榜
            .state('index.member-integral-ranking-index', {
                url: "member-integral-ranking-index",
                views: {
                    "layoutContent": {
                        controller: 'memberIntegralRankingCtrl',
                        templateUrl: 'views/ranking/member-integral-ranking-index.html'
                    }
                },
                resolve: {
                    memberIntegralRankingCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/ranking.js', 'service/ranking.js']);
                    }]
                }
            })
            //私教课程设置
            .state('index.privately-class-setting', {
                url: "privately-class-setting/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'privatelyClassSettingCtrl',
                        templateUrl: 'views/coach/privately-class-setting.html'
                    }
                },
                resolve: {
                    privatelyClassSettingCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/coach.js', 'service/coach.js','service/store.js']);
                    }]
                }
            })
            //私教转课记录
            .state('index.privately-class-transfer-list', {
                url: "privately-class-transfer-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'privatelyClassTransferListCtrl',
                        templateUrl: 'views/coach/privately-class-transfer-list.html'
                    }
                },
                resolve: {
                    privatelyClassTransferListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/transfer.js', 'service/transfer.js','service/member-trade.js','service/employee.js','service/store.js','service/coach.js']);
                    }]
                }
            })
            //私教签课记录
                .state('index.privately-sign-list', {
                url: "privately-sign-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'privatelySignListCtrl',
                        templateUrl: 'views/coach/privately-sign-list.html'
                    }
                },
                resolve: {
                    privatelySignListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/coach.js', 'service/coach.js','service/member-trade.js','service/employee.js','service/store.js']);
                    }]
                }
            })
            //私教购买记录
            .state('index.privately-purchase-list', {
                url: "privately-purchase-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'privatelyPurchaseListCtrl',
                        templateUrl: 'views/coach/privately-purchase-list.html'
                    }
                },
                resolve: {
                    privatelyPurchaseListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/coach.js', 'service/coach.js','service/member-trade.js','service/employee.js','service/store.js','service/employee.js']);
                    }]
                }
            })
            //私教购买排行榜
            .state('index.privately-purchase-ranking-list', {
                url: "privately-purchase-ranking-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'privatelyPurchaseRankingListCtrl',
                        templateUrl: 'views/coach/privately-purchase-ranking-list.html'
                    }
                },
                resolve: {
                    memberRechargeListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/coach.js', 'service/coach.js']);
                    }]
                }
            })
            //销售业绩记录
            .state('index.sales-record-index', {
                url: "sales-record-index",
                views: {
                    "layoutContent": {
                        controller: 'salesRecordIndexCtrl',
                        templateUrl: 'views/sales/sales-record-index.html'
                    }
                },
                resolve: {
                    salesRecordIndexCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/sales.js', 'service/sales.js','service/employee.js']);
                    }]
                }
            })
            //销售业绩记录
            .state('index.sales-record-list', {
                url: "sales-record-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'salesRecordListCtrl',
                        templateUrl: 'views/sales/sales-record-list.html'
                    }
                },
                resolve: {
                    salesRecordListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/sales.js', 'service/sales.js','service/store.js']);
                    }]
                }
            })
            //权限设置
            .state('index.auth-setting-list', {
                url: "auth-setting-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'authSettingListCtrl',
                        templateUrl: 'views/auth/auth-setting-list.html'
                    }
                },
                resolve: {
                    authSettingListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/auth.js', 'service/auth.js','service/store.js']);
                    }]
                }
            })
            .state('index.auth-setting', {
                url: "auth-setting/pn-:pageNo/ps-:pageSize/:searchObj/:id",
                views: {
                    "layoutContent": {
                        controller: 'authSettingCtrl',
                        templateUrl: 'views/auth/auth-setting.html'
                    }
                },
                resolve: {
                    authSettingListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/auth.js', 'service/auth.js','service/store.js']);
                    }]
                }
            })
            .state('index.log-list', {
                url: "log-list/pn-:pageNo/ps-:pageSize/:searchObj",
                views: {
                    "layoutContent": {
                        controller: 'logListCtrl',
                        templateUrl: 'views/log/log-list.html'
                    }
                },
                resolve: {
                    authSettingListCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/log.js', 'service/log.js']);
                    }]
                }
            })
            // .state('index.camera', {
            //     url: "camera",
            //     views: {
            //         "layoutContent": {
            //             templateUrl: 'views/card/camera1.html'
            //         }
            //     },
            // })
            //excel上传
            .state('index.excelImport', {
                url: "excelImport",
                views: {
                    "layoutContent": {
                        controller: 'operateEmployeeCtrl',
                        templateUrl: 'excelImport.html'
                    }
                },
                resolve: {
                    operateEmployeeCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['controller/employee.js', 'service/employee.js','service/store.js','service/upload.js','service/store.js']);
                    }]
                }
            })

        ;
    }]);