package models;

import views.BaseScreen;

public abstract class BaseModel {
    protected final BaseScreen screen;
    protected Object arg;

    public BaseModel(BaseScreen screen) {
        this.screen = screen;
    }

    public abstract void execute();

    public void setArg(Object arg) {
        this.arg = arg;
    }
}
