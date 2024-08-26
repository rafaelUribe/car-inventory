package com.example.cars_service.controller;

import com.example.cars_service.model.ElasticCar;
import com.example.cars_service.service.ElasticCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/elastic")
public class ElasticCarController {

    private final ElasticCarService service;

    @GetMapping("/{car}")
    public ResponseEntity<ElasticCar> getProductById(@PathVariable String productId) {
        ElasticCar product = service.getCarById(productId);

        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cars")
    public ResponseEntity<List<ElasticCar>> getProducts() {
        List<ElasticCar> products = service.getAvailableCars();

        if (products != null) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cars/search/as-you-type/{value}")
    public ResponseEntity<List<ElasticCar>> searchByName(@PathVariable String value) {
        List<ElasticCar> cars = service.searchByName(value);

        if (cars != null && !cars.isEmpty()) {
            return ResponseEntity.ok(cars);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cars/search/full-text/{value}")
    public ResponseEntity<List<ElasticCar>> searchByDescription(@PathVariable String value) {
        List<ElasticCar> cars = service.searchByDescription(value);

        if (cars != null && !cars.isEmpty()) {
            return ResponseEntity.ok(cars);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}