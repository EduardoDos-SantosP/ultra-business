package com.ultra.model.enderecos;

import com.ultra.controler.TipoPessoa;

public class FornecedorEnderecoDAO extends EnderecoAbstratoDAO {
    @Override
    protected TipoPessoa getTipo() {
        return TipoPessoa.fornecedor();
    }
}
