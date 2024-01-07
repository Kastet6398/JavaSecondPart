package com.example.demo1.models;

import com.example.demo1.ui.BaseController;

public abstract class BaseModel {
    protected final BaseController controller;
    public BaseModel(BaseController controller) {
        this.controller = controller;
    }
    public abstract Object execute();
}
