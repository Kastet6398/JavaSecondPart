package models;

import views.BaseScreen;

public abstract class BaseModel {
    protected final BaseScreen screen;
    public BaseModel(BaseScreen screen) {
        this.screen = screen;
    }
    public abstract void execute();
}
