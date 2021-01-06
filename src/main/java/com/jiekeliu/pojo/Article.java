package com.jiekeliu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Auther: jiekeliu
 * @Date: 2021/1/5 0005 15:08
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    /*作者        author: "Timothy"
    内容是否展示       comment_disabled: true
    内容       content: "<p>I am testing data, I am testing data.</p><p><img src="https://wpimg.wallstcn.com/4c69009c-0fd4-4153-b112-6cb53d1cf943"></p>"
    简介       content_short: "mock data"
    创作时间       display_time: "1991-06-22 16:26:47"
     预测       forecast: 7.15
     编号       id: 1
     图片链接       image_uri: "https://wpimg.wallstcn.com/e4558086-631c-425c-9430-56ffb46e70b3"
     重要程度       importance: 2
     浏览量       pageviews: 318
     平台       platforms: ["a-platform"]
     评委      reviewer: "Carol"
     状态       status: "published"
     时间戳       timestamp: 189070572428
     标题       title: "Qwbgsndn Ajwvhnld Nxpkhq Mltiykmpe Njvuujw Wpnlj Omp Hqrofhrr Vfu Yctt"
     类型       type: "JP"
     */
    private String author;
    private Boolean comment_disabled;
    private String content;
    private String content_short;
    private String display_time;
    private Double forecast;
    private int id;
    private String image_uri;
    private int importance;
    private int pageviews;
    private String platforms;
    private String reviewer;
    private String status;
    private String timestamp;
    private String title;
    private String type;
}
