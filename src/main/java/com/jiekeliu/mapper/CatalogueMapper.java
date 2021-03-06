package com.jiekeliu.mapper;

import com.jiekeliu.pojo.Catalogue;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/6 0006 19:08
 * @Description:
 */

@Mapper
@Repository
public interface CatalogueMapper {
    //    查询所有数据
    List<Catalogue> getAll(int start, int end);

    //    查询所有数据(倒序)
    List<Catalogue> getAllDesc(int start, int end);

    //    添加
    int addCatalogue(Catalogue catalogue);

    //    删除
    int delCatalogueById(int cid);

    //    修改
    int upCatalogue(Catalogue catalogue);

    //    根据id查询Catalogue
    Catalogue getOneCatalogueById(int cid);


    //    查询数据总量
    int getCatalogueCount();


}
