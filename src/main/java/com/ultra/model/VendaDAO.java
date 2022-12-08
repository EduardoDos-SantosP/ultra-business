package com.ultra.model;

public class VendaDAO {
    /*public static void create(Venda v) throws ClassNotFoundException, SQLException {
        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement(
                "INSERT INTO venda(fk_cliente, fk_vendedor, numero, data_d) VALUES (?, ?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS);

        stm.setInt(1, v.getProprietario().getPk());
        stm.setInt(2, v.getVendedor().getPk());
        stm.setInt(3, v.getNumero());
        stm.setDate(4, v.getData());
        stm.execute();

        stm.getGeneratedKeys().next();
        v.setPk(stm.getGeneratedKeys().getInt(1));

        for (TransacaoItem aux : v.getItens()) {
            aux.setFk(v.getPk());
            VendaItemDAO.create(aux);
        }

        for (Financeiro aux : v.getFinancerio()) {
            aux.setFk(v.getPk());
            FinanceiroEntradaDAO.create(aux);
        }
    }

    public static Venda retreave(int pk) throws ClassNotFoundException, SQLException {
        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement(
                "select * from venda where pk_venda=?");
        stm.setInt(1, pk);

        ResultSet rs = stm.executeQuery();
        rs.next();

        return new Venda(
                FuncionarioDAO.retreave(rs.getInt("fk_vendedor")),
                ClienteDAO.retreave(rs.getInt("fk_cliente")),
                rs.getInt("numero"),
                rs.getDate("data_d"),
                VendaItemDAO.retreaveAll(pk),
                FinanceiroEntradaDAO.retreaveAll(pk),
                pk);
    }

    public static ArrayList<Venda> retreaveAll() throws SQLException, ClassNotFoundException {
        Connection conn = BancoDados.getConnection();

        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM venda ORDER BY numero");

        ArrayList<Venda> aux = new ArrayList<>();

        while (rs.next()) {
            int pk = rs.getInt("pk_venda");
            aux.add(new Venda(
                FuncionarioDAO.retreave(rs.getInt("fk_vendedor")),
                ClienteDAO.retreave(rs.getInt("fk_cliente")),
                rs.getInt("numero"),
                rs.getDate("data_d"),
                VendaItemDAO.retreaveAll(pk),
                FinanceiroEntradaDAO.retreaveAll(pk),
                pk));
        }

        return aux;
    }

    public static void update(Venda v) throws ClassNotFoundException, SQLException {
        if (v.getPk() == 0) {
            throw new SQLException("A venda não foi criada ou não existe");
        }

        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement("UPDATE venda SET fk_cliente=?, fk_vendedor=?, numero=?, data_d=? WHERE  pk_venda=?");

        stm.setInt(1, v.getProprietario().getPk());
        stm.setInt(2, v.getVendedor().getPk());
        stm.setInt(3, v.getNumero());
        stm.setDate(4, v.getData());
        stm.setInt(5, v.getPk());

        stm.execute();

        for (TransacaoItem aux : v.getItens()) {
            if (aux.getPk() == 0) {
                VendaItemDAO.create(aux);
            } else {
                VendaItemDAO.update(aux);
            }
        }
        
        for (Financeiro aux : v.getFinancerio()) {
            if (aux.getPk() == 0) {
                FinanceiroEntradaDAO.create(aux);
            } else {
                FinanceiroEntradaDAO.update(aux);
            }
        }
    }

    public static void delete(Venda v) throws ClassNotFoundException, SQLException {
        delete(v.getPk());
    }

    public static void delete(int pk) throws ClassNotFoundException, SQLException {
        BancoDados.getConnection().createStatement().execute("DELETE FROM venda WHERE pk_venda = " + pk);
    }*/
}
