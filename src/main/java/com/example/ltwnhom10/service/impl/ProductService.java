package com.example.ltwnhom10.service.impl;

import com.example.ltwnhom10.dao.ProductDao;
import com.example.ltwnhom10.dao.impl.ProductDaoImpl;
import com.example.ltwnhom10.model.ProductModel;
import com.example.ltwnhom10.paging.Pageable;
import com.example.ltwnhom10.service.IProductService;

import javax.inject.Inject;
import java.util.List;

public class ProductService implements IProductService {
    @Inject
    private ProductDao productDao;

    public ProductService() { productDao = new ProductDaoImpl(); }

    @Override
    public void save(ProductModel productModel) { productDao.save(productModel); }

    @Override
    public void update(ProductModel productModel) { productDao.update(productModel); }

    @Override
    public ProductModel findByID(Integer productId){
        ProductModel productModel = productDao.findById(productId);
        return productModel;
    }

    @Override
    public Integer delete(List<Integer> list) { return  productDao.delete(list); }

    @Override
    public List<ProductModel> findAll() { return  productDao.findAll(); }

    @Override
    public List<ProductModel> findAllPaging(Pageable pageable) { return productDao.findAllPaging(pageable); }

    @Override
    public Integer getTotalItem() {
        return productDao.findAll().size();
    }

    @Override
    public List<ProductModel> findByBrand(Integer brandId) {
        return productDao.findByBrand(brandId);
    }
}
