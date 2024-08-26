package com.example.cars_service.service;

import com.example.cars_service.model.CreateCarRequest;
import com.example.cars_service.model.ElasticCar;
import java.util.List;

public interface ElasticCarService {

    ElasticCar createCar(CreateCarRequest request);

    ElasticCar getCarById(String carId);

    ElasticCar getCarByName(String carName);

    List<ElasticCar> getCarsByVersion(String version);

    List<ElasticCar> searchByModel(String model);

    List<ElasticCar> searchByName(String carName);

    List<ElasticCar> getAvailableCars();

    List<ElasticCar> searchByDescription(String value);
}
