var app = angular.module('app',
    [
        'perfect_scrollbar',
        'ngMaterial',
        'ui.router',
        'ngAnimate',
        'use',
        'ngMessages',
        'oc.lazyLoad',
        'highcharts-ng',
        'ngFileUpload',
        'ngCookies'
    ]);

//日期控件本地化
app.config(['$mdIconProvider', '$mdDateLocaleProvider',

    function ($mdIconProvider, $mdDateLocaleProvider) {


     $mdDateLocaleProvider.months = ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'];
     $mdDateLocaleProvider.shortMonths = ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'];
     $mdDateLocaleProvider.days = ['周日', '周一', '周二', '周三', '周四', '周五', '周六'];
     $mdDateLocaleProvider.shortDays = ['周日', '周一', '周二', '周三', '周四', '周五', '周六'];
     $mdDateLocaleProvider.firstDayOfWeek = 1;
     $mdDateLocaleProvider.formatDate = function (date) {
         return moment(date).format('YYYY-MM-DD');
     };
     $mdDateLocaleProvider.parseDate = function (dateString) {
         var m = moment(dateString, 'YYYY-MM-DD', true);
         return m.isValid() ? m.toDate() : new Date(NaN);
     };

    //图标全局配置
    $mdIconProvider
        .icon('account', '../statics/images/icon/icon_account.svg', 24)
        .icon('logout', '../statics/images/icon/icon_logout.svg', 24)
        .icon('password', '../statics/images/icon/icon_password.svg', 24)
        .icon('enable', '../statics/images/icon/icon_enable.svg', 24)
        .icon('disable', '../statics/images/icon/icon_disable.svg', 24)
        .icon('add', '../statics/images/icon/icon_add.svg', 24)
        .icon('close', '../statics/images/icon/icon_close.svg', 24)
        .icon('attention', '../statics/images/icon/icon_attention.svg', 24)
        .icon('send_sms', '../statics/images/icon/icon_send_sms.svg', 24)
        .icon('print', '../statics/images/icon/icon_print.svg', 24)
        .icon('export_excel', '../statics/images/icon/icon_export_excel.svg', 24)
        .icon('export_all', '../statics/images/icon/icon_export_all.svg', 24)
        .icon('recharge', '../statics/images/icon/icon_recharge.svg', 24)
        .icon('refund', '../statics/images/icon/icon_refund.svg', 24)
        .icon('quit_locker', '../statics/images/icon/icon_quit_locker.svg', 24)
    ;
    $mdIconProvider.fontSet('md', 'material-icons');
}]);
//app.factory('globalLoading', ["$rootScope",function ($rootScope) {
//
//    var loading = {
//        request: function (config) {
//            $rootScope.loading=true;
//            return config;
//        },
//        response: function (response) {
//
//            $rootScope.loading=false;
//            return response;
//        }
//    };
//    return loading;
//}]);



app.factory('adminIntercepter', ["$rootScope", '$cookies','$location',function ($rootScope,$cookies,$location) {
    $rootScope.$on('$stateChangeStart',function(event, toState, toParams, fromState) {
        var now = new Date();
        var expireDate = new Date(now);
        $rootScope.expireTimeFactory=expireDate.getHours()+":"+expireDate.getMinutes()+":"+expireDate.getSeconds();
        if($cookies.getObject("login_admin")!=undefined) {
            $rootScope.isShow=true;
            $rootScope.superManager=$cookies.getObject("login_admin").storeIds;
        } else $rootScope.isShow= false;
        $rootScope.buttonPermission=function (buttonName) {
            //return true;
            if($cookies.getObject("navList")!=undefined){
                if($cookies.getObject("navList").buttons.indexOf(buttonName)>=0||$cookies.getObject("login_admin").adminRole==1){
                    $rootScope.superManager=0;
                    return true;
                }

                else return false;
            }else return false;
        };
        if(fromState.name!=''&&fromState.name!='login'){
            if(toState.name=='login')
                 //console.log("getLoginUser   "+$rootScope.expireTimeFactory);
            if($cookies.getObject("login_admin")!=undefined)
                $rootScope.getLoginAdmin();
        }else{
           // console.log("刷新时间：  "+$rootScope.expireTimeFactory);

        }
        $rootScope.pageShow=function (pageName) {
            //return true;
            if($cookies.getObject("navList")!=undefined){
                if($cookies.getObject("navList").subNavName.indexOf(pageName)>=0||$cookies.getObject("login_admin").adminRole==1)
                    return true;
                else return false;
            }else return false;
        };
    });
    var adminIntercepter = {
        request: function (config) {
            if($cookies.getObject("login_admin")!=undefined){
                var now = new Date();
                var expireDate = new Date(now);
                expireDate.setSeconds(expireDate.getSeconds() +60*60*24);//30分钟
                $cookies.putObject("login_admin", $cookies.getObject("login_admin"), {'expires': expireDate});
                $cookies.putObject("navList", $cookies.getObject("navList"), {'expires': expireDate});
            }

            return config;
        },
        response: function (response) {
            return response;
        }
    };
    return adminIntercepter;
}]);
