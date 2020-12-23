package com.jiekeliu.controller;

import com.jiekeliu.pojo.Mate;
import com.jiekeliu.service.MateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/23 0023 12:56
 * @Description:
 */

@RequestMapping
@RestController
public class MateController {

    @Autowired
    MateServiceImpl mateService ;


    @GetMapping("/mate")
    @CrossOrigin(origins = "*")
     /*分页请求参数
        page: 1    //页数
        limit: 20  //每页对象数
        sort: false //是否倒序 false=asc,ture=desc
        * */
    public Map getCatalogue(@RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam("sort") boolean sort){
        Map cate_res = mateService.geDataByPage(1, 20, false);
        return cate_res;
    }

    @PostMapping("/mateAdd")
    @CrossOrigin(origins = "*")
    public Map addcatalogue(Mate mate){
        Map res_add = mateService.addMate(mate);
        return res_add;
    }


    @PostMapping("/mateDel")
    @CrossOrigin(origins = "*")
    public Map delcatalogue(@RequestParam("mid") int mid){
        Map res_del = mateService.delMateById(mid);
        return res_del;
    }

    @PostMapping("/mateUp")
    @CrossOrigin(origins = "*")
    public Map upcatalogue(Mate mate){
        Map res_add = mateService.upMate(mate);
        return res_add;
    }


}
