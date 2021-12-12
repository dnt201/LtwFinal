/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ltwnhom10.dao;

import com.example.ltwnhom10.model.DiscountModel;
import com.example.ltwnhom10.model.ProductModel;
import java.util.List;

public interface ProductDao extends GenericDao<Integer, ProductModel>{
    public ProductModel findByName(String productName);
    public List<ProductModel> findByBrand(Integer brandId);
    public List<ProductModel> findByDiscount(Integer discountId);
}
