package com.prasant.ecommerce.services;

import com.prasant.ecommerce.models.Order;
import com.prasant.ecommerce.repositories.IAddressRepository;
import com.prasant.ecommerce.repositories.IOrderRepository;
import com.prasant.ecommerce.repositories.IProductRepository;
import com.prasant.ecommerce.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class OrderService {
    @Autowired
    IOrderRepository ordersRepository;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IAddressRepository addressRepository;

    @Autowired
    IProductRepository productRepository;

    public String createOrders(Order order) {
        Integer userId = order.getUser().getId();
        Integer addressId = order.getAddress().getId();
        List<Integer> productsIdsList = new ArrayList<>();
        order.getProductList().forEach(
                product -> productsIdsList.add(product.getId())
        );

        boolean userIsPresent = userRepository.existsById(userId);
        if(!userIsPresent)
            return "User of Id : " + userId + " is not present!";

        boolean addressIsPresent = addressRepository.existsById(addressId);
        if (!addressIsPresent)
            return "Address of Id : " + addressId + " is not present!";

        AtomicBoolean productsArePresent = new AtomicBoolean(true);
        List<Integer> productNotPresentList = new ArrayList<>();
        productsIdsList.forEach(
                productId -> {
                    if (!productRepository.existsById(productId)){
                        productsArePresent.set(false);
                        productNotPresentList.add(productId);
                    }
                }
        );
        if (!productsArePresent.get())
            return "Products of these Ids are not present : " +productNotPresentList;

        order.setProductsQuantity(order.getProductList().size());
        ordersRepository.save(order);
        return "Order is created!";
    }

    public Order getOrdersById(Integer id){
        return ordersRepository.findById(id).orElse(null);
    }
}
