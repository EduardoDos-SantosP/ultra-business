package com.ultra.view.util.modal;

import javafx.scene.control.Alert;

public abstract class Modal {

    private final String title;
    private final String header;
    private final String content;
    private Alert alert;

    public Modal(String content, String header, String title) {
        this.title = title;
        this.header = header;
        this.content = content;
    }

    public Modal(String content, String header) {
        this(content, header, null);
    }

    public Modal(String content) {
        this(content, null, null);
    }

    public abstract Alert.AlertType getAlertType();

    public void show() {
        show(true);
    }

    public void show(boolean wait) {
        if (alert != null) alert.hide();

        Alert.AlertType type = getAlertType();

        alert = new Alert(type);

        alert.setTitle(title == null ? type.name() : title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        if (wait) alert.showAndWait();
        else alert.show();
    }

    public void hide() {
        alert.hide();
    }
}
