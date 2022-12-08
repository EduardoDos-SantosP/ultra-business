package com.ultra.view.enderecos;

import com.ultra.controler.TipoPessoa;

public class EnderecoFornecedorController extends EnderecoAbstratoController {
    @Override
    public TipoPessoa getTipo() {
        return TipoPessoa.fornecedor();
    }
}
