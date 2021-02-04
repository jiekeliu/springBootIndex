package com.jiekeliu.mapper;
import com.jiekeliu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: jiekeliu
 * @Date: 2021/2/4 0004 11:14
 * @Description:
 */
@Mapper
@Repository
public interface UserMapper {
    List<User> getAll();

    //   分页查询数据
    List<User> getDataAse(int start, int pageSize);

    //    查询所有数据(倒序)
    List<User> getDataDesc(int start, int pageSize);

    //    添加
    int addUser(User user);

    //    删除
    int delUserById(int uid);

    //    修改
    int upUser(User user);

    //    根据id查询
    User getOneUserById(int uid);

    //    根据用户名查询
    User getOneUserByName(String username);

    //    查询数据总量
    int getUserCount();

}
