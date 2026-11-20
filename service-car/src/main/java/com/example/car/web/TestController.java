package com.example.car.web;

import com.example.car.entities.Client;
import com.example.car.services.ClientApi;
import org.springframework.web.bind.annotation.*;

/**
 * Contrôleur de test pour valider l'appel WebClient directement vers SERVICE-CLIENT.
 *
 * @author Mouad Agdouz (https://github.com/agdouz)
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    private final ClientApi clientApi;

    public TestController(ClientApi clientApi) {
        this.clientApi = clientApi;
    }

    @GetMapping("/client/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientApi.findClientById(id);
    }
}
