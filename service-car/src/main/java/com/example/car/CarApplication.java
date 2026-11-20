package com.example.car;

import com.example.car.entities.Car;
import com.example.car.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Point d'entrée pour le microservice SERVICE-CAR avec WebClient réactif.
 *
 * @author Mouad Agdouz (https://github.com/agdouz)
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(CarRepository repo) {
        return args -> {
            repo.save(new Car(null, "Toyota", "Yaris", 1L, null));
            repo.save(new Car(null, "Renault", "Megane", 2L, null));
            repo.save(new Car(null, "Peugeot", "308", 1L, null));
        };
    }
}
