package com.jiekeliu.mapper;

import com.jiekeliu.pojo.Stracture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/6 0006 19:14
 * @Description:
 */

@Mapper
@Repository
public interface StractureMapper {
    //    查询所有数据
    List<Stracture> getAll();

    //    添加
    int addStracture(Stracture stracture);

    //    删除
    int delStractureById(int sid);

    //    修改
    int upStracture(Stracture stracture);

    //    根据id查询user
    Stracture getOneStractureById(int sid);
}
