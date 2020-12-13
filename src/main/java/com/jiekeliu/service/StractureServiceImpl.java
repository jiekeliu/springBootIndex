package com.jiekeliu.service;

import com.alibaba.fastjson.JSONObject;
import com.jiekeliu.mapper.StractureMapper;
import com.jiekeliu.pojo.Stracture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/6 0006 19:34
 * @Description:
 */
@Service
public class StractureServiceImpl implements StractureService{

    @Autowired
    StractureMapper stractureMapper;

    @Override
    public List<Stracture> getAll() {
        List<Stracture> all_stracture = stractureMapper.getAll();
        System.out.println("+++++++++++++service++++++++++++++++++");

//        List<Stracture> list_stracture = new ArrayList<Stracture>();
//        for (Stracture s:all_stracture) {
//            JSONObject list = JSONObject.parseObject(s.getList());
//            list_stracture.add(s);
//        }

        return all_stracture;
    }

    @Override
    public int addStracture(Stracture stracture) {
        int add_result = stractureMapper.addStracture(stracture);
        System.out.println("++++++++++++addreurn:    "+add_result);
        return add_result;
    }

    @Override
    public int delStractureById(int sid) {
        int del_res = stractureMapper.delStractureById(sid);
        System.out.println("++++++++++++el_res:    "+del_res);
        return del_res;
    }

    @Override
    public int upStracture(Stracture stracture) {
        int up_res = stractureMapper.upStracture(stracture);
        System.out.println("++++++++++++up_res:    "+up_res);
        return up_res;
    }

    @Override
    public Stracture getOneStractureById(int sid) {
        Stracture oneStractureById = stractureMapper.getOneStractureById(sid);
        System.out.println("++++++++++++oneStractureById:    "+oneStractureById);
        return oneStractureById;
    }
}

