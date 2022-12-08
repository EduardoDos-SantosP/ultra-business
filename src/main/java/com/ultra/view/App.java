package com.ultra.view;

import com.ultra.view.util.modal.ErrorModal;
import com.ultra.view.util.modal.LoadingModal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class App extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("home"), 800, 450);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        AtomicReference<Throwable> error = new AtomicReference<>();

        new LoadingModal().await(() -> {
            try {
                scene.setRoot(loadFXML(fxml));
            } catch (Throwable e) {
                error.set(e);
            }
        });

        if (error.get() != null)
            new ErrorModal(error.get()).show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}