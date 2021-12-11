package com.example.ltwnhom10.service;

import com.example.ltwnhom10.model.OrderDetailsModel;

import java.util.List;

public interface IOrderDetailsService {
    public Integer save(OrderDetailsModel orderDetailsModel);
    public void update(OrderDetailsModel orderDetailsModel);
    OrderDetailsModel findById(Integer orderDetailId);
    List<OrderDetailsModel> findByUserId(Integer userId);
    public Integer delete(List<Integer> list);
    public List<OrderDetailsModel> findAll();
}
