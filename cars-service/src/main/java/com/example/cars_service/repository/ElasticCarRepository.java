package com.example.cars_service.repository;

import com.example.cars_service.model.ElasticCar;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface ElasticCarRepository extends ElasticsearchRepository<ElasticCar, String> {

    Optional<ElasticCar> findByName(String name);

    Optional<ElasticCar> findById(String id);

    List<ElasticCar> findByVersion(String version);

    List<ElasticCar> findByVisible(Boolean visible);

    ElasticCar save(ElasticCar elasticCar);
}
