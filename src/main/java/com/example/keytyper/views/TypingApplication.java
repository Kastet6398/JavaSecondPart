package com.example.keytyper.views;

import com.example.keytyper.controllers.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TypingApplication extends BaseApplication {
    public static final int WIDTH = 3200;

    public static final int HEIGHT = 2400;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TypingApplication.class.getResource("typing-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        ((BaseController) fxmlLoader.getController()).getParameters().put("scene", scene);
        ((BaseController) fxmlLoader.getController()).getParameters().put("stage", stage);
        ((BaseController) fxmlLoader.getController()).setupUI();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
