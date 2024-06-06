package com.mycompany.audocao1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String USER = "root";
    private static final String PASSWORD = "admin2024";
    private static final String DATABASE = "Audocao123";

    private static final String TIMEZONE = "America/Sao_Paulo";
    private static final String URL = String.format(
        "jdbc:mysql://%s:%s/%s?serverTimezone=%s",
        HOST, PORT, DATABASE, TIMEZONE
    );

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }
}