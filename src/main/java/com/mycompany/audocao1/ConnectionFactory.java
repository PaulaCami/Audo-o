package com.mycompany.audocao1;





/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author pcami
 */
public class ConnectionFactory {
    String host = "localhost";
    String port = "3306";
    String user = "root";
    String password = "admin2024";
    String database = "Audocao123";
    
    Connection conectar() throws Exception{

        var stringConexao = String.format(
            "jdbc:mysql://%s:%s/%s?serverTimezone=America/Sao_Paulo",
            host, port, database
        );
        return DriverManager.getConnection(
            stringConexao, user, password
        );
    } 
}