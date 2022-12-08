/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultra.model;

import com.ultra.controler.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO extends DAOAbstrato<Produto> {
    @Override
    protected PreparedStatement mapToBD(PreparedStatement stmt, Produto model) throws SQLException {
        stmt.setString(1, model.getNome());
        stmt.setDouble(2, model.getEstoqueMinimo());
        stmt.setDouble(3, model.getQtdEstoque());
        if (model.getPk() > 0)
            stmt.setInt(4, model.getPk());
        return stmt;
    }

    @Override
    protected Produto mapFromBD(ResultSet rs, int pk) throws SQLException {
        return new Produto(
                rs.getString("nome"),
                rs.getDouble("estoque_minimo"),
                rs.getDouble("qtd_estoque"),
                pk > 0 ? pk : rs.getInt("pk_produto"));
    }

    @Override
    protected String sqlRetrieveAll() {
        return "SELECT * FROM PRODUTO ORDER BY NOME";
    }

    @Override
    protected String sqlRetrieve() {
        return "select * from produto where pk_produto=?";
    }

    @Override
    protected String sqlCreate() {
        return "INSERT INTO produto(nome, estoque_minimo, qtd_estoque) VALUES (?, ?, ?)";
    }

    @Override
    protected String sqlUpdate() {
        return "UPDATE produto SET nome=?, estoque_minimo=?, qtd_estoque=? WHERE pk_produto=?";
    }

    @Override
    protected String sqlDelete() {
        return "delete from produto where pk_produto = ?";
    }
}
