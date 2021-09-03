package com.changgou.goods.service.impl;

import com.changgou.goods.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void deleteById(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Brand> search(Brand brand) {
        Example example = createExample(brand);


        final List<Brand> brandList = brandMapper.selectByExample(example);

        return brandList;
    }

    private Example createExample(Brand brand) {
        //条件对象
        Example example = new Example(Brand.class);

        if (brand != null){
            final Example.Criteria criteria = example.createCriteria();
            if (!StringUtils.isEmpty(brand.getName())){
                criteria.andLike("name", "%"+brand.getName()+"%");
            }

            if (!StringUtils.isEmpty(brand.getLetter())){
                criteria.andEqualTo("letter",brand.getLetter());
            }
        }

        //指定要查询的条件的POJO的属性名
        return example;
    }

    @Override
    public PageInfo<Brand> findByPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        final List<Brand> brandList = brandMapper.selectAll();

        final PageInfo<Brand> pageInfo = new PageInfo<>(brandList);
        return pageInfo;
    }

    @Override
    public PageInfo<Brand> findByPage(Integer page, Integer size, Brand brand) {

        PageHelper.startPage(page, size);

        final Example example = createExample(brand);
        final List<Brand> brandList = brandMapper.selectByExample(example);

        final PageInfo<Brand> pageInfo = new PageInfo<>(brandList);
        return pageInfo;
    }


}
