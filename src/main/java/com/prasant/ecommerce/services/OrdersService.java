package com.prasant.ecommerce.services;

import com.prasant.ecommerce.models.Orders;
import com.prasant.ecommerce.repositories.IOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    IOrdersRepository ordersRepository;

    public String createOrders(List<Orders> ordersList) {
        ordersRepository.saveAll(ordersList);
        return "Orders are created!";
    }

    public Orders getOrderById(Integer id) {
        return ordersRepository.findById(id).orElse(null);
    }
}
