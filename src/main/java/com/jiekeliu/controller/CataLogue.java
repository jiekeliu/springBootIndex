package com.jiekeliu.controller;

import com.jiekeliu.pojo.Catalogue;
import com.jiekeliu.service.CatalogueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/6 0006 18:15
 * @Description:
 */

@RequestMapping
@RestController
public class CataLogue {

    @Autowired
    CatalogueServiceImpl catalogueService;

    @GetMapping("/catalogue")
    @CrossOrigin(origins = "*")
     /*分页请求参数
        page: 1    //页数
        limit: 20  //每页对象数
        sort: false //是否倒序 false=asc,ture=desc
        * */
    public Map getCatalogue(@RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam("sort") boolean sort){
        Map catalogue_res = catalogueService.getAll(page, limit, sort);
        return catalogue_res;
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
            Map oneCatalogueById = catalogueService.getOneCatalogueById(cid);

            return oneCatalogueById;

        }
    }


    @PostMapping("/catalogueAdd")
    @CrossOrigin(origins = "*")
    public Map addcatalogue(Catalogue catalogue){
        Map res_add = catalogueService.addCatalogue(catalogue);

        return res_add;
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
            Map res_up = catalogueService.upCatalogue(catalogue);
            return res_up;
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
            Map res_del = catalogueService.delCatalogueById(cid);
            return res_del;
        }
    }


}
