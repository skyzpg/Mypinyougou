app.controller('baseController',function($scope){

    //重新加载列表 数据
    $scope.reloadList = function () {
        //切换页码
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }
    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 0,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    };
    //分页
    $scope.findPage = function (pages, rowss) {
        brandService.findPage.success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }
    $scope.selectIds=[];
    $scope.updateSelection=function($evend,id){
        if($evend.target.checked){
            $scope.selectIds.push(id);
        }else{
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx,1);
        }
    }


    $scope.selectAll=function($event){
        $scope.selectIds=[];//清空数组
        var isAllChecked = $event.target.checked;
        if(isAllChecked){
            for(var i=0;i<$scope.list.length;i++){
                $scope.selectIds.push($scope.list[i].id);
            }
        }
    }

})