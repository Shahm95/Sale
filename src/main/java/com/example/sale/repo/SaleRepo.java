package com.example.sale.repo;

import com.example.sale.model.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepo extends JpaRepository<SaleEntity, Integer> {
}
