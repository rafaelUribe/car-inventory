package com.example.cars_service.controller;

import com.example.cars_service.model.ElasticCar;
import com.example.cars_service.service.ElasticCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ElasticCarController {

    private final ElasticCarService service;

    @GetMapping("/elastic/products/{productId}")
    public ResponseEntity<ElasticCar> getProductById(@PathVariable String productId) {
        ElasticCar product = service.getCarById(productId);

        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/elastic/products")
    public ResponseEntity<List<ElasticCar>> getProducts() {
        List<ElasticCar> products = service.getAvailableCars();

        if (products != null) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/elastic/products/match/{value}")
    public ResponseEntity<ElasticCar> getProductByName(@PathVariable String value) {
        ElasticCar product = service.getCarByName(value);

        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}