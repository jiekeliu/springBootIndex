package com.jiekeliu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/6 0006 18:22
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalogue {
    private int cid;
    private String cname;
    private String curl;
    private int pid;
}
