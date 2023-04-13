package com.example.sale.controller;

import com.example.sale.dao.OrderDao;
import com.example.sale.dao.SaleDao;
import com.example.sale.model.dto.OrderDTO;
import com.example.sale.model.entity.OrderEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/order")
@RestController
public class OrderController {

    private final OrderDao orderDao;
    private final SaleDao saleDao;

    public OrderController(OrderDao orderDao, SaleDao saleDao) {
        this.orderDao = orderDao;
        this.saleDao = saleDao;
    }

    @PostMapping(path = "/save-order")
    public OrderEntity saveOrder(@RequestBody List<OrderDTO> order){
        return this.saleDao.saveSale(order);
    }
    @GetMapping(path = "/all-order")
    public List<OrderEntity> getAllOrder(){
        return this.orderDao.getAllOrder();
    }
}
