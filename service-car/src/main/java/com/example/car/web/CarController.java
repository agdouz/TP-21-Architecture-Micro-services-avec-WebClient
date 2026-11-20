package com.example.car.web;

import com.example.car.entities.Car;
import com.example.car.repositories.CarRepository;
import com.example.car.services.ClientApi;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des voitures avec enrichissement Client.
 *
 * @author Mouad Agdouz (https://github.com/agdouz)
 */
@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarRepository repo;
    private final ClientApi clientApi;

    public CarController(CarRepository repo, ClientApi clientApi) {
        this.repo = repo;
        this.clientApi = clientApi;
    }

    @GetMapping
    public List<Car> findAll() {
        List<Car> cars = repo.findAll();
        for (Car c : cars) {
            try {
                c.setClient(clientApi.findClientById(c.getClientId()));
            } catch (Exception ignored) {
            }
        }
        return cars;
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable Long id) {
        Car c = repo.findById(id).orElseThrow(() -> new RuntimeException("Car introuvable avec l'id: " + id));
        try {
            c.setClient(clientApi.findClientById(c.getClientId()));
        } catch (Exception ignored) {
        }
        return c;
    }

    @PostMapping
    public Car save(@RequestBody Car car) {
        return repo.save(car);
    }
}
