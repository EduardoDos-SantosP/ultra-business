/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultra.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {
    public static final String DRIVER = "org.postgresql.Driver";
    public static final String URL = "jdbc:postgresql://localhost/ultra_b";
    public static final String USER = "postgres";
    public static final String PASS = "123456";

    private static Connection conn;

    public static Connection getConnection() throws SQLException {
        if (conn != null) return conn;
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new SQLException("O driver " + DRIVER + " não foi encontrado", e);
        }
        return conn = DriverManager.getConnection(URL, USER, PASS);
    }
}
