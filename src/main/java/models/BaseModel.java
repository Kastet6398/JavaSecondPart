package models;

import views.BaseScreen;

/**
 * Models specify what to do on {@link actions.Actions action}
 */
public abstract class BaseModel {
    /**
     * A screen (view) that should be controlled.
     */
    protected final BaseScreen screen;
    protected Object arg;

    public BaseModel(BaseScreen screen) {
        this.screen = screen;
    }

    public void setArg(Object arg) {
        this.arg = arg;
    }

    /**
     * Does something when {@link actions.Actions action} received
     */
    public abstract void execute();
}
