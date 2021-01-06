package com.jiekeliu.mapper;

import com.jiekeliu.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: jiekeliu
 * @Date: 2021/1/5 0005 18:48
 * @Description:
 */

@Mapper
@Repository
public interface ArticleMapper {


    List<Article> getAll();

    //   分页查询数据
    List<Article> getDataAse(int start, int pageSize);

    //    查询所有数据(倒序)
    List<Article> getDataDesc(int start, int pageSize);

    //    添加
    int addArticle(Article article);

    //    删除
    int delArticleById(int id);

    //    修改
    int upArticle(Article article);

    //    根据id查询
    Article getOneArticleById(int id);

    //    查询数据总量
    int getArticleCount();

}
