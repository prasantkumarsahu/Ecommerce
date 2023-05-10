package com.prasant.ecommerce.repositories;

import com.prasant.ecommerce.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends CrudRepository<Product, Integer> {

    @Query(value = "select * from products where category = :category", nativeQuery = true)
    List<Product> getProductsBasedOnCategory(String category);
}
