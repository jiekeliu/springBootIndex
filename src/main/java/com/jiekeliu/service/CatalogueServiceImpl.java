package com.jiekeliu.service;

import com.jiekeliu.mapper.CatalogueMapper;
import com.jiekeliu.pojo.Catalogue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/6 0006 19:35
 * @Description:
 */
@Service
public class CatalogueServiceImpl implements CatalogueService {
    @Autowired
    CatalogueMapper catalogueMapper;

    @Override
    public Map getAll(int page, int limit, boolean sort) {
        /*返回数据及格式
        {
            "status": "ok",
            "info": "请求成功",
            "code": 20000,
            "page": 2, //页数
            "total": 100, //数据总量
            "pageSize": 20
            "data": []  //数据
        }
        */
        HashMap<String, Object> responseInfo = new HashMap<>();
        int catalogueCount = catalogueMapper.getCatalogueCount();

        //判断页数是否超出
        boolean expage = (catalogueCount/limit+1)>=page?true:false;

        if (!expage){
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","请求失败，查询的数据超出范围");
            responseInfo.put("page",page);
            responseInfo.put("pageSize",limit);
            responseInfo.put("total",catalogueCount);
            return responseInfo;
        }else {
            int start = (page-1)*limit;
            List<Catalogue> all_catalogue;
            if (sort){
                all_catalogue = catalogueMapper.getAllDesc(start,limit);
            }else {
                all_catalogue = catalogueMapper.getAll(start,limit);
            }
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","请求成功");
            responseInfo.put("page",page);
            responseInfo.put("pageSize",limit);
            responseInfo.put("total",catalogueCount);
            responseInfo.put("data",all_catalogue);

            return responseInfo;
        }

    }

    @Override
    public Map addCatalogue(Catalogue catalogue) {
        int add_res = catalogueMapper.addCatalogue(catalogue);

        if (add_res == 1){
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

    @Override
    public Map delCatalogueById(int cid) {

        int res_del = catalogueMapper.delCatalogueById(cid);
        System.out.println("-----------------------catalogue delCatalogueById--------------");

        if (res_del == 1){
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

    @Override
    public Map upCatalogue(Catalogue catalogue) {
        int res_up = catalogueMapper.upCatalogue(catalogue);
        System.out.println("-----------------------catalogue upCatalogue--------------");
        if (res_up == 1){
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

    @Override
    public Map getOneCatalogueById(int cid) {
        Catalogue oneCatalogueById = catalogueMapper.getOneCatalogueById(cid);
        System.out.println("-----------------------catalogue getOneCatalogueById--------------");
        HashMap<String, Object> responseInfo = new HashMap<>();
        responseInfo.put("code",20000);
        responseInfo.put("info","请求成功");
        responseInfo.put("data",oneCatalogueById);
        return  responseInfo;
    }
}
