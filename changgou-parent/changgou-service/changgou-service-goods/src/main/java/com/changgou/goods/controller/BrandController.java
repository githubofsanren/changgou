package com.changgou.goods.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/brand")
public class BrandController extends AbstractCoreController<Brand> {
    @Autowired
    private BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        super(brandService, Brand.class);
    }


}
