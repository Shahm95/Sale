package com.example.sale.dao;

import com.example.sale.model.dto.OrderDTO;
import com.example.sale.model.entity.OrderEntity;
import com.example.sale.model.entity.ProductEntity;
import com.example.sale.model.entity.SaleEntity;
import com.example.sale.repo.ProductRepo;
import com.example.sale.repo.SaleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleDao {
    private final SaleRepo saleRepo;
    private final OrderDao orderDao;


    public SaleDao(SaleRepo saleRepo, OrderDao orderDao, ProductDao productDao, ProductRepo productRepo) {
        this.saleRepo = saleRepo;
        this.orderDao = orderDao;

    }


    public OrderEntity saveSale(List<OrderDTO> order){

        if (order.size() == 0){
            return null;
        }
        OrderEntity ord = this.orderDao.saveOrder(order);
        order.forEach(o -> {
            SaleEntity saleEntity = new SaleEntity();
            saleEntity.setOrderId(ord.getOrderId());
            saleEntity.setProductId(o.getProductId());
            this.saleRepo.save(saleEntity);
        });

        return ord;

    }

    public List<SaleEntity> getAllSale(){
        return this.saleRepo.findAll();
    }

}
