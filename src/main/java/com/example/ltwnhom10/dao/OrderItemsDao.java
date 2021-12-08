package com.example.ltwnhom10.dao;

import com.example.ltwnhom10.model.OrderItemsModel;
import java.util.List;

public interface OrderItemsDao extends GenericDao<Integer, OrderItemsModel>{
    List<OrderItemsModel> findByOrderDetailId(Integer id);
}
