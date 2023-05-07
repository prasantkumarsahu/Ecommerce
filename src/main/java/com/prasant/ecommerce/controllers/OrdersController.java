package com.prasant.ecommerce.controllers;

import com.prasant.ecommerce.models.Orders;
import com.prasant.ecommerce.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @PostMapping(value = "/")
    public String createOrders(@RequestBody List<Orders> ordersList) {
        return ordersService.createOrders(ordersList);
    }

    @GetMapping(value = "/{id}")
    public Orders getOrderById(@PathVariable Integer id){
        return ordersService.getOrderById(id);
    }
}
