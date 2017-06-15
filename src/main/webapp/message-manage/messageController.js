define(['app'], function(app){
    return function($scope, $http, i18nService){
        i18nService.setCurrentLang("zh-cn");

        $scope.queryObj = {};

        $scope.dateTimePicker = {
            outgoingTimeFrom:{
                opened: false,
                open: function(){
                    this.opened = true;
                }
            },
            outgoingTimeTo:{
                opened:false,
                open: function(){
                    this.opened = true;
                }
            }
        };

        $scope.dateOptions = {

        };

        var paginationOptions = {
            queryObj: $scope.queryObj,
            pageNum: 1,
            pageSize: 20
        };

        $scope.gridOptions = {
            paginationPageSizes: [20, 50, 100],
            paginationPageSize: 20,
            useExternalPagination: true,
            enableColumnResizing:true,
            //useExternalSorting: true,
            enableGridMenu: true,
            enableFiltering: true,
            enableSorting: true,
            columnDefs:[
                {field:'id', visible:false},
                {name:'主题', field:'topic'},
                {name:'授权appKey', field:'pubAppKey'},
                {name:'发布时间', field:'pubTime'},
                {name:'接收时间', field:'outgoingTime'},
                {field:'userId', visible:false},
                {name:'授权用户名', field:'userNick'},
                {name:'内容', field:'content', width:'500'}
            ],
            exporterAllDataFn: function() {
                paginationOptions.pageNum = 1;
                if(!$scope.gridOptions.totalItems){
                    alert("");
                    throw "";
                }

                paginationOptions.pageSize = $scope.gridOptions.totalItems;

                return $scope.getPage();
                    //.then(function() {
                    //    $scope.gridOptions.useExternalPagination = false;
                    //    $scope.gridOptions.useExternalSorting = false;
                    //    getPage = null;
                    //});
            },
            onRegisterApi: function(gridApi) {
                $scope.gridApi = gridApi;
                //$scope.gridApi.core.on.sortChanged($scope, function(grid, sortColumns) {
                //    if (sortColumns.length == 0) {
                //        paginationOptions.sort = null;
                //    } else {
                //        paginationOptions.sort = sortColumns[0].sort.direction;
                //    }
                //    getPage();
                //});
                gridApi.pagination.on.paginationChanged($scope, function (pageNum, pageSize) {
                    paginationOptions.pageNum = pageNum;
                    paginationOptions.pageSize = pageSize;
                    $scope.getPage();
                });
            }
        };

        $scope.getPage = function(){
            return $http.post("/messages", paginationOptions)
                .success(function(resp){
                    if(resp.success){
                        $scope.gridOptions.totalItems = resp.page.totalRecords;
                        $scope.gridOptions.data = resp.page.data;
                    }
                });
        };

    }
});
