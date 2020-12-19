package com.jiekeliu.service;

import com.jiekeliu.pojo.Catalogue;
import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/6 0006 19:35
 * @Description:
 */
public interface CatalogueService {
    //    查询所有数据
    Map getAll(int page, int limit, boolean sort);

    //    添加
    Map addCatalogue(Catalogue catalogue);

    //    删除
    Map delCatalogueById(int cid);

    //    修改
    Map upCatalogue(Catalogue catalogue);

    //    根据id查询Catalogue
    Map getOneCatalogueById(int cid);
}
