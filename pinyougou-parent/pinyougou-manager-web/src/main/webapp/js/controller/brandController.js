app.controller('brandController', function ($scope, $http,$controller,brandService) {

$controller('baseController',{$scope:$scope});
    //读取列表数据绑定到表单中
    $scope.findAll = function () {
        brandService.findAll.success(
            function (response) {
                $scope.list = response;
            }
        );
    }

    //新增
    $scope.save =function(){
        var object = null;
        if($scope.entity.id!=null){
            object =brandService.update($scope.entity);
        }else{
            object =brandService.add($scope.entity);
        }
        object.success(
            function (response) {
                $scope.reloadList();
            }
        );
    }
    //查找一个
    $scope.findOne =function(id){
        brandService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    }
    $scope.delete = function(ids){
        brandService.delete($scope.selectIds).success(
            function (response){
                $scope.reloadList();
            }
        )
    }
    $scope.searchBrand={};
    $scope.search=function(pages,rows){
        brandService.search(pages,rows,$scope.searchBrand).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }

});