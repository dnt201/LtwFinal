package com.example.ltwnhom10.service;

import com.example.ltwnhom10.model.BrandModel;
import com.example.ltwnhom10.model.DiscountModel;
import com.example.ltwnhom10.service.impl.DiscountService;

import java.util.List;

public interface IDiscountService {
    void save(DiscountModel discountModel);
    void update(DiscountModel discountModel);
    void deleteOne(DiscountModel discountModel);
    DiscountModel findByName(String discountName);
    DiscountModel findByID(Integer discountId);
    Integer delete(List<Integer> list);
    List<DiscountModel> findAll();
}
