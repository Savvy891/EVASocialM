package org.example;


import org.example.controllers.PostController;
import org.example.repositories.InMemoryPostRepository;
import org.example.repositories.PostRepository;
import org.example.services.PostService;
import org.example.ui.View;
import org.example.utils.DatabaseConnection;
import org.example.utils.DependencyContainer;

import java.sql.SQLException;
import java.util.Scanner;

public class SocialMediaApp {
    public static void main(String[] args) throws SQLException {
        DependencyContainer dependencyContainer = DependencyContainer.getINSTANCE();

        // Register a simple in-memory repository for storing posts
        dependencyContainer.setService("repo", new InMemoryPostRepository());
        // Register a single Scanner instance shared across the app for console IO
        dependencyContainer.setService("scanner", new Scanner(System.in));
        // Register service with repository dependency resolved from the container
        dependencyContainer.setService("service", new PostService(
                (PostRepository) dependencyContainer.getService("repo")
        ));
        // Register controller with service + scanner
        dependencyContainer.setService("controller", new PostController(
                (PostService) dependencyContainer.getService("service"),
                (Scanner) dependencyContainer.getService("scanner")));
        // Register view with controller + scanner and start the app
        dependencyContainer.setService("view", new View(
                (PostController) dependencyContainer.getService("controller"),
                (Scanner) dependencyContainer.getService("scanner")));

        if (DatabaseConnection.getInstance().getConnection().isValid(5)){
            System.out.println("DATABASE CONNECTED");
        }

        ((View) dependencyContainer.getService("view")).start();
    }
}

