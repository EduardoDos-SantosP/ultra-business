package com.ultra.model.enderecos;

import com.ultra.controler.Endereco;
import com.ultra.controler.TipoPessoa;
import com.ultra.model.DAOAbstrato;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class EnderecoAbstratoDAO extends DAOAbstrato<Endereco> {
    private final String tipo;

    public EnderecoAbstratoDAO() {
        tipo = getTipo().getNome();
    }

    protected abstract TipoPessoa getTipo();

    @Override
    protected PreparedStatement mapToBD(PreparedStatement stmt, Endereco model) throws SQLException {
        stmt.setInt(1, model.getFk());
        stmt.setString(2, model.getLogradouro());
        stmt.setString(3, model.getBairro());
        stmt.setString(4, model.getCidade());
        stmt.setString(5, model.getEstado());
        stmt.setString(6, model.getPais());
        stmt.setString(7, model.getCep());
        if (model.getPk() > 0)
            stmt.setInt(8, model.getPk());
        return stmt;
    }

    @Override
    protected Endereco mapFromBD(ResultSet rs, int pk) throws SQLException {
        return new Endereco(
                rs.getString("logradouro"),
                rs.getString("bairro"),
                rs.getString("cidade"),
                rs.getString("estado"),
                rs.getString("pais"),
                rs.getString("cep"),
                pk > 0 ? pk : rs.getInt("pk_endereco"),
                rs.getInt("fk_" + tipo));
    }

    private int fk = 0;

    @Override
    protected String sqlRetrieveAll() {
        String sql = "select * from " + tipo + "_endereco"
                + (fk <= 0 ? "" : " where fk_" + tipo + " = " + fk);
        fk = 0;
        return sql;
    }

    public EnderecoAbstratoDAO setFk(int fk) {
        this.fk = fk;

        return this;
    }

    @Override
    protected String sqlRetrieve() {
        return "select * from " + tipo + "_endereco where pk_endereco=?";
    }

    @Override
    protected String sqlCreate() {
        return "INSERT INTO " + tipo + "_endereco " +
                "(fk_" + tipo + ", logradouro, bairro, cidade, estado, pais, cep) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String sqlUpdate() {
        return "UPDATE " + tipo + "_endereco " +
                "SET fk_" + tipo + "=?, logradouro=?, bairro=?, cidade=?, estado=?, pais=?, cep=? " +
                "WHERE pk_endereco=?";
    }

    @Override
    protected String sqlDelete() {
        return "delete from " + tipo + "_endereco where pk_endereco = ?";
    }
}
