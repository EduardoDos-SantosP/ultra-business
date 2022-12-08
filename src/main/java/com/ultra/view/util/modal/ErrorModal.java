package com.ultra.view.util.modal;

import javafx.scene.control.Alert;

public class ErrorModal extends Modal {

    public ErrorModal(Throwable error) {
        this(error.toString(), "Ocorreu um erro inesperado.");
        System.out.println(error.getCause());
        error.printStackTrace();
    }

    public ErrorModal(String content, String header, String title) {
        super(content, header == null ? "Ocorreu um erro inesperado" : header, title);
    }

    public ErrorModal(String content, String header) {
        this(content, header, null);
    }

    public ErrorModal(String content) {
        this(content, null);
    }

    @Override
    public Alert.AlertType getAlertType() {
        return Alert.AlertType.ERROR;
    }
}
