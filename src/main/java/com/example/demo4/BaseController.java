package com.example.demo4;

import javafx.stage.Stage;

public abstract class BaseController {
    public abstract void init();
    protected Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
