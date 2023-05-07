package com.prasant.ecommerce.repositories;

import com.prasant.ecommerce.models.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersRepository extends CrudRepository<Orders, Integer> {
}
