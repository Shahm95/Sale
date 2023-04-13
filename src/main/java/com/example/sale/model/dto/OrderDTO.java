package com.example.sale.model.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class OrderDTO {

    private Integer productId;
    private Double productPrice;
}
