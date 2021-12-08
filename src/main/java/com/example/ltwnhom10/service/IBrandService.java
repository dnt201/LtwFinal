package com.example.ltwnhom10.service;

import com.example.ltwnhom10.model.BrandModel;

import java.util.List;

public interface IBrandService {
    void save(BrandModel brandModel);
    void update(BrandModel brandModel);
    BrandModel findById(Integer brandId);
    Integer delete(List<Integer> list);
    List<BrandModel> findAll();
}
