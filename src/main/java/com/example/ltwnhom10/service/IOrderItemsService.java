package com.example.ltwnhom10.service;

import com.example.ltwnhom10.model.OrderItemsModel;

import java.util.List;

public interface IOrderItemsService {
    public void save(OrderItemsModel orderItemModel);
    public void update(OrderItemsModel orderItemModel);
    OrderItemsModel findByID(Integer orderItemId);
    public Integer delete(List<Integer> ids);
    public List<OrderItemsModel> findAll();
    public List<OrderItemsModel> findByOrderDetailId(Integer id);
}
