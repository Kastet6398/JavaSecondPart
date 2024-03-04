package com.example.keytyper.models;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseModel {
    public abstract void execute();
    private final Map<Object, Object> parameters = new HashMap<>();

    public synchronized Map<Object, Object> getParameters() {
        return parameters;
    }

}
