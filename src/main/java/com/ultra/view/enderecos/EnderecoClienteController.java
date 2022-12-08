package com.ultra.view.enderecos;

import com.ultra.controler.TipoPessoa;

public class EnderecoClienteController extends EnderecoAbstratoController {
    @Override
    public TipoPessoa getTipo() {
        return TipoPessoa.cliente();
    }
}
