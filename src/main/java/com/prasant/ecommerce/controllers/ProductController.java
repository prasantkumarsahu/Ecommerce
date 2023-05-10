package com.prasant.ecommerce.controllers;

import com.prasant.ecommerce.models.Product;
import com.prasant.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping(value = "/")
    public ResponseEntity<String> addProducts(@RequestBody List<Product> productList) {
        String response = productService.createProducts(productList);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productList = productService.getAllProducts();
        HttpStatus status = productList.size() != 0 ? HttpStatus.FOUND : HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(productList, status);
    }

    @GetMapping(value = "/category/{category}")
    public ResponseEntity<List<Product>> getProductsBasedOnCategory(@PathVariable String category) {
        List<Product> productList = productService.getProductsBasedOnCategory(category);
        HttpStatus status = productList.size() != 0 ? HttpStatus.FOUND : HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(productList, status);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteProductById(@PathVariable Integer id) {
        return productService.deleteProductById(id);
    }
}
