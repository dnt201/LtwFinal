package com.example.ltwnhom10.service.impl;

import com.example.ltwnhom10.dao.OrderDetailsDao;
import com.example.ltwnhom10.dao.impl.OrderDetailsDaoImpl;
import com.example.ltwnhom10.model.OrderDetailsModel;
import com.example.ltwnhom10.service.IOrderDetailsService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public class OrderDetailsService implements IOrderDetailsService {
    @Inject
    private OrderDetailsDao orderDetailsDao;
    public OrderDetailsService() {orderDetailsDao = new OrderDetailsDaoImpl(); }

    @Override
    public Integer save(OrderDetailsModel orderDetailModel) {
        Timestamp ts = Timestamp.from(Instant.now());
        orderDetailModel.setCreateAt(ts);
        return orderDetailsDao.saveReturnId(orderDetailModel);
    }

    @Override
    public void update(OrderDetailsModel orderDetailModel) {
        orderDetailsDao.update(orderDetailModel);
    }

    @Override
    public OrderDetailsModel findById(Integer orderDetailId) {
        return orderDetailsDao.findById(orderDetailId);
    }

    @Override
    public Integer delete(List<Integer> ids) {
        return orderDetailsDao.delete(ids);
    }

    @Override
    public List<OrderDetailsModel> findAll() {
        return orderDetailsDao.findAll();
    }

}
