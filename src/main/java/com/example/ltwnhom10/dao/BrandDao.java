/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ltwnhom10.dao;

import com.example.ltwnhom10.model.BrandModel;

/**
 *
 * @author asus
 */
public interface BrandDao extends GenericDao<Integer, BrandModel>{
    BrandModel findByName(String brandName);
}
