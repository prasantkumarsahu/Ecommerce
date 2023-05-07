package com.prasant.ecommerce.services;

import com.prasant.ecommerce.models.Product;
import com.prasant.ecommerce.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepository productRepository;

    public String createProducts(List<Product> productList) {
        productRepository.saveAll(productList);
        return "Products are created!";
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public List<Product> getProductsBasedOnCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }
}
