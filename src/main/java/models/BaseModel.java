package models;

import views.BaseView;

public abstract class BaseModel {
    protected final BaseView view;
    public BaseModel(BaseView view) {
        this.view = view;
    }

    public abstract void execute();
}
