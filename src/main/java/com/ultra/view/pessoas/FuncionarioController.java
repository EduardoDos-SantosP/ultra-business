package com.ultra.view.pessoas;

import com.ultra.controler.TipoPessoa;

public class FuncionarioController extends PessoaController {
    @Override
    public TipoPessoa getTipo() {
        return TipoPessoa.funcionario();
    }
}
