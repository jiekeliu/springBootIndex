package com.jiekeliu.mapper;

import com.jiekeliu.pojo.WebInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Auther: jiekeliu
 * @Date: 2021/2/3 0003 15:48
 * @Description:
 */

@Mapper
@Repository
public interface WebInfoMapper {
    // 查询数据
    WebInfo getData();

    //  修改
    int upWebInfo(WebInfo webInfo);
}
