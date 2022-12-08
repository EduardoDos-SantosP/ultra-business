package com.ultra.model;

public class CompraDAO {
    /*public static void create(Transacao t) throws ClassNotFoundException, SQLException {
        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement(
                "INSERT INTO compra(fk_fornecedor, numero, data_d) VALUES (?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS);

        stm.setInt(1, t.getProprietario().getPk());
        stm.setInt(2, t.getNumero());
        stm.setDate(3, t.getData());
        stm.execute();

        stm.getGeneratedKeys().next();
        t.setPk(stm.getGeneratedKeys().getInt(1));

        for (TransacaoItem aux : t.getItens()) {
            aux.setFk(t.getPk());
            CompraItemDAO.create(aux);
        }

        for (Financeiro aux : t.getFinancerio()) {
            aux.setFk(t.getPk());
            FinanceiroSaidaDAO.create(aux);
        }
    }

    public static Transacao retreave(int pk) throws ClassNotFoundException, SQLException {
        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement(
                "select * from compra where pk_compra=?");
        stm.setInt(1, pk);

        ResultSet rs = stm.executeQuery();
        rs.next();

        return new Transacao(
                ClienteDAO.retreave(rs.getInt("fk_fornecedor")),
                rs.getInt("numero"),
                rs.getDate("data_d"),
                CompraItemDAO.retreaveAll(pk),
                FinanceiroSaidaDAO.retreaveAll(pk),
                pk);
    }

    public static ArrayList<Transacao> retreaveAll() throws SQLException, ClassNotFoundException {
        Connection conn = BancoDados.getConnection();

        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM compra ORDER BY numero");

        ArrayList<Transacao> aux = new ArrayList<>();

        while (rs.next()) {
            int pk = rs.getInt("pk_compra");
            aux.add(new Transacao(
                    ClienteDAO.retreave(rs.getInt("fk_fornecedor")),
                    rs.getInt("numero"),
                    rs.getDate("data_d"),
                    CompraItemDAO.retreaveAll(pk),
                    FinanceiroSaidaDAO.retreaveAll(pk),
                    pk));
        }

        return aux;
    }

    public static void update(Transacao t) throws ClassNotFoundException, SQLException {
        if (t.getPk() == 0) {
            throw new SQLException("A compra não foi criada ou não existe");
        }

        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement("UPDATE compra SET fk_fornecedor=?, numero=?, data_d=? WHERE  pk_compra=?");
        stm.setInt(1, t.getProprietario().getPk());
        stm.setInt(2, t.getNumero());
        stm.setDate(3, t.getData());
        stm.setInt(4, t.getPk());

        stm.execute();

        for (TransacaoItem aux : t.getItens()) {
            if (aux.getPk() == 0) {
                CompraItemDAO.create(aux);
            } else {
                CompraItemDAO.update(aux);
            }
        }
        
        for (Financeiro aux : t.getFinancerio()) {
            if (aux.getPk() == 0) {
                FinanceiroSaidaDAO.create(aux);
            } else {
                FinanceiroSaidaDAO.update(aux);
            }
        }
    }

    public static void delete(Transacao c) throws ClassNotFoundException, SQLException {
        delete(c.getPk());
    }

    public static void delete(int pk) throws ClassNotFoundException, SQLException {
        BancoDados.getConnection().createStatement().execute("DELETE FROM compra WHERE pk_compra = " + pk);
    }*/
}
