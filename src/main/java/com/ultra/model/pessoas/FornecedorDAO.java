package com.ultra.model.pessoas;

import com.ultra.controler.TipoPessoa;

public class FornecedorDAO extends PessoaDAO {
    @Override
    public TipoPessoa getTipo() {
        return TipoPessoa.fornecedor();
    }
    /*public static void create(Pessoa c) throws ClassNotFoundException, SQLException {
        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement(
                "INSERT INTO fornecedor(nome, cpf) VALUES (?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS);

        stm.setString(1, c.getNome());
        stm.setString(2, c.getCpf());
        stm.execute();

        stm.getGeneratedKeys().next();
        c.setPk(stm.getGeneratedKeys().getInt(1));

        for (Endereco aux : c.getEnderecos()) {
            aux.setFk(c.getPk());
            FornecedorEnderecoDAO.create(aux);
        }
    }

    public static Pessoa retreave(int pk) throws ClassNotFoundException, SQLException {
        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement(
                "select * from fornecedor where pk_fornecedor=?");
        stm.setInt(1, pk);

        ResultSet rs = stm.executeQuery();
        rs.next();

        return new Pessoa(rs.getString("nome"),
                rs.getString("cpf"),
                FornecedorEnderecoDAO.retreaveAll(pk),
                pk);
    }

    public static ArrayList<Pessoa> retreaveAll() throws SQLException, ClassNotFoundException {
        Connection conn = BancoDados.getConnection();

        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM fornecedor ORDER BY NOME");

        ArrayList<Pessoa> aux = new ArrayList<>();

        while (rs.next()) {
            int pk = rs.getInt("pk_fornecedor");
            aux.add(new Pessoa(rs.getString("nome"),
                    rs.getString("cpf"),
                    FornecedorEnderecoDAO.retreaveAll(pk),
                    pk));
        }

        return aux;
    }

    public static void update(Pessoa c) throws ClassNotFoundException, SQLException {
        if (c.getPk() == 0) {
            throw new SQLException("O fornecedor não foi criada ou não existe");
        }

        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement("UPDATE fornecedor SET nome=?, cpf=? WHERE pk_fornecedor=?");
        stm.setString(1, c.getNome());
        stm.setString(2, c.getCpf());
        stm.setInt(3, c.getPk());

        stm.execute();

        for (Endereco aux : c.getEnderecos()) {
            if (aux.getPk() == 0) {
                FornecedorEnderecoDAO.create(aux);
            } else {
                FornecedorEnderecoDAO.update(aux);
            }

        }
    }

    public static void delete(Pessoa c) throws ClassNotFoundException, SQLException {
        delete(c.getPk());
    }

    public static void delete(int pk) throws ClassNotFoundException, SQLException {
        BancoDados.getConnection().createStatement().execute("DELETE FROM FORNCEDOR WHERE PK_FORNCEDOR = " + pk);
    }*/
}
