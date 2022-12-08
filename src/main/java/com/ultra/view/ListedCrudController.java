package com.ultra.view;

import com.ultra.controler.Model;
import com.ultra.view.util.modal.ErrorModal;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class ListedCrudController<T extends Model> extends CrudController<T> implements Initializable {
    @FXML
    private ListView<T> modelList = new ListView<>();

    @FXML
    private Button btnExcluir;

    public ListView<T> getModelList() {
        return modelList;
    }

    public ObservableList<T> getModelListItems() {
        return getModelList().getItems();
    }

    private T getListItemByPk(int pk) {
        return getModelListItems().stream()
                .filter(i -> i.getPk() == pk)
                .findFirst()
                .orElse(null);
    }

    public Button getBtnExcluir() {
        return btnExcluir;
    }

    public abstract Iterable<Control> getFields();

    public void limpaTela() {
        getFields().forEach(f -> {
            if (f instanceof TextInputControl)
                ((TextInputControl) f).clear();
            else if (f instanceof ComboBox)
                ((ComboBox<?>) f).getSelectionModel().clearSelection();
        });

        getModelList().getSelectionModel().clearSelection();
        setModel(null);
        getModelList().setDisable(false);
        getBtnExcluir().setVisible(false);
        getBtnExcluir().setVisible(false);
    }

    public abstract void executeCarregar(T model);

    @FXML
    public void carregar(MouseEvent event) {
        if (event.getClickCount() < 2) return;

        T model = getModelList()
                .getSelectionModel()
                .getSelectedItem();

        executeCarregar(model);

        setModel(model);
        getModelList().setDisable(true);
        getBtnExcluir().setVisible(true);
    }

    @FXML
    public void cancelar() {
        limpaTela();
    }

    public abstract void executeSalvar(T model);

    @FXML
    void salvar() {
        try {
            T model = getModel();
            if (model == null)
                model = newModelInstance();
            setModel(model);

            executeSalvar(model);

            ObservableList<T> items = getModelListItems();
            if (model.getPk() > 0) {
                getDAO().update(model);
                items.set(items.indexOf(getListItemByPk(model.getPk())), model);
            } else {
                getDAO().create(model);
                items.add(model);
            }
        } catch (Exception ex) {
            new ErrorModal(ex.toString(), "Erro ao salvar").show();
        }
        limpaTela();
    }

    @FXML
    void excluir() {
        try {
            getDAO().delete(getModel());
            getModelListItems().remove(getModel());
            limpaTela();
        } catch (Exception e) {
            new ErrorModal(e.getMessage(), "Erro ao excluir").show();
        }
    }

    public void aoInicializar() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            getBtnExcluir().setVisible(false);
            getModelListItems().addAll(getDAO().retreaveAll());
            aoInicializar();
        } catch (Exception ex) {
            new ErrorModal(ex).show();
        }
    }
}
