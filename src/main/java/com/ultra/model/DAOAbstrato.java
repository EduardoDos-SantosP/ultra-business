package com.ultra.model;

import com.ultra.controler.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DAOAbstrato<T extends Model> {
    public DAOAbstrato() {
    }

    private static Connection getConnection() throws SQLException {
        return BancoDados.getConnection();
    }

    protected abstract PreparedStatement mapToBD(PreparedStatement stmt, T model) throws SQLException;

    protected abstract T mapFromBD(ResultSet rs, int pk) throws SQLException;

    protected abstract String sqlRetrieveAll();

    public T retreave(int pk) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sqlRetrieve());
        stmt.setInt(1, pk);
        ResultSet rs = stmt.executeQuery();
        return rs.next() ? mapFromBD(rs, pk) : null;
    }

    protected abstract String sqlRetrieve();

    public ArrayList<T> retreaveAll() throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sqlRetrieveAll());
        ResultSet rs = stmt.executeQuery();
        ArrayList<T> list = new ArrayList<>();
        while (rs.next())
            list.add(mapFromBD(rs, 0));
        return list;
    }

    protected abstract String sqlCreate();

    public void create(T model) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = mapToBD(
                conn.prepareStatement(sqlCreate(), PreparedStatement.RETURN_GENERATED_KEYS),
                model
        );
        stmt.execute();
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys.next())
            model.setPk(generatedKeys.getInt(1));
    }

    private String filterSql(T model, boolean delete) throws SQLException {
        if (model.getPk() <= 0) throw new SQLException("O objeto " + model + "não foi uma chave primaria válida");
        String sql = delete ? sqlDelete() : sqlUpdate();
        if (!sql.toLowerCase().matches("^.+where.+$"))
            throw new SQLException("O script não possui WHERE");
        return sql;
    }

    protected abstract String sqlUpdate();

    public void update(T model) throws SQLException {
        String sql = filterSql(model, false);
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        mapToBD(stmt, model).execute();
    }

    protected abstract String sqlDelete();

    public void delete(T model) throws SQLException {
        String sql = filterSql(model, true);
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, model.getPk());
        stmt.execute();
    }
}
