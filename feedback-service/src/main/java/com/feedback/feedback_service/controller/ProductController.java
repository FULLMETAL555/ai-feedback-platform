package com.feedback.feedback_service.controller;

import com.feedback.feedback_service.model.Product;
import com.feedback.feedback_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addproducts")
    public ResponseEntity<Product> createProduct(@RequestHeader("X-API-KEY") String apiKey, @RequestBody Product product){
        return  ResponseEntity.ok(productService.addProduct(apiKey,product));

    }
}
