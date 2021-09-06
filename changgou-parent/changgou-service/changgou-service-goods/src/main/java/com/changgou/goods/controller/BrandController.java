package com.changgou.goods.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController extends AbstractCoreController<Brand>{

    private BrandService  brandService;

    @Autowired
    public BrandController(BrandService  brandService) {
        super(brandService, Brand.class);
        this.brandService = brandService;
    }
}
