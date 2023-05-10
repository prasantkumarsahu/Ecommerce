package com.prasant.ecommerce.repositories;

import com.prasant.ecommerce.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends CrudRepository<Order, Integer> {
}
