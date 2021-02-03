package com.jiekeliu.service;

import com.jiekeliu.pojo.WebInfo;

import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2021/2/3 0003 16:06
 * @Description:
 */
public interface WebInfoService {
    // 查询数据
    Map getData();

    //  修改
    Map upWebInfo(WebInfo webInfo);
}
