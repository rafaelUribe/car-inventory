package com.example.cars_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EurekaUrlChecker {

    @Autowired
    private Environment environment;

    @PostConstruct
    public void checkEurekaUrl() {
        String eurekaUrl = environment.getProperty("eureka.client.service-url.defaultZone");
        System.out.println("eureka debug \n\nEureka URL: " + eurekaUrl + "\n\n");
    }
}
