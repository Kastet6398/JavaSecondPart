package com.example.demo4.ui;

import javafx.stage.Stage;

public abstract class BaseController {
    protected Stage stage;

    public final void setStage(Stage stage) {
        this.stage = stage;
    }

    public abstract void init();
}
