package com.prasant.ecommerce.controllers;

import com.prasant.ecommerce.models.Product;
import com.prasant.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping(value = "/")
    public String addProducts(@RequestBody List<Product> productList) {
        return productService.createProducts(productList);
    }

    @GetMapping(value = "/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/category/")
    public List<Product> getProductsBasedOnCategory(@RequestParam String category) {
        return productService.getProductsBasedOnCategory(category);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProductById(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }
}
