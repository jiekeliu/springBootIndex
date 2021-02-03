package com.jiekeliu.service;

import com.jiekeliu.mapper.WebInfoMapper;
import com.jiekeliu.pojo.WebInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2021/2/3 0003 16:10
 * @Description:
 */

@Service
public class WebInfoServiceImpl implements WebInfoService{

    @Autowired
    WebInfoMapper webInfoMapper;

    @Override
    public Map getData() {
        HashMap<String, Object> responseInfo = new HashMap<>();
        WebInfo data = webInfoMapper.getData();
        responseInfo.put("code",20000);
        responseInfo.put("status","ok");
        responseInfo.put("info","查询成功");
        HashMap<Object, Object> article_data = new HashMap<>();
        article_data.put("items",data);
        responseInfo.put("data",article_data);
        return  responseInfo;
    }

    @Override
    public Map upWebInfo(WebInfo webInfo) {
        HashMap<String, Object> responseInfo = new HashMap<>();

        int up_res = webInfoMapper.upWebInfo(webInfo);
        if (up_res == 1){
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","修改成功");
            return responseInfo;
        }else {
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","修改失败");
            return responseInfo;
        }
    }
}
