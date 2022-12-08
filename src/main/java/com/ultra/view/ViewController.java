package com.ultra.view;

import com.ultra.view.util.NodeHelper;
import com.ultra.view.util.modal.ErrorModal;
import javafx.css.Styleable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public abstract class ViewController {
    @FXML
    public void goTo(ActionEvent event) {
        try {
            Styleable link = ((Styleable) event.getTarget());
            String href = NodeHelper.getStyleRules(link).get("href");
            if (href == null)
                new ErrorModal("Ocorreu um erro com o link. Não foi possível ir para o local desejado.").show();
            App.setRoot(href);
        } catch (Throwable e) {
            new ErrorModal(e.getMessage(), "Não foi possível localizar a tela", "404").show();
        }
    }
}
