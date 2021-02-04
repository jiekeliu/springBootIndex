package com.jiekeliu.service;

import com.jiekeliu.mapper.UserMapper;
import com.jiekeliu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2021/2/4 0004 11:44
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Map geDataByPage(int page, int pageSize, boolean sort) {
        HashMap<String, Object> responseInfo = new HashMap<>();
        int userCount = userMapper.getUserCount();

        boolean expage = (userCount/pageSize+1)>=page?true:false;
        if (expage){
            int start = (page-1)*pageSize;
            List<User> data;
            if (sort){
                data = userMapper.getDataDesc(start, pageSize);
            }else {
                data = userMapper.getDataAse(start, pageSize);
            }
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","查询成功");

            HashMap<Object, Object> user_data = new HashMap<>();
            user_data.put("total", userCount);

            user_data.put("items",data);

            responseInfo.put("data",user_data);
            return responseInfo;
        }else {
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","请求失败");

            HashMap<Object, Object> user_data = new HashMap<>();
            user_data.put("total", 0);
            List<User> listItems = new ArrayList<>() ;
            user_data.put("items",listItems);
            responseInfo.put("data",user_data);
            return responseInfo;
        }
    }

    @Override
    public Map addUser(User user) {
        HashMap<String, Object> responseInfo = new HashMap<>();

        User oneUser = userMapper.getOneUserByName(user.getUsername());

        if (oneUser != null){
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","添加失败,该用户已存在");
            return responseInfo;
        }

        int add_res = userMapper.addUser(user);
        if (add_res == 1){
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","添加成功");
            return responseInfo;
        }else {
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","添加失败");
            return responseInfo;
        }
    }

    @Override
    public Map delUserById(int uid) {
        HashMap<String, Object> responseInfo = new HashMap<>();

        int del_res = userMapper.delUserById(uid);

        if (del_res == 1){
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","删除成功");
            return responseInfo;
        }else {
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","删除失败");
            return responseInfo;
        }
    }

    @Override
    public Map upUser(User user) {
        HashMap<String, Object> responseInfo = new HashMap<>();

        int up_res = userMapper.upUser(user);
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

    @Override
    public Map getOneUserById(int uid) {
        HashMap<String, Object> responseInfo = new HashMap<>();
        User oneUserById = userMapper.getOneUserById(uid);

        if (oneUserById != null){
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","查询成功");
            responseInfo.put("data",oneUserById);
            return responseInfo;
        }else {
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","请求失败");
            return responseInfo;
        }
    }
}
