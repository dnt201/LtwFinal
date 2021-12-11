/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ltwnhom10.dao;

import com.example.ltwnhom10.model.OrderDetailsModel;

import java.util.List;

/**
 *
 * @author asus
 */
public interface OrderDetailsDao extends GenericDao<Integer, OrderDetailsModel>{
    Integer saveReturnId(OrderDetailsModel orderDetailModel);
    List<OrderDetailsModel> findByUserId(Integer userId);
}
