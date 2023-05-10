package com.prasant.ecommerce.controllers;

import com.prasant.ecommerce.models.Order;
import com.prasant.ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping(value = "/")
    public ResponseEntity<String> createOrders(@RequestBody Order order) {
        String response = orderService.createOrders(order);
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        if (response.equals("Order is created!"))
            status = HttpStatus.CREATED;

        return new ResponseEntity<>(response, status);
    }

    @GetMapping(value = "/{id}")
    public Order getOrderById(@PathVariable Integer id){
        return orderService.getOrdersById(id);
    }
}
