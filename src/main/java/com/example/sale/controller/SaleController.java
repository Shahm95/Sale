package com.example.sale.controller;

import com.example.sale.dao.OrderDao;
import com.example.sale.dao.SaleDao;
import com.example.sale.model.dto.OrderDTO;
import com.example.sale.model.entity.OrderEntity;
import com.example.sale.model.entity.SaleEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping(path = "/sales")
@RestController
public class SaleController {

    private final SaleDao saleDao;

    public SaleController(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    @GetMapping(path = "/get-sales")
    public List<SaleEntity> getAllSale(){
        return this.saleDao.getAllSale();
    }


}
