package com.jiekeliu.service;

import com.jiekeliu.pojo.Catalogue;

import java.util.List;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/6 0006 19:35
 * @Description:
 */
public interface CatalogueService {
    //    查询所有数据
    List<Catalogue> getAll();

    //    添加
    int addCatalogue(Catalogue catalogue);

    //    删除
    int delCatalogueById(int cid);

    //    修改
    int upCatalogue(Catalogue catalogue);

    //    根据id查询Catalogue
    Catalogue getOneCatalogueById(int cid);
}
