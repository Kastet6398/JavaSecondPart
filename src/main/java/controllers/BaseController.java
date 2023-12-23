package controllers;

import views.BaseScreen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
public abstract class BaseController extends MouseAdapter {
    protected BaseScreen screen;
    public BaseScreen getScreen() {
        return screen;
    }
}
