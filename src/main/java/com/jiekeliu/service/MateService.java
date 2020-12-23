package com.jiekeliu.service;

import com.jiekeliu.pojo.Mate;

import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/23 0023 12:50
 * @Description:
 */
public interface MateService {

    //    分页查询
    Map geDataByPage(int page, int pageSize, boolean sort);

    //    添加
    Map addMate(Mate mate);

    //    删除
    Map delMateById(int mid);

    //    修改
    Map upMate(Mate mate);

    //    根据id查询Catalogue
    Map getOneMateById(int mid);

}
