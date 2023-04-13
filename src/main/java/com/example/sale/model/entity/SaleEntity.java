package com.example.sale.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "sale")
@Entity
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Integer saleId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "order_id")
    private Integer orderId;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "product_id",insertable = false,updatable = false)
    private ProductEntity product;



}
