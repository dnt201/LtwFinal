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
@Table(name = "product")
public class ProductModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "name", nullable = false)
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "release_year")
    private String releaseYear;


    @Column(name = "image", nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private DiscountModel discount;

    @ManyToOne
    @JoinColumn(name = "brand_id",nullable = false)
    private BrandModel brandModel;

    @OneToMany(mappedBy = "productModel",fetch = FetchType.LAZY)
    private List<OrderItemsModel> orderItemsList;


}
