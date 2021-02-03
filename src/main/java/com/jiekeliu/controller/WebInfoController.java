package com.jiekeliu.controller;

import com.jiekeliu.pojo.WebInfo;
import com.jiekeliu.service.WebInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2021/2/3 0003 16:21
 * @Description:
 */

@RequestMapping
@RestController
public class WebInfoController {
    @Autowired
    WebInfoService webInfoService;

    @GetMapping("/webinfo")
    @CrossOrigin(origins = "*")
    public Map getWebInfo(){
        Map res_data = webInfoService.getData();
        return res_data;
    }

    @PostMapping("/webinfoUp")
    @CrossOrigin(origins = "*")
    public Map upWebInfo(WebInfo webInfo){
        Map res_add = webInfoService.upWebInfo(webInfo);
        return res_add;
    }


}
