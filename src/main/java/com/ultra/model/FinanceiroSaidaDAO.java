/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultra.model;

import com.ultra.controler.Financeiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FinanceiroSaidaDAO {


    public static void create(Financeiro f) throws ClassNotFoundException, SQLException {
        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement(
                "INSERT INTO financeiro_saida" +
                        "(fk_compra, data_emissao, data_vencimento, data_baixa, valor, forma_pagamento) " +
                        "VALUES (?, ?, ?, ?, ?, ?);",
                PreparedStatement.RETURN_GENERATED_KEYS);

        stm.setInt(1, f.getFk());
        stm.setDate(2, f.getDataEmissao());
        stm.setDate(3, f.getDataVencimento());
        stm.setDate(4, f.getDataBaixa());
        stm.setDouble(5, f.getValor());
        stm.setString(6, f.getForma());
        stm.execute();

        stm.getGeneratedKeys().next();
        f.setPk(stm.getGeneratedKeys().getInt(1));

    }

    public static Financeiro retreave(int pk) throws ClassNotFoundException, SQLException {
        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement(
                "select * from financeiro_saida where pk_financeiro=?");
        stm.setInt(1, pk);

        ResultSet rs = stm.executeQuery();
        rs.next();

        return new Financeiro(
                rs.getDate("data_emissao"),
                rs.getDate("data_vencimento"),
                rs.getDate("data_baixa"),
                rs.getDouble("valor"),
                rs.getString("forma_pagamento"),
                rs.getInt("fk_compra"),
                pk);
    }

    public static ArrayList<Financeiro> retreaveAll(int fk) throws SQLException, ClassNotFoundException {
        Connection conn = BancoDados.getConnection();

        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM financeiro_saida WHERE fk_compra = " + fk);

        ArrayList<Financeiro> aux = new ArrayList<>();

        while (rs.next()) {
            aux.add(new Financeiro(
                    rs.getDate("data_emissao"),
                    rs.getDate("data_vencimento"),
                    rs.getDate("data_baixa"),
                    rs.getDouble("valor"),
                    rs.getString("forma_pagamento"),
                    rs.getInt("fk_compra"),
                    rs.getInt("pk_financeiro")));
        }
        return aux;
    }

    public static void update(Financeiro f) throws ClassNotFoundException, SQLException {
        if (f.getPk() == 0) {
            throw new SQLException("O financeiro não foi criado ou não existe");
        }

        if (!f.isUpdate()) {
            return;
        }

        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement("UPDATE financeiro_saida SET fk_compra=?, data_emissao=?, data_vencimento=?, data_baixa=?, valor=?, forma_pagamento=? WHERE pk_financeiro=?;");
        stm.setInt(1, f.getFk());
        stm.setDate(2, f.getDataEmissao());
        stm.setDate(3, f.getDataVencimento());
        stm.setDate(4, f.getDataBaixa());
        stm.setDouble(5, f.getValor());
        stm.setString(6, f.getForma());
        stm.setInt(7, f.getPk());

        stm.execute();
        f.setUpdate(false);
    }

    public static void delete(Financeiro f) throws ClassNotFoundException, SQLException {
        delete(f.getPk());
    }

    public static void delete(int pk) throws ClassNotFoundException, SQLException {
        BancoDados.getConnection().createStatement().execute("DELETE FROM financeiro_saida WHERE pk_financeiro = " + pk);
    }

}
