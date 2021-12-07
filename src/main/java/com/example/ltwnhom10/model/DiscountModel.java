/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ltwnhom10.model;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "discount")
public class DiscountModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id",nullable = false)
    private Integer discountId;
    
    @Column(name = "name",nullable = false)
    private String discountName;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "discount_percent")
    private BigDecimal discountPercent;
    
    @OneToMany(mappedBy = "discount",fetch = FetchType.LAZY)
    private List<ProductModel> productList;
    
}
