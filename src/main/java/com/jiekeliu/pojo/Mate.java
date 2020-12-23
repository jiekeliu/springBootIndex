package com.jiekeliu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/23 0023 12:51
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mate {
     /*
        {
          mid: 1
          pid: 0
          title: "欢迎来到我的世界",
          url: "http://www.baidu.com",
          subtitle: "我是Jesonker",
          description: "Adventure is never far away",
          image: "img/1.jpg" }
        */


    private int mid;  //id序号
    private int pid;   //父id
    private String title; //标题
    private String url; //连接
    private String subtitle; //子标题
    private String description; //描述
    private String image; //图片地址


}
