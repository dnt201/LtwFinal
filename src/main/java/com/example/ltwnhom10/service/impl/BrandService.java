package com.example.ltwnhom10.service.impl;

import com.example.ltwnhom10.dao.BrandDao;
import com.example.ltwnhom10.dao.impl.BrandDaoImpl;
import com.example.ltwnhom10.model.BrandModel;
import com.example.ltwnhom10.service.IBrandService;

import javax.inject.Inject;
import java.util.List;

public class BrandService implements IBrandService {
    @Inject
    private BrandDao brandDao;

    public BrandService() { brandDao = new BrandDaoImpl(); }

    @Override
    public void save(BrandModel brandModel) { brandDao.save(brandModel); }

    @Override
    public void deleteOne(BrandModel brandModel) { brandDao.deleteOne(brandModel); }

    @Override
    public void update(BrandModel brandModel) {brandDao.update(brandModel); }

    @Override
    public BrandModel findById(Integer brandId){
        BrandModel brand = brandDao.findById(brandId);
        return brand;
    }

    @Override
    public BrandModel findByName(String brandName){
        return brandDao.findByName(brandName);
    }

    @Override
    public Integer delete(List<Integer> list) { return brandDao.delete(list); }

    @Override
    public List<BrandModel> findAll() { return brandDao.findAll(); }
}
