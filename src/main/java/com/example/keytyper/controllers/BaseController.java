package com.example.keytyper.controllers;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {
    private final Map<Object, Object> parameters = new HashMap<>();

    public Map<Object, Object> getParameters() {
        return parameters;
    }

    public abstract void setupUI();
}
