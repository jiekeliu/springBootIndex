package com.jiekeliu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2021/1/4 0004 18:05
 * @Description:首页重定向控制器
 */

@RequestMapping
@Controller
public class RedirectIndex {
    @GetMapping("/index")
    @CrossOrigin(origins = "*")
    public String indexRedirect(){
        return "/simple/index.html";
    }
}
