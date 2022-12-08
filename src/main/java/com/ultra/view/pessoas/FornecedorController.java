package com.ultra.view.pessoas;

import com.ultra.controler.TipoPessoa;

public class FornecedorController extends PessoaController {
    @Override
    public TipoPessoa getTipo() {
        return TipoPessoa.fornecedor();
    }
}
