package com.jiekeliu.controller;

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
 * @Date: 2020/12/19 0019 13:45
 * @Description:
 */
@RequestMapping
@RestController
public class Structure {

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
}
