'use strict';

require.config({
    baseUrl: "js/",
    paths:{
        'angular': ['http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min'],
        'angular-touch': ['http://apps.bdimg.com/libs/angular.js/1.4.6/angular-touch.min'],
        'angular-animate': ['http://apps.bdimg.com/libs/angular.js/1.4.6/angular-animate.min'],
        'angular-route':['http://apps.bdimg.com/libs/angular.js/1.4.6/angular-route.min'],
        'ui.bootstrap' : 'lib/ui-bootstrap-tpls-2.5.0.min',
        'ui.grid': ['https://cdn.rawgit.com/angular-ui/bower-ui-grid/master/ui-grid.min']
        //, 'lib/ui-grid-4.0.4'
        //'ui.router' :'http://apps.bdimg.com/libs/angular-ui-router/0.2.15/angular-ui-router.min',
    },
    shim:{
        angular:{
            exports: 'angular'
        },
        'angular-touch':['angular'],
        'angular-animate':['angular'],
        'angular-route':['angular'],
        'ui.bootstrap':['angular'],
        'ui.grid':['angular', 'angular-touch', 'angular-animate']
    }
});

require(['angular', 'route'], function(angular){
    angular.bootstrap(document, ['relay']);
});