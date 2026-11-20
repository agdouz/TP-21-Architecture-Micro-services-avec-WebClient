# TP 21 : Architecture Micro-services avec WebClient

**Auteur :** Mouad Agdouz  
**GitHub :** [https://github.com/agdouz](https://github.com/agdouz)  
**Cours :** Architecture Microservices : Conception, Déploiement et Orchestration  
**Lab :** TP 21 (Lab ID: 261)

---

## 📌 Description du Projet

Ce projet implémente une architecture de microservices avec **Spring Boot 3.4.3** et **Java 21**, en utilisant le client non-bloquant et réactif **WebClient** avec équilibrage de charge côté client (**Spring Cloud LoadBalancer**) et le registre de services **Eureka Server**.

### Architecture et Microservices

1. **`eureka-server`** (Port: `8761`) :
   - Annuaire de services Eureka Server avec auto-enregistrement désactivé (`register-with-eureka: false`, `fetch-registry: false`).

2. **`service-client`** (Port: `8081`) :
   - CRUD pour l'entité `Client` (`id`, `nom`, `age`) avec Spring Data JPA et H2/MySQL.
   - Enregistré dans Eureka sous l'identifiant `SERVICE-CLIENT`.
   - Endpoints REST :
     - `GET /api/clients` : Liste complète des clients.
     - `GET /api/clients/{id}` : Consultation d'un client par ID.
     - `POST /api/clients` : Création d'un client.

3. **`service-car`** (Port: `8082`) :
   - CRUD pour l'entité `Car` (`id`, `marque`, `modele`, `clientId`, `@Transient Client client`).
   - Configuration d'un bean `@LoadBalanced WebClient.Builder`.
   - Consommation dynamique de `SERVICE-CLIENT` par son nom de service : `http://SERVICE-CLIENT/api/clients/{id}`.
   - Endpoints REST :
     - `GET /api/cars` : Liste des voitures enrichies avec les objets Client correspondants.
     - `GET /api/cars/{id}` : Récupération d'une voiture avec son propriétaire.
     - `GET /api/test/client/{id}` : Validation de l'appel WebClient direct vers `SERVICE-CLIENT`.

---

## 🛠️ Technologies Utilisées

- **Java 21**
- **Spring Boot 3.4.3**
- **Spring Cloud 2024.0.0**
- **Spring Cloud Netflix Eureka Server / Client**
- **Spring WebFlux (WebClient)**
- **Spring Cloud LoadBalancer**
- **Spring Data JPA & H2 / MySQL**
- **Lombok**
- **Maven**

---

## 🚀 Ordre de Lancement et Tests

1. Lancer **Eureka Server** (`8761`) : [http://localhost:8761](http://localhost:8761)
2. Lancer **Service Client** (`8081`)
3. Lancer **Service Car** (`8082`)
4. Tester :
   - `GET http://localhost:8081/api/clients`
   - `GET http://localhost:8082/api/test/client/1`
   - `GET http://localhost:8082/api/cars`
