package com.ultra.view.pessoas;

import com.ultra.controler.TipoPessoa;

public class ClienteController extends PessoaController {
    @Override
    public TipoPessoa getTipo() {
        return TipoPessoa.cliente();
    }
}
