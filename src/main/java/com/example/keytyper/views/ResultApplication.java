package com.example.keytyper.views;

import com.example.keytyper.controllers.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ResultApplication extends BaseApplication {
    public static final int WIDTH = 3200;

    public static final int HEIGHT = 2400;

    @Override
    public void start(@NotNull Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ResultApplication.class.getResource("result-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        ((BaseController) fxmlLoader.getController()).getParameters().put("result", getArgs().get("result"));
        ((BaseController) fxmlLoader.getController()).setupUI();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
