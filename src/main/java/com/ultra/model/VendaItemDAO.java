package com.ultra.model;

public class VendaItemDAO {
    /*public static void create(TransacaoItem t) throws ClassNotFoundException, SQLException {
        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement(
                "INSERT INTO venda_item(fk_venda, fk_produto, qtd, valor_unitario) VALUES (?, ?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS);

        stm.setInt(1, t.getFk());
        stm.setInt(2, t.getProduto().getPk());
        stm.setDouble(3, t.getQtd());
        stm.setDouble(4, t.getValorUnitario());

        stm.execute();

        stm.getGeneratedKeys().next();
        t.setPk(stm.getGeneratedKeys().getInt(1));

    }

    public static TransacaoItem retreave(int pk) throws ClassNotFoundException, SQLException {
        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement(
                "select * from venda_item where pk_item=?");
        stm.setInt(1, pk);

        ResultSet rs = stm.executeQuery();
        rs.next();

        return new TransacaoItem(
                ProdutoDAO.retreave(rs.getInt("fk_produto")),
                rs.getDouble("qtd"), 
                rs.getDouble("valor_unitario"), 
                rs.getInt("fk_venda"), 
                pk);
    }

    public static ArrayList<TransacaoItem> retreaveAll(int fk) throws SQLException, ClassNotFoundException {
        Connection conn = BancoDados.getConnection();

        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM venda_item WHERE fk_venda = " + fk);

        ArrayList<TransacaoItem> aux = new ArrayList<>();

        while (rs.next()) {
            aux.add(new TransacaoItem(
                ProdutoDAO.retreave(rs.getInt("fk_produto")), 
                rs.getDouble("qtd"), 
                rs.getDouble("valor_unitario"), 
                rs.getInt("fk_venda"), 
                rs.getInt("pk_item")));
        }
        return aux;
    }

    public static void update(TransacaoItem t) throws ClassNotFoundException, SQLException {
        if (t.getPk() == 0) {
            throw new SQLException("O item não foi criado ou não existe");
        }
        
        if (!t.isUpdate()){
            return;
        }

        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement("UPDATE venda_item SET fk_venda=?, fk_produto=?, qtd=?, valor_unitario=? WHERE pk_item=?;");
      
        stm.setInt(1, t.getFk());
        stm.setInt(2, t.getProduto().getPk());
        stm.setDouble(3, t.getQtd());
        stm.setDouble(4, t.getValorUnitario());
        stm.setInt(5, t.getPk());

        stm.execute();
        t.setUpdate(false);
    }

    public static void delete(TransacaoItem t) throws ClassNotFoundException, SQLException {
        delete(t.getPk());
    }

    public static void delete(int pk) throws ClassNotFoundException, SQLException {
        BancoDados.getConnection().createStatement().execute("DELETE FROM venda_item WHERE pk_item = " + pk);
    }*/
}
