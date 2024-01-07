package com.example.demo1.ui;

import com.example.demo1.Id;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.lang.reflect.Field;

public abstract class BaseController {
    public void setArg(Object arg) {
        this.arg = arg;
    }

    protected Object arg;
    public abstract void updateUI();

    public Node getField(Id id) {
        for (Field field : getClass().getDeclaredFields())
            try {
                if (field.get(this) instanceof Node value && field.getName().toLowerCase().replaceAll("_", "").equals(id.name().toLowerCase().replaceAll("_", "")))
                    return value;
            } catch (IllegalAccessException _) {
            }
        return null;
    }

    protected Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }
}
