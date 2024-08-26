package com.example.cars_service.service;

import com.example.cars_service.model.CarVersion;
import com.example.cars_service.model.CreateCarRequest;
import com.example.cars_service.repository.CarVersionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataSyncService {

    private final CarVersionRepository carVersionRepository;
    private final ElasticCarService elasticCarService;

    public DataSyncService(CarVersionRepository carVersionRepository, ElasticCarService elasticCarService) {
        this.carVersionRepository = carVersionRepository;
        this.elasticCarService = elasticCarService;
    }

    @PostConstruct
    public void syncDataToElasticsearch() {
        List<CarVersion> carVersions = carVersionRepository.findAll();

        for (CarVersion carVersion : carVersions) {
            CreateCarRequest request = CreateCarRequest.builder()
                    .name(carVersion.getFullName())
                    .brand(carVersion.getCarModel().getBrand().getName())
                    .model(carVersion.getCarModel().getName())
                    .version(carVersion.getVersionName())
                    .visible(true)
                    .build();

            elasticCarService.createCar(request);
        }
    }
}