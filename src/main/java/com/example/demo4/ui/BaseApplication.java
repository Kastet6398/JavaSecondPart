package com.example.demo4.ui;

import com.example.demo4.utils.Utils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class BaseApplication extends Application {
    BaseController controller;
    protected Stage stage;
    protected int width, height;
    protected String title = Utils.addSpaceBeforeCapital(getClass().getSimpleName());
    protected String template;
    protected FXMLLoader loader;
    protected boolean isMaximized;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader loader = load(template);
        Parent parent = loader.load();
        Scene scene = new Scene(parent, width, height);
        if (isMaximized && (width <= 0 || height <= 0))
            stage.setMaximized(true);
        initController(loader);
        stage.setTitle(title);
        stage.setScene(scene);
        initStage(stage);

        stage.show();
    }

    @SuppressWarnings("unused")
    protected Scene createEmptyScene(Parent root) {
        return new Scene(root, width, height);
    }
    @SuppressWarnings("unused")
    protected void initStage(Stage stage) {
    }

    protected FXMLLoader load(String template) {
        if (!template.contains("."))
            template += ".fxml";
        return new FXMLLoader(getClass().getResource(template));
    }

    protected void initController(FXMLLoader loader) {
        this.loader = loader;

        controller = loader.getController();
        controller.setStage(stage);
        controller.init();
    }
}
