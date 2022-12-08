package com.ultra.model.pessoas;

import com.ultra.controler.Cargo;
import com.ultra.model.DAOAbstrato;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CargoDAO extends DAOAbstrato<Cargo> {
    @Override
    protected PreparedStatement mapToBD(PreparedStatement stmt, Cargo model) throws SQLException {
        stmt.setString(1, model.getNome());
        stmt.setString(2, model.getDescricao());
        stmt.setInt(3, model.getPk());
        return stmt;
    }

    @Override
    protected Cargo mapFromBD(ResultSet rs, int pk) throws SQLException {
        return new Cargo(rs.getString("nome"),
                rs.getString("descricao"),
                pk > 0 ? pk : rs.getInt("pk_cargo"));
    }

    @Override
    protected String sqlRetrieveAll() {
        return "SELECT * FROM CARGO ORDER BY NOME";
    }

    @Override
    protected String sqlRetrieve() {
        return "select * from cargo where pk_cargo=?";
    }

    @Override
    protected String sqlCreate() {
        return "INSERT INTO cargo(nome, descricao) VALUES (?,?)";
    }

    @Override
    protected String sqlUpdate() {
        return "UPDATE cargo SET nome=?, descricao=? WHERE pk_cargo=?";
    }

    @Override
    protected String sqlDelete() {
        return "DELETE FROM CARGO WHERE PK_CARGO = ?";
    }



    /*public static void create(Cargo c) throws ClassNotFoundException, SQLException {
        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement(
                "INSERT INTO cargo(nome, descricao) VALUES (?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS);

        stm.setString(1, c.getNome());
        stm.setString(2, c.getDescricao());
        stm.execute();

        stm.getGeneratedKeys().next();
        c.setPk(stm.getGeneratedKeys().getInt(1));

    }


    public static Cargo retreave(int pk) throws ClassNotFoundException, SQLException {
        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement(
                "select * from cargo where pk_cargo=?");
        stm.setInt(1, pk);

        ResultSet rs = stm.executeQuery();
        rs.next();

        return new Cargo(rs.getString("nome"),
                rs.getString("descricao"),
                rs.getInt("pk_cargo"));
    }

    public static ArrayList<Cargo> retreaveAll() throws SQLException, ClassNotFoundException {
        Connection conn = BancoDados.getConnection();

        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM CARGO ORDER BY NOME");

        ArrayList<Cargo> aux = new ArrayList<>();

        while (rs.next()) {
            aux.add(new Cargo(
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getInt("pk_cargo")));
        }

        return aux;
    }

    public static void update(Cargo c) throws ClassNotFoundException, SQLException {
        if (c.getPk() == 0) {
            throw new SQLException("O cargo não foi criado ou não existe");
        }

        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement("UPDATE cargo SET nome=?, descricao=? WHERE pk_cargo=?");
        stm.setString(1, c.getNome());
        stm.setString(2, c.getDescricao());
        stm.setInt(3, c.getPk());

        stm.execute();
    }

    public static void delete(Cargo c) throws ClassNotFoundException, SQLException {
        delete(c.getPk());
    }

    public static void delete(int pk) throws ClassNotFoundException, SQLException {
        BancoDados.getConnection().createStatement().execute("DELETE FROM CARGO WHERE PK_CARGO = " + pk);
    }*/
}
