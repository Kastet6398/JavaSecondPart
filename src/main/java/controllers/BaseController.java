package controllers;

import views.BaseScreen;

import java.awt.event.MouseAdapter;

public abstract class BaseController extends MouseAdapter {
    protected BaseScreen screen;
    public void start() {
        screen.start();
    }
    public void stop() {
        screen.stop();
    }
}
