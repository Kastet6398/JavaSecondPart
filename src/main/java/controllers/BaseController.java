package controllers;

import views.BaseView;

public abstract class BaseController {
    protected BaseView view;
    public BaseView getView() {
        return view;
    }
}
