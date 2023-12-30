package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlHelloLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlHelloLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();


//        FXMLLoader fxmlDemoLoader = new FXMLLoader(HelloApplication.class.getResource("demo.fxml"));
//        Scene demoScene = new Scene(fxmlDemoLoader.load(), 320, 240);
//        stage.setTitle("Demo!");
//        stage.setScene(demoScene);
//        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}