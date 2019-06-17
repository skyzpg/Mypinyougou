package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
import java.util.Map;

public interface BrandService {

    public List<TbBrand> findAll();

    public PageResult findPage(int pageNum,int pageSize);

    public void save(TbBrand tbBrand);

    public void update(TbBrand tbBrand);
    public TbBrand findOne(Long id);

    public void delete(Long[] ids);

    public PageResult findPage(TbBrand tbBrand,int pageNum,int pageSize);

    public List<Map> selectBrandList();

}
