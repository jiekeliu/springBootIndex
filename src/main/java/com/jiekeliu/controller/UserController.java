package com.jiekeliu.controller;

import com.jiekeliu.pojo.User;
import com.jiekeliu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2021/2/4 0004 12:19
 * @Description:
 */

@RequestMapping
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/userlist")
    @CrossOrigin(origins = "*")
     /*分页请求参数
        page: 1    //页数
        limit: 20  //每页对象数
        sort: false //是否倒序 false=asc,ture=desc
        * */
    public Map getUser(@RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam("sort") boolean sort){

        Map res_data = userService.geDataByPage(page, limit, sort);
        return res_data;
    }

    @GetMapping("/userOne")
    @CrossOrigin(origins = "*")
    public Map getUserOne(@RequestParam("uid") int uid){

        Map one_data = userService.getOneUserById(uid);
        return one_data;
    }


    @PostMapping("/userAdd")
    @CrossOrigin(origins = "*")
    public Map addUser(User user){
        Map res_add = userService.addUser(user);
        return res_add;
    }


    @PostMapping("/userDel")
    @CrossOrigin(origins = "*")
    public Map delUser(@RequestParam("uid") int uid){
        Map res_del = userService.delUserById(uid);
        return res_del;
    }

    @PostMapping("/userUp")
    @CrossOrigin(origins = "*")
    public Map upUser(User user){
        Map res_add = userService.upUser(user);
        return res_add;
    }

}
