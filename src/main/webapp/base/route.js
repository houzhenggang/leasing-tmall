define(['app', 'require'], function(app, require){
    app.config(['$routeProvider', '$controllerProvider', 'menuProviderProvider', function($routeProvider, $controllerProvider, menuProviderProvider){
        var routes = menuProviderProvider.$get().getMenus();
        for(var i = 0; i < routes.length; i++) {
            if(routes[i].subMenus){
                for(var j = 0; j < routes[i].subMenus.length; j++){
                    const ti = i;
                    const tj = j;
                    $routeProvider.when(routes[i].subMenus[j].href, {
                        templateUrl: routes[i].subMenus[j].tplUrl,
                        controller: routes[i].subMenus[j].controller,
                        resolve:{
                            register: function($q){
                                var deferred = $q.defer();
                                require([routes[ti].subMenus[tj].path], function(aController){
                                    $controllerProvider.register(routes[ti].subMenus[tj].controller, aController);
                                    deferred.resolve();
                                });
                                return deferred.promise;
                            }
                        }
                    })
                }
            }else{
                const ti = i;
                $routeProvider.when(routes[i].href, {
                    templateUrl: routes[i].tplUrl,
                    controller: routes[i].controller,
                    resolve:{
                        register: function($q){
                            var deferred = $q.defer();
                            require([routes[ti].path], function(aController){
                                $controllerProvider.register(routes[ti].controller, aController);
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
    .controller("navController" , ['$scope', 'menuProvider', function($scope, menuProvider){
        $scope.navCollapsed = true;
        $scope.menuCollapsed = false;
        $scope.menus = menuProvider.getMenus();

    }])
});
