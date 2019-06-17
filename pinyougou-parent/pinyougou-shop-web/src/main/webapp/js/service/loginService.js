app.service('loginService',function($http){

    this.loginName=function(){
        //读取登录人名称
        return $http.get('../login/name.do');
    }

})