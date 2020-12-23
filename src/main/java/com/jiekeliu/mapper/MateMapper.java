package com.jiekeliu.mapper;

import com.jiekeliu.pojo.Mate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/23 0023 15:09
 * @Description:
 */

@Mapper
@Repository
public interface MateMapper {

    //   分页查询数据
    List<Mate> getDataAse(int start, int pageSize);

    //    查询所有数据(倒序)
    List<Mate> getDataDesc(int start, int pageSize);

    //    添加
    int addMate(Mate mate);

    //    删除
    int delMateById(int mid);

    //    修改
    int upMate(Mate mate);

    //    根据id查询Catalogue
    Mate getOneMateById(int mid);

    //    查询数据总量
    int getMateCount();

}
