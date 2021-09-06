package com.changgou.goods.service.impl;

import com.changgou.core.service.CoreService;
import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandServiceImpl extends CoreServiceImpl<Brand> implements BrandService {
    @Autowired
    private BrandMapper brandMapper;


    public BrandServiceImpl(BrandMapper brandMapper) {
        super(brandMapper, Brand.class);
    }
}
