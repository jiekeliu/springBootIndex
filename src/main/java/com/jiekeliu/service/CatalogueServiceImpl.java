package com.jiekeliu.service;

import com.jiekeliu.mapper.CatalogueMapper;
import com.jiekeliu.pojo.Catalogue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        System.out.println("-----------------------catalogue--------------");
        return all_catalogue;
    }

    @Override
    public int addCatalogue(Catalogue catalogue) {
        return 0;
    }

    @Override
    public int delCatalogueById(int cid) {
        return 0;
    }

    @Override
    public int upCatalogue(Catalogue catalogue) {
        return 0;
    }

    @Override
    public Catalogue getOneCatalogueById(int cid) {
        return null;
    }
}
