# Rapport Backend : Application de Gestion des Employés

## Introduction
Ce document fournit une vue d'ensemble de l'implémentation du backend pour l'application de gestion des employés. Le backend est développé avec Spring Boot et intègre diverses technologies telles que MySQL, JPA, Lombok et Spring Security pour offrir une API REST sécurisée et efficace. Ce backend constitue la base de l'application full-stack, permettant la gestion des employés via des opérations CRUD.

## Technologies Utilisées
- **Spring Boot 3** : Un framework pour développer des applications Java.
- **MySQL** : Un système de gestion de bases de données relationnelles pour le stockage des données.
- **Spring Data JPA** : Simplifie les interactions avec la base de données grâce à JPA.
- **Lombok** : Réduit le code standard dans les classes Java.
- **Spring Web** : Fournit des outils pour construire des API RESTful.
- **Spring Security** : Assure un accès sécurisé à l'API via l'authentification JWT.
- **Jakarta Validation** : Valide les entrées utilisateur pour garantir l'intégrité des données.

## JPA et Configuration des Entités
L'entité `Employee` est au cœur de l'application. Elle est mappée à la base de données à l'aide des annotations JPA. L'entité comprend les champs suivants :
- `id` : Identifiant unique pour chaque employé.
- `firstName` : Prénom de l'employé.
- `lastName` : Nom de famille de l'employé.
- `email` : Adresse e-mail de l'employé.
- `salary` : Salaire de l'employé.

Les annotations Lombok telles que `@Data` et `@NoArgsConstructor` sont utilisées pour réduire le code standard.

## Couche Service
La couche service contient la logique métier de l'application. L'interface `EmployeeService` définit les opérations, et la classe `EmployeeServiceImpl` fournit l'implémentation. Cette couche interagit avec le repository pour effectuer les opérations CRUD.

## Couche Repository
La couche repository utilise Spring Data JPA pour interagir avec la base de données MySQL. L'interface `EmployeeRepository` étend `JpaRepository`, offrant des méthodes intégrées pour les opérations sur la base de données.

## Contrôleurs REST
Les contrôleurs REST gèrent les requêtes et réponses HTTP. Le contrôleur `EmployeeController` fournit des endpoints pour :
- **GET** : Récupérer les détails des employés.
- **POST** : Ajouter un nouvel employé.
- **PUT** : Mettre à jour un employé existant.
- **DELETE** : Supprimer un employé.

## Spring Security
Spring Security est configuré pour sécuriser les endpoints de l'API. JWT (JSON Web Token) est utilisé pour l'authentification. La classe `SecurityConfig` définit les règles de sécurité, et la classe `JwtUtil` gère la génération et la validation des tokens.

## Configuration CORS
Le partage des ressources entre origines multiples (CORS) est configuré pour permettre au frontend (Angular) de communiquer avec le backend. La classe `SecurityConfig` inclut les paramètres CORS pour autoriser les requêtes provenant de différentes origines.

## Tests
Le backend est testé à l'aide de Postman pour s'assurer que tous les endpoints fonctionnent correctement. Les cas de test incluent la création, la récupération, la mise à jour et la suppression des employés, ainsi que la vérification de l'authentification et de l'autorisation.

## Frontend
La partie frontend de l'application existe dans le dépôt suivant : [atelier7_frontend](https://github.com/ahyahya1616/atelier7_frontend).

## Conclusion
Le backend de l'application de gestion des employés est un système robuste et sécurisé construit avec des technologies modernes de Java. Il fournit une base solide pour l'application full-stack, garantissant une gestion efficace des données et un accès sécurisé à l'API.