package com.changgou.goods.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    //查询所有品牌的数据
    @GetMapping
    public Result<List<Brand>> findAll(){
        final List<Brand> brandList = brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK,"查询成功",brandList);
    }


    //根据品牌ID 获取品牌的数据
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable(name = "id") Integer id){
        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK, "根据id查询单个品牌成功",brand);
    }


    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable(name = "id") Integer id,@RequestBody Brand brand){
        brand.setId(id);
        brandService.update(brand);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(name = "id") Integer id){
        brandService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @PostMapping("/search")
    public Result<List<Brand>> search(@RequestBody Brand brand){
        List<Brand> brandList = brandService.search(brand);
        return new Result(true, StatusCode.OK, "条件查询成功",brandList);
    }

    @GetMapping("/search/{page}/{size}")
    public Result<PageInfo<Brand>> findByPage(@PathVariable(name = "page") Integer page,@PathVariable(name = "size") Integer size){
        PageInfo<Brand> pageInfo = brandService.findByPage(page,size);
        return new Result(true, StatusCode.OK, "分页查询成功",pageInfo);
    }

    @PostMapping("/search/{page}/{size}")
    public Result<PageInfo<Brand>> findByPage(@PathVariable(name = "page") Integer page,
                                              @PathVariable(name = "size") Integer size,
                                              @RequestBody Brand brand){
        PageInfo<Brand> pageInfo = brandService.findByPage(page,size,brand);
        return new Result(true, StatusCode.OK, "条件分页查询成功",pageInfo);
    }


}
