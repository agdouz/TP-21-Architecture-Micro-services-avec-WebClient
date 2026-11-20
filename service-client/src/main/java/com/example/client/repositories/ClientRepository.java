package com.example.client.repositories;

import com.example.client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA pour les clients.
 *
 * @author Mouad Agdouz (https://github.com/agdouz)
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
