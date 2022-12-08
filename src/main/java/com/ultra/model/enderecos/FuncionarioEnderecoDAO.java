package com.ultra.model.enderecos;

import com.ultra.controler.TipoPessoa;

public class FuncionarioEnderecoDAO extends EnderecoAbstratoDAO {
    @Override
    protected TipoPessoa getTipo() {
        return TipoPessoa.funcionario();
    }
}
