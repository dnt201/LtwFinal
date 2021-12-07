package com.example.ltwnhom10.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "brand")
public class BrandModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id",nullable = false)
    private Integer brand_id;

    @Column(name = "brand_name",nullable = false)
    private String brand_name;

    @OneToMany(mappedBy = "brandModel",fetch = FetchType.LAZY)
    private List<ProductModel> productList;


}
