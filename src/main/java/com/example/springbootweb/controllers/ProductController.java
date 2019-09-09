package com.example.springbootweb.controllers;

import com.example.springbootweb.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    // generic wrapper for all http responses - ResponseEntity (header, status, bodyResponse)

    @GetMapping("/")
    public ResponseEntity<?> avaiable() {
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @GetMapping("/default")
    public ProductDTO defaultProduct(ProductDTO product) {
        product.setId(10L);
        product.setName("Laptop");
        product.setCode("92");
        product.setDescription("Gaming Laptop");
        product.setPrice(1000.1);
        return product;
    }

}
