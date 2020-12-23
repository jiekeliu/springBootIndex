package com.jiekeliu.service;

import com.jiekeliu.mapper.MateMapper;
import com.jiekeliu.pojo.Mate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/23 0023 15:19
 * @Description:
 */

@Service
public class MateServiceImpl implements MateService{

    @Autowired
    MateMapper mateMapper ;

    @Override
    public Map geDataByPage(int page, int pageSize, boolean sort) {
        HashMap<String, Object> responseInfo = new HashMap<>();
        int mateCount = mateMapper.getMateCount();
        boolean expage = (mateCount/pageSize+1)>=page?true:false;
        if (expage){
            int start = (page-1)*pageSize;
            List<Mate> data;
            if (sort){
                data = mateMapper.getDataDesc(start, pageSize);
            }else {
                data = mateMapper.getDataAse(start, pageSize);
            }
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","请求成功");
            responseInfo.put("page",page);
            responseInfo.put("pageSize",data.size());
            responseInfo.put("total",mateCount);
            responseInfo.put("data",data);
            return responseInfo;
        }else {
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","请求失败，查询的数据超出范围");
            responseInfo.put("page",page);
            responseInfo.put("pageSize",0);
            responseInfo.put("total",0);
            return responseInfo;
        }

    }

    @Override
    public Map addMate(Mate mate) {
        HashMap<String, Object> responseInfo = new HashMap<>();
        //输入判断
        if(mate.getTitle() == null || mate.getTitle().length() == 0){
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","添加失败，标题不能为空");
            return responseInfo;
        }

        if(mate.getUrl() == null || mate.getUrl().length() == 0){
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","添加失败，连接不能为空");
            return responseInfo;
        }

        if(mate.getSubtitle() == null || mate.getSubtitle().length() == 0){
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","添加失败，副标题不能为空");
            return responseInfo;
        }

        if(mate.getDescription() == null || mate.getDescription().length() == 0){
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","添加失败，描述不能为空");
            return responseInfo;
        }


        if(mate.getImage()== null || mate.getImage().length() == 0){
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","添加失败，图片地址不能为空");
            return responseInfo;
        }

        int pid = mate.getPid();
        if(pid < 0 ){
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","添加失败，父id 错误");
            return responseInfo;
        }

        int add_res = mateMapper.addMate(mate);
        if (add_res == 1){
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","添加成功");
            return responseInfo;
        }else {
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","添加失败");
            return responseInfo;
        }
    }

    @Override
    public Map delMateById(int mid) {
        HashMap<String, Object> responseInfo = new HashMap<>();
        if(mid <=0 ){
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","删除失败，对象序号错误");
            return responseInfo;
        }

        int del_res = mateMapper.delMateById(mid);

        if (del_res == 1){
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","删除成功");
            return responseInfo;
        }else {
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","删除失败");
            return responseInfo;
        }
    }

    @Override
    public Map upMate(Mate mate) {

        HashMap<String, Object> responseInfo = new HashMap<>();
        //输入判断
        if(mate.getTitle() == null || mate.getTitle().length() == 0){
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","修改失败，标题不能为空");
            return responseInfo;
        }

        if(mate.getUrl() == null || mate.getUrl().length() == 0){
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","修改失败，连接不能为空");
            return responseInfo;
        }

        if(mate.getSubtitle() == null || mate.getSubtitle().length() == 0){
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","修改失败，副标题不能为空");
            return responseInfo;
        }

        if(mate.getDescription() == null || mate.getDescription().length() == 0){
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","修改失败，描述不能为空");
            return responseInfo;
        }


        if(mate.getImage()== null || mate.getImage().length() == 0){
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","修改失败，图片地址不能为空");
            return responseInfo;
        }

        int pid = mate.getPid();
        if(pid < 0 ){
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","修改失败，父id 错误");
            return responseInfo;
        }

        int mid = mate.getMid();
        if(mid <= 0 ){
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","修改失败，序号错误");
            return responseInfo;
        }

        int up_res = mateMapper.upMate(mate);
        if (up_res == 1){
            responseInfo.put("code",20000);
            responseInfo.put("status","ok");
            responseInfo.put("info","修改成功");
            return responseInfo;
        }else {
            responseInfo.put("code",20000);
            responseInfo.put("status","error");
            responseInfo.put("info","修改失败");
            return responseInfo;
        }
    }

    @Override
    public Map getOneMateById(int mid) {
        return null;
    }
}
