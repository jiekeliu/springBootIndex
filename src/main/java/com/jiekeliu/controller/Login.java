package com.jiekeliu.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/16 0016 13:30
 * @Description:
 */

@RequestMapping
@RestController
public class Login {

    @CrossOrigin(origins = "*")
    @PostMapping("/vue-admin-template/user/login")
    public Map login() {
//        {"code":20000,"data":{"token":"admin-token"}}
        HashMap<String, Object> response = new HashMap<>();
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("token","admin-token");
        response.put("code",20000);
        response.put("data",responseData);
        return response;
    }

    //    {"code":20000,"data":{"roles":["admin"],"introduction":"I am a super administrator","avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif","name":"Super Admin"}}
    @CrossOrigin(origins = "*")
    @GetMapping("/info")
    public Map info() {
        String[] ar = new String[1];
        ar[0] = "admin";
        HashMap<String, Object> responseInfo = new HashMap<>();
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("roles",ar);
        responseData.put("name","Super admin");
        responseData.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        responseInfo.put("code",20000);
        responseInfo.put("introduction","I am a super administrator");
        responseInfo.put("data",responseData);
        return responseInfo;
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/vue-admin-template/user/logout")
    public Map logout() {
//      {"code":20000,"data":"success"}
        HashMap<String, Object> response = new HashMap<>();
        response.put("code",20000);
        response.put("data","success");
        return response;
    }


}
