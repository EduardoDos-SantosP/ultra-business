package com.ultra.view;

import com.ultra.controler.Produto;
import com.ultra.model.DAOAbstrato;
import com.ultra.model.ProdutoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

import java.util.List;

public class ProdutoController extends ListedCrudController<Produto> {
    @FXML
    private TextField estoque;

    @FXML
    private TextField estoqueMinimo;

    @FXML
    private TextField nome;

    @Override
    public void executeCarregar(Produto model) {
        nome.setText(model.getNome());
        estoque.setText(String.valueOf(model.getQtdEstoque()));
        estoqueMinimo.setText(String.valueOf(model.getEstoqueMinimo()));
    }

    @Override
    public void executeSalvar(Produto model) {
        model.setNome(nome.getText());
        model.setEstoqueMinimo(Double.parseDouble(estoqueMinimo.getText()));
        model.setQtdEstoque(Double.parseDouble(estoque.getText()));
    }

    @Override
    public Iterable<Control> getFields() {
        return List.of(new Control[]{nome, estoqueMinimo, estoque});
    }

    @Override
    public Produto newModelInstance() {
        return new Produto();
    }

    @Override
    public DAOAbstrato<Produto> newDAOInstance() {
        return new ProdutoDAO();
    }
}
