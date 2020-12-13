package com.jiekeliu.controller;

import com.jiekeliu.pojo.Catalogue;
import com.jiekeliu.pojo.Stracture;
import com.jiekeliu.service.CatalogueServiceImpl;
import com.jiekeliu.service.StractureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/6 0006 18:15
 * @Description:
 */

@RequestMapping
@RestController
public class IndexData {

    @Autowired
    CatalogueServiceImpl catalogueService;

    @Autowired
    StractureServiceImpl stractureService;



    @GetMapping("/stracture")
    public List<Stracture> getStacture(){

        List<Stracture> all_stacture = stractureService.getAll();
        System.out.println(all_stacture);

        return all_stacture;
    }

    @GetMapping("/stractureAdd")
    public String addStacture(Stracture stracture){
        System.out.println(stracture);

        int catalogueAdd_result = stractureService.addStracture(stracture);
        if (catalogueAdd_result == 1){
              return "修改成功";
        }else {
              return "未知错误";
        }

    }

    @GetMapping("/stractureUp")
    public String upStacture(Stracture stracture){
        System.out.println(stracture);
        if (stracture.getSid() == 0){
            return "缺少序列号";
        }else {
            int catalogueUp_result = stractureService.upStracture(stracture);
            if (catalogueUp_result == 1){
                return "修改成功";
            }else {
                return "未知错误";
            }
        }
    }

    @GetMapping("/stractureDel")
    public String delStacture(@RequestParam("sid") int sid){
        System.out.println(sid);
        if (sid == 0 ){
            return "缺少序列号";
        }else {
            int del_res = stractureService.delStractureById(sid);
            if (del_res == 1){
                return "删除成功";
            }else {
                return "未知错误";
            }
        }
    }

    @GetMapping("/stractureOne")
    public Stracture getStactureOne(@RequestParam("sid") int sid){
        System.out.println(sid);
        if (sid == 0 ){
            return null;
        }else {
            Stracture oneStracture = stractureService.getOneStractureById(sid);
            return oneStracture;
        }
    }




    @GetMapping("/catalogue")
    public List<Catalogue> getCatalogue(){

        List<Catalogue> all_catalogue = catalogueService.getAll();
        System.out.println(all_catalogue);

        return all_catalogue;
    }

}
