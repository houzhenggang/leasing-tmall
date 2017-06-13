define(['app'], function(app){
    return function($scope, $http, i18nService){
        i18nService.setCurrentLang("zh-cn");

        $scope.queryUser = {};

        $scope.createTime = {
            opened: false
        };

        $scope.dateOptions = {

        };

        var paginationOptions = {
            queryObject: $scope.queryUser,
            pageNum: 1,
            pageSize: 20
        };

        $scope.openCreateTime = function(){
            $scope.createTime.opened = true;
        };

        $scope.gridOptions = {
            paginationPageSizes: [20, 50, 100],
            paginationPageSize: 20,
            useExternalPagination: true,
            //useExternalSorting: true,
            //enableGridMenu: true,
            //enableSorting: true,
            columnDefs:[
                {field:'id', visible:false},
                {name:'姓名', field:'name'},
                {name:'身份证号', field:'idNumber'},
                {name:'手机号', field:'mobile'},
                {name:'创建人', field:'creator.name'},
                {name:'创建时间', field:'createTime'},
                {name:'是否删除', field:'isDel', cellTemplate: '<span>{{grid.appScope.transfer(grid, row)}}</span>'}
            ],
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
                //gridApi.pagination.on.paginationChanged($scope, function (newPage, pageSize) {
                //    paginationOptions.pageNumber = newPage;
                //    paginationOptions.pageSize = pageSize;
                //    $scope.getPage();
                //});
            }
        };

        $scope.getPage = function(){
            $http.post("/users", paginationOptions)
                .success(function(resp){
                    if(resp.success){
                        $scope.gridOptions.totalItems = resp.page.totalRecords;
                        $scope.gridOptions.data = resp.page.data;
                    }
                });
        };

        $scope.transfer = function(grid, row){
            return row.isDel ? "是" : "否";
        };

        //$scope.getPage();
    }
});
