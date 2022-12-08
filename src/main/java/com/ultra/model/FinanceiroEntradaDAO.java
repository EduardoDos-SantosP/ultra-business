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
import com.ultra.controler.Endereco;
import com.ultra.controler.Financeiro;

/**
 *
 * @author Prof Luciano Carlos
 */
public class FinanceiroEntradaDAO {

    
    public static void create(Financeiro f) throws ClassNotFoundException, SQLException {
        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement(
                "INSERT INTO financeiro_entrada(fk_venda, data_emissao, data_vencimento, data_baixa, valor, forma_recebimento) VALUES (?, ?, ?, ?, ?, ?);",
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
                "select * from financeiro_entrada where pk_financeiro=?");
        stm.setInt(1, pk);

        ResultSet rs = stm.executeQuery();
        rs.next();

        return new Financeiro(
                rs.getDate("data_emissao"), 
                rs.getDate("data_vencimento"), 
                rs.getDate("data_baixa"), 
                rs.getDouble("valor"), 
                rs.getString("forma_recebimento"), 
                rs.getInt("fk_venda"), 
                pk);
    }

    public static ArrayList<Financeiro> retreaveAll(int fk) throws SQLException, ClassNotFoundException {
        Connection conn = BancoDados.getConnection();

        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM financeiro_entrada WHERE fk_venda = " + fk);

        ArrayList<Financeiro> aux = new ArrayList<>();

        while (rs.next()) {
            aux.add(new Financeiro(
                rs.getDate("data_emissao"), 
                rs.getDate("data_vencimento"), 
                rs.getDate("data_baixa"), 
                rs.getDouble("valor"), 
                rs.getString("forma_recebimento"), 
                rs.getInt("fk_venda"), 
                rs.getInt("pk_financeiro")));
        }
        return aux;
    }

    public static void update(Financeiro f) throws ClassNotFoundException, SQLException {
        if (f.getPk() == 0) {
            throw new SQLException("O financeiro não foi criado ou não existe");
        }
        
        if (!f.isUpdate()){
            return;
        }

        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement("UPDATE financeiro_entrada SET fk_venda=?, data_emissao=?, data_vencimento=?, data_baixa=?, valor=?, forma_recebimento=? WHERE pk_financeiro=?;");
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

    public static void delete(Endereco e) throws ClassNotFoundException, SQLException {
        delete(e.getPk());
    }

    public static void delete(int pk) throws ClassNotFoundException, SQLException {
        BancoDados.getConnection().createStatement().execute("DELETE FROM financeiro_entrada WHERE pk_financeiro = " + pk);
    }
    
}
