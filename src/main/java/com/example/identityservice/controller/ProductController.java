package com.example.identityservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.ok(List.of(
                Map.of("id", 1, "name", "Laptop", "price", 1500),
                Map.of("id", 2, "name", "Phone", "price", 800)
        ));
    }
}
