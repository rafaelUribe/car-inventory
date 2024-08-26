package com.example.cars_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCarRequest {

    private String name;
    private String version;
    private String model;
    private String brand;
    private Boolean visible;
}
