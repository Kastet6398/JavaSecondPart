package com.example.demo1.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class TasksApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlHelloLoader = new FXMLLoader(TasksApplication.class.getResource("tasks-view.fxml"));
        Scene scene = new Scene(fxmlHelloLoader.load(), 320, 240);
        scene.getStylesheets().add(Objects.requireNonNull(TasksApplication.class.getResource("tasks-stylesheet.css")).toExternalForm());
        fxmlHelloLoader.<BaseController>getController().setStage(stage);
        fxmlHelloLoader.<BaseController>getController().updateUI();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}