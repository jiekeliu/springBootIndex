package com.jiekeliu.service;

import com.jiekeliu.pojo.Article;
import com.jiekeliu.pojo.User;

import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2021/2/4 0004 11:44
 * @Description:
 */
public interface UserService {

    //    分页查询
    Map geDataByPage(int page, int pageSize, boolean sort);

    //    添加
    Map addUser(User user);

    //    删除
    Map delUserById(int uid);

    //    修改
    Map upUser(User user);

    //    根据id查询
    Map getOneUserById(int uid);

}
