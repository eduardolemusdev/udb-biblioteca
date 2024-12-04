package com.aurora.donboscobiblio.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/dbcatedra?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "lemus";
    private static final String PASSWORD = "lemus";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
