package com.ultra.view.pessoas;

import com.ultra.controler.Cargo;
import com.ultra.model.DAOAbstrato;
import com.ultra.model.pessoas.CargoDAO;
import com.ultra.view.ListedCrudController;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

import java.util.List;

public class CargoController extends ListedCrudController<Cargo> {
    @FXML
    public TextField nome;
    @FXML
    public TextField descricao;

    @Override
    public Cargo newModelInstance() {
        return new Cargo();
    }

    @Override
    public DAOAbstrato<Cargo> newDAOInstance() {
        return new CargoDAO();
    }

    @Override
    public Iterable<Control> getFields() {
        return List.of(nome, descricao);
    }

    @Override
    public void executeCarregar(Cargo model) {
        nome.setText(model.getNome());
        descricao.setText(model.getDescricao());
    }

    @Override
    public void executeSalvar(Cargo model) {
        model.setNome(nome.getText());
        model.setDescricao(descricao.getText());
    }
}
