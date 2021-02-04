package com.jiekeliu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: jiekeliu
 * @Date: 2021/2/4 0004 11:07
 * @Description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String uid;
    private String username; //用户名
    private String password; //密码
    private String roles; //角色
    private String introduction; //介绍
    private String avatar; //外联
}
