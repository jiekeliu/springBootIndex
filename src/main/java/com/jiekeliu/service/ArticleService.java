package com.jiekeliu.service;

import com.jiekeliu.pojo.Article;

import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2021/1/5 0005 21:54
 * @Description:
 */
public interface ArticleService {

    //    分页查询
    Map geDataByPage(int page, int pageSize, boolean sort);

    //    添加
    Map addArticle(Article article);

    //    删除
    Map delArticleById(int id);

    //    修改
    Map upArticle(Article article);

    //    根据id查询Catalogue
    Map getOneArticleById(int id);
}
