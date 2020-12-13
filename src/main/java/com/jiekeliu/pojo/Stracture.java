package com.jiekeliu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/6 0006 19:05
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stracture {
    private int sid;
    private boolean isPage;
    private String tag;
    private String list;

    public Stracture(boolean isPage, String tag, String list) {
        this.isPage = isPage;
        this.tag = tag;
        this.list = list;
    }
}
