package com.example.sale.repo;

import com.example.sale.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

    ProductEntity findByBarcode(String barcode);
}
