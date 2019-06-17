package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.aspectj.weaver.ast.Var;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        List<TbBrand> brandList = brandService.findAll();
        return brandList;
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page,int size){
        PageResult pageResult = brandService.findPage(page, size);
        return pageResult;
    }

    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand){
        try {
            brandService.save(brand);
            return new Result(true,"增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"增加失败："+e.getMessage());
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand){
        try {
            brandService.update(brand);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }


    @RequestMapping("/findOne")
    public TbBrand findOne(Long id) {
        TbBrand tbBrand = brandService.findOne(id);
        return tbBrand;
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        try {
            brandService.delete(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand tbBrand,int page,int size){
        PageResult pageResult = brandService.findPage(tbBrand,page, size);
        return pageResult;
    }

    @RequestMapping("/selectBrandList")
    public List<Map> selectBrandList (){
        return brandService.selectBrandList();
    }
}
