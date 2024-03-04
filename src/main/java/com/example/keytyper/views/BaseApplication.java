package com.example.keytyper.views;

import javafx.application.Application;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseApplication extends Application {
    private final Map<Object, Object> args = new HashMap<>();

    public Map<Object, Object> getArgs() {
        return args;
    }
}
