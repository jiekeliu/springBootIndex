package com.jiekeliu.service;

import com.jiekeliu.pojo.Stracture;

import java.util.List;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/6 0006 19:34
 * @Description:
 */

public interface StractureService {

    //    查询所有数据
    List<Stracture> getAll();

    //    添加
    int addStracture(Stracture stracture);

    //    删除
    int delStractureById(int sid);

    //    修改
    int upStracture(Stracture stracture);

    //    根据id查询user
    Stracture getOneStractureById(int sid);

}
