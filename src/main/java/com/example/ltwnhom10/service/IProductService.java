package com.example.ltwnhom10.service;

import com.example.ltwnhom10.model.ProductModel;
import com.example.ltwnhom10.paging.Pageable;

import java.util.List;

public interface IProductService {
    void save(ProductModel productModel);
    void update(ProductModel productModel);
    ProductModel findByID(Integer productId);
    Integer delete(List<Integer> list);
    List<ProductModel> findAllPaging(Pageable pageable);
    List<ProductModel> findAll();
    Integer getTotalItem();
    List<ProductModel> findByBrand(Integer brandId);
}
