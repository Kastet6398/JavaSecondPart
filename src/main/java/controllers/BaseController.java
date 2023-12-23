package controllers;

import views.BaseScreen;

public abstract class BaseController {
    protected BaseScreen screen;
    public BaseScreen getScreen() {
        return screen;
    }
}
