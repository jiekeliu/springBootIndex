package com.jiekeliu.controller;

import com.jiekeliu.pojo.Catalogue;
import com.jiekeliu.pojo.Stracture;
import com.jiekeliu.service.CatalogueServiceImpl;
import com.jiekeliu.service.StractureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @CrossOrigin
    public Map getStacture(){

        List<Stracture> all_stacture = stractureService.getAll();

        HashMap<String, Object> responseInfo = new HashMap<>();
        responseInfo.put("code",20000);
        responseInfo.put("status","ok");
        responseInfo.put("info","请求成功");
        responseInfo.put("data",all_stacture);

        System.out.println(responseInfo);

        return responseInfo;
    }

    @PostMapping("/stractureAdd")
    @CrossOrigin(origins = "*")
    public Map addStacture(Stracture stracture){
        System.out.println(stracture);

        int catalogueAdd_result = stractureService.addStracture(stracture);
        if (catalogueAdd_result == 1){
            HashMap<String, Object> responseInfo = new HashMap<>();
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","添加成功");
            return responseInfo;
        }else {
            HashMap<String, Object> responseInfo = new HashMap<>();
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","添加错误");
            return responseInfo;
        }

    }

    @PostMapping("/stractureUp")
    @CrossOrigin(origins = "*")
    public Map upStacture(Stracture stracture){
        System.out.println(stracture);
        if (stracture.getSid() == 0){
            HashMap<String, Object> responseInfo = new HashMap<>();
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","缺少序列号");
            return responseInfo;
        }else {
            int stractureUp_result = stractureService.upStracture(stracture);
            if (stractureUp_result == 1){
                HashMap<String, Object> responseInfo = new HashMap<>();
                responseInfo.put("code",20000);
                responseInfo.put("status","ok");
                responseInfo.put("info","修改成功");
                return responseInfo;
            }else {
                HashMap<String, Object> responseInfo = new HashMap<>();
                responseInfo.put("code",20000);
                responseInfo.put("status","error");
                responseInfo.put("info","修改错误");
                return responseInfo;
            }
        }
    }

    @PostMapping("/stractureDel")
    @CrossOrigin(origins = "*")
    public Map delStacture(@RequestParam("sid") int sid){
        System.out.println(sid);
        if (sid == 0 ){
            HashMap<String, Object> responseInfo = new HashMap<>();
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","缺少序列号");
            return responseInfo;
        }else {
            int del_res = stractureService.delStractureById(sid);
            if (del_res == 1){
                HashMap<String, Object> responseInfo = new HashMap<>();
                responseInfo.put("code",20000);
                responseInfo.put("status","ok");
                responseInfo.put("info","删除成功");
                return responseInfo;
            }else {
                HashMap<String, Object> responseInfo = new HashMap<>();
                responseInfo.put("code",20000);
                responseInfo.put("status","error");
                responseInfo.put("info","删除错误");
                return responseInfo;
            }
        }
    }

    @PostMapping("/stractureOne")
    @CrossOrigin(origins = "*")
    public Map getStactureOne(@RequestParam("sid") int sid){
        System.out.println(sid);
        if (sid == 0 ){
            HashMap<String, Object> responseInfo = new HashMap<>();
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","请求错误");
            return responseInfo;
        }else {
            Stracture oneStracture = stractureService.getOneStractureById(sid);
            HashMap<String, Object> responseInfo = new HashMap<>();
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","请求成功");
            responseInfo.put("data",oneStracture);
            return responseInfo;
        }
    }


    @GetMapping("/catalogue")
    @CrossOrigin(origins = "*")
    public Map getCatalogue(){

        List<Catalogue> all_catalogue = catalogueService.getAll();
        System.out.println(all_catalogue);

        HashMap<String, Object> responseInfo = new HashMap<>();
        responseInfo.put("code",20000);
        responseInfo.put("status","ok");
        responseInfo.put("info","请求成功");
        responseInfo.put("data",all_catalogue);

        return responseInfo;
    }

    @PostMapping("/catalogueOne")
    @CrossOrigin(origins = "*")
    public Map getCatalogueOne(@RequestParam("cid") int cid){

        System.out.println(cid);
        if (cid == 0 ){
            HashMap<String, Object> responseInfo = new HashMap<>();
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","请求错误");
            return responseInfo;
        }else {
            Catalogue oneCatalogueById = catalogueService.getOneCatalogueById(cid);
            HashMap<String, Object> responseInfo = new HashMap<>();
            responseInfo.put("code",20000);
            responseInfo.put("info","请求成功");
            responseInfo.put("data",oneCatalogueById);

            return responseInfo;
        }
    }


    @PostMapping("/catalogueAdd")
    @CrossOrigin(origins = "*")
    public Map addcatalogue(Catalogue catalogue){
        System.out.println(catalogue);

        int addCatalogue_result = catalogueService.addCatalogue(catalogue);
        if (addCatalogue_result == 1){
            HashMap<String, Object> responseInfo = new HashMap<>();
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","添加成功");
            return responseInfo;
        }else {
            HashMap<String, Object> responseInfo = new HashMap<>();
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","添加失败");
            return responseInfo;
        }

    }

    @PostMapping("/catalogueUp")
    @CrossOrigin(origins = "*")
    public Map upCatalogue(Catalogue catalogue){
        System.out.println(catalogue);
        if (catalogue.getCid() == 0){
            HashMap<String, Object> responseInfo = new HashMap<>();
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","缺少序列号");
            return responseInfo;
        }else {
            int catalogueUp_result = catalogueService.upCatalogue(catalogue);
            if (catalogueUp_result == 1){
                HashMap<String, Object> responseInfo = new HashMap<>();
                responseInfo.put("code",20000);
                responseInfo.put("status","ok");
                responseInfo.put("info","修改成功");
                return responseInfo;
            }else {
                HashMap<String, Object> responseInfo = new HashMap<>();
                responseInfo.put("code",20000);
                responseInfo.put("status","error");
                responseInfo.put("info","修改失败");
                return responseInfo;
            }
        }
    }

    @PostMapping("/catalogueDel")
    @CrossOrigin(origins = "*")
    public Map delCatalogue(@RequestParam("cid") int cid){
        System.out.println(cid);
        if (cid == 0 ){
            HashMap<String, Object> responseInfo = new HashMap<>();
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","缺少序列号");
            return responseInfo;
        }else {
            int del_res = catalogueService.delCatalogueById(cid);
            if (del_res == 1){
                HashMap<String, Object> responseInfo = new HashMap<>();
                responseInfo.put("code",20000);
                responseInfo.put("status","ok");
                responseInfo.put("info","删除成功");
                return responseInfo;
            }else {
                HashMap<String, Object> responseInfo = new HashMap<>();
                responseInfo.put("code",20000);
                responseInfo.put("status","error");
                responseInfo.put("info","删除失败");
                return responseInfo;
            }
        }
    }


}
