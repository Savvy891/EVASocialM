package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static  DatabaseConnection instance;
    private Connection connection;

    private final String URL = "jdbc:mysql//localhost:3306/social_media_console";
    private final String USER = "root";
    private final String PASSWORD = "savvyMySQL";

    private DatabaseConnection(){
        try{
            Class.forName("com.mysql.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static DatabaseConnection getInstance(){
        if(instance == null ){
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
