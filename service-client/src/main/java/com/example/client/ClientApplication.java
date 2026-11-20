package com.example.client;

import com.example.client.entities.Client;
import com.example.client.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Point d'entrée pour le microservice SERVICE-CLIENT.
 *
 * @author Mouad Agdouz (https://github.com/agdouz)
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new Client(null, "Salma", 22.0f));
            clientRepository.save(new Client(null, "Amine", 25.0f));
            clientRepository.save(new Client(null, "Sara", 30.0f));
        };
    }
}
