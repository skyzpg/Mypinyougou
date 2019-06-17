package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;
    @Override
    public List<TbBrand> findAll() {
        List<TbBrand> tbBrands = tbBrandMapper.selectByExample(null);
        return tbBrands;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize );
        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(null);
        PageResult pageResult = new PageResult(page.getTotal(),page.getResult());
        return pageResult;
    }

    @Override
    public void save(TbBrand tbBrand) {

        tbBrandMapper.insert(tbBrand);
    }

    @Override
    public void update(TbBrand tbBrand) {

        tbBrandMapper.updateByPrimaryKey(tbBrand);

    }

    @Override
    public TbBrand findOne(Long id) {

        TbBrand tbBrand = tbBrandMapper.selectByPrimaryKey(id);
        return tbBrand;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbBrand tbBrand, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize );
        TbBrandExample example =new TbBrandExample();
        if(tbBrand!=null){
            Criteria criteria = example.createCriteria();
            if(tbBrand.getName()!=null && tbBrand.getName().length()>0){
                criteria.andNameLike("%"+tbBrand.getName()+"%");
            }
            if(tbBrand.getFirstChar()!=null && tbBrand.getFirstChar().length()>0){
                criteria.andFirstCharLike("%"+tbBrand.getFirstChar()+"%");
            }
        }
        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(example);
        PageResult pageResult = new PageResult(page.getTotal(),page.getResult());
        return pageResult;
    }

    @Override
    public List<Map> selectBrandList() {

      return tbBrandMapper.selectBrandList();
    }
}
