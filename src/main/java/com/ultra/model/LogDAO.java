/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.ultra.controler.Log;

/**
 *
 * @author Prof Luciano Carlos
 */
public class LogDAO {

    public static Log retreave(int pk) throws ClassNotFoundException, SQLException {
        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement(
                "select * from log where pk_log=?");
        stm.setInt(1, pk);

        ResultSet rs = stm.executeQuery();
        rs.next();

        return new Log(rs.getString("usuario"),
                rs.getString("opr"),
                rs.getString("tabela"),
                rs.getString("descricao"),
                rs.getDate("data"),
                rs.getInt("pk_log"));
    }

    public static ArrayList<Log> retreaveAll() throws SQLException, ClassNotFoundException {
        Connection conn = BancoDados.getConnection();

        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM LOG ORDER BY DATA");

        ArrayList<Log> aux = new ArrayList<>();

        while (rs.next()) {
            aux.add(new Log(rs.getString("usuario"),
                    rs.getString("opr"),
                    rs.getString("tabela"),
                    rs.getString("descricao"),
                    rs.getDate("data"),
                    rs.getInt("pk_log")));
        }
        return aux;
    }

}
