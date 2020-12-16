package com.jiekeliu.service;

import com.jiekeliu.mapper.CatalogueMapper;
import com.jiekeliu.pojo.Catalogue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Auther: jiekeliu
 * @Date: 2020/12/6 0006 19:35
 * @Description:
 */
@Service
public class CatalogueServiceImpl implements CatalogueService {
    @Autowired
    CatalogueMapper catalogueMapper;

    @Override
    public List<Catalogue> getAll() {
        List<Catalogue> all_catalogue = catalogueMapper.getAll();
        System.out.println("-----------------------catalogue getAll--------------");
        HashMap<String, Object> responseInfo = new HashMap<>();
        responseInfo.put("code",20000);
        responseInfo.put("data",all_catalogue);

        return all_catalogue;
    }

    @Override
    public int addCatalogue(Catalogue catalogue) {
        int add_res = catalogueMapper.addCatalogue(catalogue);
        System.out.println("-----------------------catalogue addCatalogue--------------");
        return add_res;
    }

    @Override
    public int delCatalogueById(int cid) {

        int res_del = catalogueMapper.delCatalogueById(cid);
        System.out.println("-----------------------catalogue delCatalogueById--------------");
        return res_del;
    }

    @Override
    public int upCatalogue(Catalogue catalogue) {
        int res_up = catalogueMapper.upCatalogue(catalogue);
        System.out.println("-----------------------catalogue upCatalogue--------------");
        return res_up;
    }

    @Override
    public Catalogue getOneCatalogueById(int cid) {
        Catalogue oneCatalogueById = catalogueMapper.getOneCatalogueById(cid);
        System.out.println("-----------------------catalogue getOneCatalogueById--------------");
        return oneCatalogueById;
    }
}
