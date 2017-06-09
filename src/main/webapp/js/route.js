define(['angular', 'require', 'angular-route', 'ui.bootstrap', 'ui.grid'], function(angular, require){
    angular.module('relay', ['ngRoute', 'ui.bootstrap', 'ui.grid', 'ui.grid.pagination'])
        //.provider('menuProvider', function(){
        //    this.$get = function(){
        //        //$http.get("http://localhost:8080/menus", function(resp){
        //        //    if(resp.success){
        //        //            return resp.data;
        //        //        }
        //        //    }
        //        //)
        //
        //        return [{
        //            name: '用户管理',
        //            collapsed: 'true',
        //            subMenus:[{
        //                name:'用户列表',
        //                href:'/users',
        //                controller: 'userController',
        //                tplUrl: 'html/user-list.html',
        //                path: 'js/controller/userController.js'
        //            }]
        //        }];
        //    }
        //})
        .config(['$routeProvider', '$controllerProvider', function($routeProvider, $controllerProvider){
            var routes = [{
                name: '用户管理',
                collapsed: 'true',
                subMenus:[{
                    name:'用户列表',
                    href:'/users',
                    collapsed:true,
                    controller: 'userController',
                    tplUrl: 'tpl/user-list.html',
                    path: 'js/controller/userController.js'
                }]
            }];
            for(var i in routes){
                const menu = routes[i];
                if(menu.subMenus){
                    for(var j in menu.subMenus){
                        const subMenu = menu.subMenus[j];
                        $routeProvider.when(subMenu.href, {
                            templateUrl: subMenu.tplUrl,
                            controller: subMenu.controller,
                            resolve:{
                                register: function($q){
                                    var deferred = $q.defer();
                                    require([subMenu.path], function(aController){
                                        $controllerProvider.register(subMenu.controller, aController);
                                        deferred.resolve();
                                    });
                                    return deferred.promise;
                                }
                            }
                        })
                    }
                }else{
                    $routeProvider.when(menu.href, {
                        templateUrl: menu.tplUrl,
                        controller: menu.controller,
                        resolve:{
                            register: function($q){
                                var deferred = $q.defer();
                                require([menu.path], function(aController){
                                    $controllerProvider.register(menu.controller, aController);
                                    deferred.resolve();
                                });
                                return deferred.promise;
                            }
                        }
                    })
                }
            }

            //$routeProvider.otherwise({redirectTo: 'index.html'})
        }])
        .controller("navController" , ['$scope', function($scope){
            $scope.navCollapsed = true;
            $scope.menuCollapsed = false;
            $scope.menus = [{
                            id: 'userManage',
                            name: '用户管理',
                            collapsed: 'true',
                            subMenus:[{
                                name:'用户列表',
                                collapsed:true,
                                href:'/users',
                                controller: 'userController',
                                tplUrl: 'html/user-list.html',
                                path: 'js/controller/userController.js'
                            }]
                        },{
                id: 'rcManage',
                name: '风控管理',
                collapsed:true,
                subMenus:[{
                    name:'客户信息',
                    href:'/risk-control/customers',
                    controller:'rcCustomerController',
                    tplUrl: 'html/rc/customers.html',
                    path:'js/controller/rcCustomerController.js'
                }, {
                    name:'回调日志',
                    href:'/risk-control/callbacks',
                    controller:'rcCallBackController',
                    tplUrl:'html/rc/callbacks.html',
                    path:'js/controller/rcCallBackController.js'
                }]
            }];

        }])
});
