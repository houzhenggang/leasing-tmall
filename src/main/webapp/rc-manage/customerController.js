define(['app'], function(app){
    return function($scope, $http, i18nService){
        i18nService.setCurrentLang("zh-cn");

        $scope.queryObj = {};

        $scope.createTimeFrom = {
            opened: false
        };
        $scope.createTimeTo = {
            opened: false
        };

        $scope.dateOptions = {

        };

        var paginationOptions = {
            queryObj: $scope.queryObj,
            pageNum: 1,
            pageSize: 20
        };

        $scope.openCreateTimeFrom = function(){
            $scope.createTimeFrom.opened = true;
        };

        $scope.openCreateTimeTo = function(){
            $scope.createTimeTo.opened = true;
        };

        $scope.gridOptions = {
            paginationPageSizes: [20, 50, 100],
            paginationPageSize: 20,
            useExternalPagination: true,
            //useExternalSorting: true,
            enableGridMenu: true,
            //enableFiltering: true,
            //enableSorting: true,
            columnDefs:[
                {field:'uuid', visible:false},
                {name:'姓名', field:'name'},
                {name:'身份证号', field:'identityNo'},
                {name:'手机号', field:'mobile'},
                {name:'创建时间', field:'createTime'},
                {name:'车型', field:'itemName'}
            ],
            exporterFieldCallback: function(grid, row, col, input) {
                if( col.name == '身份证号' ){
                    return '\'' + input;
                } else {
                    return input;
                }
            },
            exporterAllDataFn: function() {
                paginationOptions.pageNum = 1;
                if(!$scope.gridOptions.totalItems){
                    alert("请先查询！");
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
                gridApi.pagination.on.paginationChanged($scope, function (newPage, pageSize) {
                    paginationOptions.pageNum = newPage;
                    paginationOptions.pageSize = pageSize;
                    $scope.getPage();
                });
            }
        };

        $scope.getPage = function(){
            $http.post("/risk-control/customers", paginationOptions)
                .success(function(resp){
                    if(resp.success){
                        $scope.gridOptions.totalItems = resp.page.totalRecords;
                        $scope.gridOptions.data = resp.page.data;
                    }
                });
        };
    }
});
