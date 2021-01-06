package com.jiekeliu.controller;

import com.jiekeliu.pojo.Article;
import com.jiekeliu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Auther: jiekeliu
 * @Date: 2021/1/5 0005 14:35
 * @Description:
 */

@RequestMapping
@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/articlelist")
    @CrossOrigin(origins = "*")
     /*分页请求参数
        page: 1    //页数
        limit: 20  //每页对象数
        sort: false //是否倒序 false=asc,ture=desc
        * */
    public Map getArticle(@RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam("sort") boolean sort){

        Map res_data = articleService.geDataByPage(page, limit, sort);

        return res_data;
    }


    @GetMapping("/articleOne")
    @CrossOrigin(origins = "*")
    public Map getArticleOne(@RequestParam("id") int id){

        Map one_data = articleService.getOneArticleById(id);
        return one_data;
    }


    @PostMapping("/articleAdd")
    @CrossOrigin(origins = "*")
    public Map addArticle(Article article){
        Map res_add = articleService.addArticle(article);
        return res_add;
    }


    @PostMapping("/articleDel")
    @CrossOrigin(origins = "*")
    public Map delArticle(@RequestParam("id") int id){
        Map res_del = articleService.delArticleById(id);
        return res_del;
    }

    @PostMapping("/articleUp")
    @CrossOrigin(origins = "*")
    public Map upArticle(Article article){
        Map res_add = articleService.upArticle(article);
        return res_add;
    }


}
