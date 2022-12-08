package com.ultra.model.pessoas;

import com.ultra.controler.Pessoa;
import com.ultra.controler.TipoPessoa;
import com.ultra.model.DAOAbstrato;
import com.ultra.model.enderecos.ClienteEnderecoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class PessoaDAO extends DAOAbstrato<Pessoa> {
    private final String tipo = getTipo().getNome();

    public abstract TipoPessoa getTipo();

    @Override
    protected PreparedStatement mapToBD(PreparedStatement stmt, Pessoa model) throws SQLException {
        stmt.setString(1, model.getNome());
        stmt.setString(2, model.getCpf());
        if (model.getPk() > 0)
            stmt.setInt(3, model.getPk());
        return stmt;
    }

    @Override
    protected Pessoa mapFromBD(ResultSet rs, int pk) throws SQLException {
        return new Pessoa(rs.getString("nome"),
                rs.getString("cpf"),
                new ClienteEnderecoDAO().setFk(pk).retreaveAll(),
                pk > 0 ? pk : rs.getInt("pk_" + tipo));
    }

    @Override
    protected String sqlRetrieveAll() {
        return "SELECT * FROM cliente ORDER BY NOME";
    }

    @Override
    protected String sqlRetrieve() {
        return "select * from cliente where pk_cliente=?";
    }

    @Override
    protected String sqlCreate() {
        return "INSERT INTO cliente(nome, cpf) VALUES (?, ?)";
    }

    @Override
    protected String sqlUpdate() {
        return "UPDATE cliente SET nome=?, cpf=? WHERE pk_cliente=?";
    }

    @Override
    protected String sqlDelete() {
        return "delete from " + tipo + " where pk_" + tipo + " = ?";
    }
}
