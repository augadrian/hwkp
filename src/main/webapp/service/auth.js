angular.module('app').service('authSettingListService', ['$q', '$http','$rootScope',

    function ($q, $http,$rootScope) {
        return {

            //登陆
            adminLogin: function (login,ck) {
                var b = new Base64();
                   $rootScope.loading=true;
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'adminAccount/verifySysAdminAccount',
                    params: {
                        account: b.encode(login.userName),
                        password: b.encode(login.passWord),
                    }
                }).success(function (data) {
                    $rootScope.loading=false;
                    deferred.resolve(data);


                }).error(function (data) {
                    deferred.reject(data);
                });
                return deferred.promise;

            },
            //获取Session
            getLoginAdminSession: function () {
                $rootScope.loading=true;
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'admin_manager/getLoginAdminSession',
                    params: {}
                }).success(function (data) {
                    $rootScope.loading=false;
                    deferred.resolve(data);


                }).error(function (data) {
                    deferred.reject(data);
                });
                return deferred.promise;

            },
            //登出
            logout: function (login) {
                $rootScope.loading=true;
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'admin_manager/logout',
                    params: {
                        adminName: login.adminName,
                        adminPass: login.adminPass,
                        adminId: login.id
                    }
                }).success(function (data) {
                    $rootScope.loading=false;
                    deferred.resolve(data);
                }).error(function (data) {
                    deferred.reject(data);
                });
                return deferred.promise;

            },
            //管理员列表
            loadList: function (pno, psz, admin) {
          //      var accountName;
          //      var accountStatus;
          //      var permissionStatus;
          //// alert(JSON.stringify(admin));
          //      if (admin == null || angular.equals({}, admin)) {
          //         accountName = null;
          //         accountStatus = null;
          //         permissionStatus = null;
          //      } else {
          //         accountName = admin.accountName;
          //         accountStatus = admin.accountStatus;
          //         permissionStatus = admin.permissionStatus;
          //
          //      }
                var obj=angular.fromJson(admin);
                //if (accountStatus == -1)
                //   accountStatus = null;
                //if (permissionStatus == -1)
                //   permissionStatus = null;
                $rootScope.loading=true;
                var deferred = $q.defer(); // 声明延后执行，表示要去监控后面的执行
                $http({
                    method: 'POST',
                    url: 'admin_manager/list',
                    params: {
                        pno: pno,
                        psz: psz,
                        adminName:obj!=undefined&&obj.accountName!=undefined?obj.accountName:'',
                        accountStatus:obj!=undefined&&obj.accountStatus!=undefined?obj.accountStatus:'',
                        permissionStatus:obj!=undefined&&obj.permissionStatus!=undefined?obj.permissionStatus:'',
                    }
                }).success(function (data) {
                    $rootScope.loading=false;
                    deferred.resolve(data);
                }).error(function (data) {
                    deferred.reject(data);
                });
                return deferred.promise;
            },
            //添加管理员
            addManager: function (account) {
                $rootScope.loading=true;
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'admin_manager/addManager',
                    params: {
                        adminName: account.accountName,
                        adminPass: account.passWord,
                        accountStatus: account.status,
                        storeId: account.belongStore
                    }
                }).success(function (data) {
                    $rootScope.loading=false;
                    deferred.resolve(data);
                }).error(function (data) {
                    deferred.reject(data);
                });
                return deferred.promise;
            },
            //检测账户存在
            checkMangerExist: function (adminName, updateOrAdd) {
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'admin_manager/checkExist',
                    params: {
                        adminName: adminName,
                        updateOrAdd: updateOrAdd
                    }
                }).success(function (data) {
                    deferred.resolve(data);
                }).error(function (data) {
                    deferred.reject(data);
                });
                return deferred.promise;
            },
            //修改账户状态
            updateAccountStatus: function (accountStatus, adminId) {
                if (accountStatus == 0) {
                    accountStatus = 1;
                } else if (accountStatus == 1) accountStatus = 0;
                $rootScope.loading=true;
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'admin_manager/updateAccountStatus',
                    params: {
                        accountStatus: accountStatus,
                        adminId: adminId
                    }
                }).success(function (data) {
                    $rootScope.loading=false;
                    deferred.resolve(data);
                }).error(function (data) {
                    deferred.reject(data);
                });
                return deferred.promise;
            },
            //删除管理员
            deleteAdmin: function (adminId) {
                $rootScope.loading=true;
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'admin_manager/deleteAdmin',
                    params: {
                        adminId: adminId
                    }
                }).success(function (data) {
                    $rootScope.loading=false;
                    deferred.resolve(data);
                }).error(function (data) {
                    deferred.reject(data);
                });
                return deferred.promise;
            },
            //根据ID查找
            findAdminById: function (adminId) {
                $rootScope.loading=true;
                var deferred = $q.defer();
                $http({
                    method: "POST",
                    url: "admin_manager/updateAdmin",
                    params: {
                        adminId: adminId
                    }
                }).success(function (data) {
                    $rootScope.loading=false;
                    deferred.resolve(data);
                }).error(function (data) {
                    deferred.reject(data);
                })
                return deferred.promise;
            },
            //更新账户
            updateAdmin: function (account, id) {
                $rootScope.loading=true;
                var deferred = $q.defer();
                $http({
                    method: "POST",
                    url: "admin_manager/updateAdmin",
                    params: {
                        storeIds: account.belongStore,
                        adminId: id,
                        adminName: account.accountName,
                        adminPass: account.passWord,
                        accountStatus: account.status
                    }
                }).success(function (data) {
                    $rootScope.loading=false;
                    deferred.resolve(data);
                }).error(function (data) {
                    deferred.reject(data);
                })
                return deferred.promise;
            },


        }

        // var list=[
        //     {
        //         id:'1',
        //         accountName:'张彬',
        //         loginLastTime:'2016-10-10 14:34:34',
        //         accountStatus:'0',
        //         authStatus:'1'
        //     },
        //     {
        //         id:'2',
        //         accountName:'许凯',
        //         loginLastTime:'2016-11-10 14:34:34',
        //         accountStatus:'1',
        //         authStatus:'0'
        //     },
        //     {
        //         id:'3',
        //         accountName:'沈一峰',
        //         loginLastTime:'2016-10-10 11:20:34',
        //         accountStatus:'1',
        //         authStatus:'1'
        //     }
        // ]
        //
        // return{
        //     loadList:function () {
        //         return $q.when(list);
        //     }
        // }
    }]);