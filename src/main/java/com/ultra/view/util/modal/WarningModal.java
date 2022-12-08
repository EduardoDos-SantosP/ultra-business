package com.ultra.view.util.modal;

import javafx.scene.control.Alert;

public class WarningModal extends Modal {

    public WarningModal(String content, String header, String title) {
        super(content, header, title);
    }

    public WarningModal(String content, String header) {
        super(content, header);
    }

    public WarningModal(String content) {
        super(content);
    }

    @Override
    public Alert.AlertType getAlertType() {
        return Alert.AlertType.WARNING;
    }
}
