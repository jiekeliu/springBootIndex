package com.jiekeliu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: jiekeliu
 * @Date: 2021/2/3 0003 15:39
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebInfo {
    /*
      status: 'draft',
      web_icon_url: '默认网站icon链接', //网站icon链接
      web_name: '网站名称', // 网站名称
      web_title: '网站标题', // 网站标题
      web_subtitle: '网站副标题', // 网站副标题
      web_bgimg_url: '网站背景图链接', // 网站背景图链接
      web_manager: '网站管理者(关联用户列表)', // 网站管理者(关联用户列表)
      web_describe: '关于网站', // 关于网站
      web_describe_img_url: '关于网站背景图地址', // 关于网站背景图地址
      web_code: '网站备案号', // 网站备案号
      article_bg_url: '文章背景图', // 文章背景图
      web_connection: '站长联系方式' // 站长联系方式
    * */
    private String status ;
    private String web_icon_url; //网站icon链接
    private String web_name;  // 网站名称
    private String web_title;  // 网站标题
    private String web_subtitle;  // 网站副标题
    private String web_bgimg_url;  // 网站背景图链接
    private String web_manager;  // 网站管理者(关联用户列表)
    private String web_describe;  // 关于网站
    private String web_describe_img_url;  // 关于网站背景图地址
    private String web_code;  // 网站备案号
    private String article_bg_url;  // 文章背景图
    private String  web_connection;  // 站长联系方式


}
