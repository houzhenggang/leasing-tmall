define(['angular', 'angular-route', 'ui.bootstrap', 'ui.grid'], function(angular){
   var app = angular.module('relay', ['ngRoute', 'ui.bootstrap', 'ui.grid', 'ui.grid.pagination', 'ui.grid.selection', 'ui.grid.exporter']);
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
                     }
                  ];
               },
            test : '1'
         }
      }
   });

   return app;
});
