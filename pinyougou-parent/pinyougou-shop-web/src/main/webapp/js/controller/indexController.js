app.controller('indexController',function($scope,loginService){


//读取当前登陆人的信息
    $scope.showLoginName=function(){
        loginService.loginName().success(
            function (response) {
                $scope.name =  response.name;
            }
        )
    }



})