define(['angular', 'angular-route', 'angular-locale_zh-cn', 'ui.bootstrap', 'ui.grid'], function(angular){
   var app = angular.module('relay', ['ngRoute', 'ngLocale', 'ui.bootstrap', 'ui.grid',
      'ui.grid.pagination', 'ui.grid.selection', 'ui.grid.exporter', 'ui.grid.pinning',
      'ui.grid.resizeColumns', 'ui.grid.autoResize']);
   app.provider('menuProvider', function(){

      console.log("menuProvider init");
      this.$get = function(){
         return {
            getMenus : function(){
                  //var deferred = $q.defer();
                  //
                  //$http.get("/menus")
                  //   .success(function(resp){
                  //      if(resp.success){
                  //         deferred.resolve(resp.data);
                  //      }else{
                  //         deferred.reject(resp.msg);
                  //      }
                  //   })
                  //   .error(function(){
                  //      deferred.reject("请求失败");
                  //   });
                  //
                  //return d.promise;
                  return [
                     {
                        id: 'userManage',
                        name: '用户管理',
                        collapsed: true,
                        subMenus:[{
                           name:'用户列表',
                           collapsed:true,
                           href:'/users',
                           controller: 'userController',
                           tplUrl: 'user-manage/users.html',
                           path: 'user-manage/userController.js'
                        }]
                     },
                     {
                        id: 'rcManage',
                        name: '风控管理',
                        collapsed:true,
                        subMenus:[{
                           name:'客户信息',
                           collapsed:true,
                           href:'/risk-control/customers',
                           controller:'customerController',
                           tplUrl: 'rc-manage/customers.html',
                           path:'rc-manage/customerController.js'
                        }, {
                           name:'回调日志',
                           collapsed:true,
                           href:'/risk-control/callbacks',
                           controller:'callbackController',
                           tplUrl:'tpl/rc/callbacks.html',
                           path:'js/controller/rc/callbackController.js'
                        }]
                     },
                     {
                        id: 'msgManage',
                        name: '消息管理',
                        collapsed: true,
                        subMenus:[{
                           name:'消息列表',
                           collapsed:true,
                           href:'/messages',
                           controller: 'messageController',
                           tplUrl: 'message-manage/messages.html',
                           path: 'message-manage/messageController.js'
                        }]
                     }
                  ];
               },
            test : '1'
         }
      }
   })
      .factory("loginService", ['$location', '$http', '$cookies', function($location, $http, $cookies){

         return {
            logged : false,
            login: function(user){
               var name = user.name;
               var password = user.password;

               if(name == 'hshc$test' && password == 'xjz1!WOE@z'){
                  logged = true;
               }
               return logged;
            }
         }
      }])
      //.run(['$rootScope', 'loginService', '$location', function($rootScope, loginService, $location){
      //   console.log("loginService...");
      //   $rootScope.$on('$routeChangeStart', function(event, next, current){
      //      if(next != '' && !loginService.logged){
      //         $location.path('');
      //      }
      //   });
      //}])
      .controller("indexController" , ['$scope', 'menuProvider', function($scope, menuProvider){

         $scope.login = false;

         $scope.user = {};

         $scope.signIn = function(){
            //var logged = loginService.login($scope.user);
            $scope.login = true;
            //if(logged){
               $scope.navCollapsed = true;
               $scope.menuCollapsed = false;
               $scope.menus = menuProvider.getMenus();

            //}
         };

      }]);

   return app;
});
