app.service("brandService",function ($http) {
    this.findAll=function () {
        return $http.get('../brand/findAll.do');
    }

    this.findPage=function(pages, rowss){
        return  $http.get('../brand/findPage.do?page=' + pages + '&size=' + rowss);
    }

    this.findOne=function(id){
        return  $http.get('../brand/findOne.do?id='+id);
    }
    this.delete=function (ids) {
        return $http.get('../brand/delete.do?ids='+ids);
    }

    this.add =function (entity) {
        return $http.post('../brand/add.do',entity);
    }
    this.update =function (entity) {
        return $http.post('../brand/update.do',entity);
    }

    this.search=function(pages,rows,searchBrand){
        return  $http.post('../brand/search.do?page=' + pages + '&size=' + rows,searchBrand);
    }

    this.selectBrandList=function () {

        return $http.get('../brand/selectBrandList.do');
    }
});