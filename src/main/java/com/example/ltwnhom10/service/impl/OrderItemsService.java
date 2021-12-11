package com.example.ltwnhom10.service.impl;

import com.example.ltwnhom10.dao.OrderItemsDao;
import com.example.ltwnhom10.dao.impl.OrderItemsDaoImpl;
import com.example.ltwnhom10.model.OrderItemsModel;
import com.example.ltwnhom10.service.IOrderItemsService;

import javax.inject.Inject;
import java.util.List;

public class OrderItemsService implements IOrderItemsService {
    @Inject
    private OrderItemsDao orderItemsDAO;

    public OrderItemsService() {
        orderItemsDAO = new OrderItemsDaoImpl();
    }

    @Override
    public void save(OrderItemsModel orderItemModel) {
        orderItemsDAO.save(orderItemModel);
    }

    @Override
    public void update(OrderItemsModel orderItemModel) {
        orderItemsDAO.update(orderItemModel);
    }

    @Override
    public OrderItemsModel findByID(Integer orderItemId) {
        return orderItemsDAO.findById(orderItemId);
    }

    @Override
    public Integer delete(List<Integer> ids) {
        return orderItemsDAO.delete(ids);
    }

    @Override
    public List<OrderItemsModel> findAll() {
        return orderItemsDAO.findAll();
    }

    @Override
    public List<OrderItemsModel> findByProductId(Integer id) {
        return orderItemsDAO.findByProductId(id);
    }
}
