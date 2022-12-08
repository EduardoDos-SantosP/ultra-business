package com.ultra.model.enderecos;

import com.ultra.controler.TipoPessoa;

public class ClienteEnderecoDAO extends EnderecoAbstratoDAO {
    @Override
    protected TipoPessoa getTipo() {
        return TipoPessoa.cliente();
    }
}
