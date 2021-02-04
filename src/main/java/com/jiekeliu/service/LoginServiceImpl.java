package com.jiekeliu.service;

import com.jiekeliu.mapper.UserMapper;
import com.jiekeliu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2021/2/4 0004 16:18
 * @Description:
 */

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Map checkUser(String username, String password) {
        HashMap<String, Object> response = new HashMap<>();
        HashMap<String, Object> responseData = new HashMap<>();
        User oneUser = userMapper.getOneUserByName(username);

        if (oneUser == null){
            responseData.put("token","error");
            responseData.put("info","该用户不存在");
            response.put("code",20000);
            response.put("data",responseData);
            return response;
        }

        if (oneUser.getPassword().equals(password)){
            responseData.put("token","success");
            responseData.put("info","登录成功");
            response.put("code",20000);
            response.put("data",responseData);
            return response;
        }else{
            responseData.put("token","error");
            responseData.put("info","密码错误，请重新输入");
            response.put("code",20000);
            response.put("data",responseData);
            return response;
        }

    }
}
