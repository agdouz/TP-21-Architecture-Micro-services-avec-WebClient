package com.example.car.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modèle Client distant dans SERVICE-CAR.
 *
 * @author Mouad Agdouz (https://github.com/agdouz)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Long id;
    private String nom;
    private Float age;
}
