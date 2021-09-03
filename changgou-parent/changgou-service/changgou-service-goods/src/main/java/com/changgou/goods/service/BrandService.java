package com.changgou.goods.service;

import com.changgou.goods.pojo.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> findAll();

    Brand findById(Integer id);

    void add(Brand brand);

    void update(Brand brand);

    void deleteById(Integer id);

    List<Brand> search(Brand brand);
}