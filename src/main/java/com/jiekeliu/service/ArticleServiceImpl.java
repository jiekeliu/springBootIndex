package com.jiekeliu.service;

import com.jiekeliu.mapper.ArticleMapper;
import com.jiekeliu.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2021/1/5 0005 21:57
 * @Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Map geDataByPage(int page, int pageSize, boolean sort) {

        HashMap<String, Object> responseInfo = new HashMap<>();
        int articleCount = articleMapper.getArticleCount();

        boolean expage = (articleCount/pageSize+1)>=page?true:false;
        if (expage){
            int start = (page-1)*pageSize;
            List<Article> data;
            if (sort){
                data = articleMapper.getDataDesc(start, pageSize);
            }else {
                data = articleMapper.getDataAse(start, pageSize);
            }
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","查询成功");

            HashMap<Object, Object> article_data = new HashMap<>();
            article_data.put("total", articleCount);

            article_data.put("items",data);

            responseInfo.put("data",article_data);
            return responseInfo;
        }else {
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","请求失败");

            HashMap<Object, Object> article_data = new HashMap<>();
            article_data.put("total", 0);
            List<Article> listItems = new ArrayList<>() ;
            article_data.put("items",listItems);
            responseInfo.put("data",article_data);
            return responseInfo;
        }
    }

    @Override
    public Map addArticle(Article article) {
        HashMap<String, Object> responseInfo = new HashMap<>();

        int add_res = articleMapper.addArticle(article);
        if (add_res == 1){
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","添加成功");
            return responseInfo;
        }else {
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","添加失败");
            return responseInfo;
        }
    }

    @Override
    public Map delArticleById(int id) {
        HashMap<String, Object> responseInfo = new HashMap<>();

        int del_res = articleMapper.delArticleById(id);

        if (del_res == 1){
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","删除成功");
            return responseInfo;
        }else {
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","删除失败");
            return responseInfo;
        }
    }

    @Override
    public Map upArticle(Article article) {

        HashMap<String, Object> responseInfo = new HashMap<>();

        int up_res = articleMapper.upArticle(article);
        if (up_res == 1){
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","修改成功");
            return responseInfo;
        }else {
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","修改失败");
            return responseInfo;
        }
    }

    @Override
    public Map getOneArticleById(int id) {

        HashMap<String, Object> responseInfo = new HashMap<>();
        Article oneArticleById = articleMapper.getOneArticleById(id);

        if (oneArticleById != null){
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","查询成功");
            responseInfo.put("data",oneArticleById);
            return responseInfo;
        }else {
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","请求失败");
            return responseInfo;
        }
    }
}
