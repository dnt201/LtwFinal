/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ltwnhom10.dao;

import com.example.ltwnhom10.model.BrandModel;
import com.example.ltwnhom10.model.DiscountModel;

/**
 *
 * @author asus
 */
public interface DiscountDao extends GenericDao<Integer, DiscountModel>{
    DiscountModel findByName(String discountName);
}
