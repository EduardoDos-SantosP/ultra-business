package com.ultra.view.pessoas;

import com.ultra.controler.Pessoa;
import com.ultra.controler.TipoPessoa;
import com.ultra.model.DAOAbstrato;
import com.ultra.model.pessoas.ClienteDAO;
import com.ultra.view.ListedCrudController;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

import java.util.List;

public abstract class PessoaController extends ListedCrudController<Pessoa> {
    @FXML
    public TextField nome;
    @FXML
    public TextField cpf;

    private final TipoPessoa tipo = getTipo();

    public abstract TipoPessoa getTipo();

    @Override
    public Pessoa newModelInstance() {
        return new Pessoa();
    }

    @Override
    public DAOAbstrato<Pessoa> newDAOInstance() {
        return new ClienteDAO();
    }

    @Override
    public Iterable<Control> getFields() {
        return List.of(nome, cpf);
    }

    @Override
    public void executeCarregar(Pessoa model) {
        nome.setText(model.getNome());
        cpf.setText(model.getCpf());
    }

    @Override
    public void executeSalvar(Pessoa model) {
        model.setNome(nome.getText());
        model.setCpf(cpf.getText());
    }
}
