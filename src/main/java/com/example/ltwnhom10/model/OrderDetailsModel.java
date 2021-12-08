package com.example.ltwnhom10.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetailsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer order_id;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "create_at", nullable = false)
    private Timestamp createAt;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UsersModel usersModel;

    @OneToMany(mappedBy = "orderDetails",fetch = FetchType.LAZY)
    private List<OrderItemsModel> orderItemsList;

}
