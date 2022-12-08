package com.ultra.view.util.modal;

import javafx.scene.control.Alert;

public class LoadingModal extends Modal {
    public LoadingModal(String content, String title, String header) {
        super(content, header == null ? "Carregando..." : header, title);
    }

    public LoadingModal(String content, String header) {
        this(content, header, null);
    }

    public LoadingModal(String content) {
        this(content, null);
    }

    public LoadingModal() {
        this(null);
    }

    @Override
    public Alert.AlertType getAlertType() {
        return Alert.AlertType.INFORMATION;
    }

    public void await(Runnable action) {
        show(false);
        action.run();
        hide();
    }
}
