# Gestionnaire de Réservations d'Hôtel

Ce projet est une application permettant de gérer les réservations d'hôtel, incluant les chambres, les utilisateurs, et les réservations. Le système offre des fonctionnalités comme la gestion des réservations, la pagination des résultats pour les utilisateurs, et une architecture backend robuste. Le backend est développé en **Java avec Spring Boot**, et la base de données utilisée est **MySQL**. Le frontend est développé avec **Angular** pour fournir une interface utilisateur moderne et interactive.

## Description des Choix Techniques

### Backend - Java avec Spring Boot & MySQL
* **Spring Boot** est utilisé pour développer une API REST, gérer les services backend, et organiser l'application selon les principes MVC.
* **MySQL** est utilisé pour stocker toutes les données liées aux utilisateurs, chambres, et réservations.
* **JPA/Hibernate** est employé pour interagir avec la base de données et simplifier les opérations CRUD.
* **Maven** est utilisé pour gérer les dépendances et structurer le projet.

### Frontend - Angular
* **Angular** est utilisé pour développer une interface utilisateur moderne et réactive.
* Le framework permet de consommer l'API REST et d'afficher les données en temps réel.
* **TypeScript** améliore la robustesse et la maintenabilité du code frontend.
* L'interface utilisateur comprend des fonctionnalités telles que la gestion des utilisateurs, la création et la modification des réservations.

## Fonctionnalités Principales
* **Inscription et gestion des utilisateurs** : Les utilisateurs peuvent s'inscrire, se connecter, et gérer leurs réservations.
* **Gestion des réservations** : Création, modification et affichage des réservations pour un utilisateur donné.
* **Pagination des réservations** : Permet de limiter les résultats affichés par page pour améliorer l'expérience utilisateur.
* **Gestion des chambres** : Chaque chambre peut être associée à des réservations avec un suivi du statut.
* **Interface utilisateur intuitive** : Fournie par Angular, elle permet une navigation facile et une expérience utilisateur optimisée.

## Prérequis

Avant de démarrer le projet, assure-toi d'avoir installé les éléments suivants :

* **Java** 17 ou supérieur
* **Maven** pour gérer les dépendances backend
* **MySQL** 8.0 ou supérieur
* **Node.js** et **npm** (pour le frontend Angular)
* **IDE** (IntelliJ IDEA, Eclipse ou VS Code recommandé)

## Instructions pour l'installation

### Cloner le projet
```bash
git clone https://github.com/Oscarj-jqt/javotel
cd Project
