package com.example.demo4.models;

import com.example.demo4.ui.BaseController;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseModel<T> {
    protected final Map<String, Object> args = new HashMap<>();
    public void setArg(String key, Object value) {
        if (args.containsKey(key)) args.replace(key, value);
        else args.put(key, value);
    }
    protected final BaseController controller;
    public BaseModel(BaseController controller) {
        this.controller = controller;
    }
    public abstract T execute();
}
