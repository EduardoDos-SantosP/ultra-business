package com.ultra.model.pessoas;

import com.ultra.controler.TipoPessoa;

public class FuncionarioDAO extends PessoaDAO {
    @Override
    public TipoPessoa getTipo() {
        return TipoPessoa.funcionario();
    }
    /*public static void create(Funcionario f) throws ClassNotFoundException, SQLException {
        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement(
                "INSERT INTO funcionario(nome, cpf, fk_cargo) VALUES (?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS);

        stm.setString(1, f.getNome());
        stm.setString(2, f.getCpf());
        stm.setInt(3, f.getCargo().getPk());
        stm.execute();

        stm.getGeneratedKeys().next();
        f.setPk(stm.getGeneratedKeys().getInt(1));

        for (Endereco aux : f.getEnderecos()) {
            aux.setFk(f.getPk());
            FuncionarioEnderecoDAO.create(aux);
        }
    }

    public static Funcionario retreave(int pk) throws ClassNotFoundException, SQLException {
        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement(
                "select * from funcionario where pk_funcionario=?");
        stm.setInt(1, pk);

        ResultSet rs = stm.executeQuery();
        rs.next();

        return new Funcionario(
                CargoDAO.retreave(rs.getInt("fk_cargo")),
                rs.getString("nome"),
                rs.getString("cpf"),
                FuncionarioEnderecoDAO.retreaveAll(pk),
                pk
        );
    }

    public static ArrayList<Funcionario> retreaveAll() throws SQLException, ClassNotFoundException {
        Connection conn = BancoDados.getConnection();

        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM funcionario ORDER BY NOME");

        ArrayList<Funcionario> aux = new ArrayList<>();

        while (rs.next()) {
            int pk = rs.getInt("pk_funcionario");
            aux.add(new Funcionario(
                    CargoDAO.retreave(rs.getInt("fk_cargo")),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    FuncionarioEnderecoDAO.retreaveAll(pk),
                    pk
            ));
        }

        return aux;
    }

    public static void update(Funcionario f) throws ClassNotFoundException, SQLException {
        if (f.getPk() == 0) {
            throw new SQLException("O funcionario não foi criada ou não existe");
        }

        Connection conn = BancoDados.getConnection();

        PreparedStatement stm = conn.prepareStatement("UPDATE funcionario SET nome=?, cpf=?, fk_cargo=? WHERE pk_funcionario=?");
        stm.setString(1, f.getNome());
        stm.setString(2, f.getCpf());
        stm.setInt(3, f.getCargo().getPk());
        stm.setInt(4, f.getPk());

        stm.execute();

        for (Endereco aux : f.getEnderecos()) {
            if (aux.getPk() == 0) {
                FuncionarioEnderecoDAO.create(aux);
            } else {
                FuncionarioEnderecoDAO.update(aux);
            }
        }
    }

    public static void delete(Funcionario f) throws ClassNotFoundException, SQLException {
        delete(f.getPk());
    }

    public static void delete(int pk) throws ClassNotFoundException, SQLException {
        BancoDados.getConnection().createStatement().execute("DELETE FROM FUNCIONARIO WHERE PK_FUNCIONARIO = " + pk);
    }*/
}
