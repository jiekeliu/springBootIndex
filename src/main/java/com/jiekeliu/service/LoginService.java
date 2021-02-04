package com.jiekeliu.service;

import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2021/2/4 0004 16:14
 * @Description:
 */
public interface LoginService {

    //用户验证
    Map checkUser(String username, String password);


}
