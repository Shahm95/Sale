package com.example.sale.dao;

import com.example.sale.model.dto.OrderDTO;
import com.example.sale.model.entity.OrderEntity;
import com.example.sale.repo.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDao {

    private final OrderRepo orderRepo;

    public OrderDao(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public OrderEntity saveOrder(List<OrderDTO> order){

        Double total = 0.0;

        for (OrderDTO o: order) {
            total += o.getProductPrice();

        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setTotal(total);
        return this.orderRepo.save(orderEntity);


    }

    public List<OrderEntity> getAllOrder(){
        return this.orderRepo.findAll();
    }

}
