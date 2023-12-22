package controllers;

import views.BaseScreen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;

public abstract class BaseController extends MouseAdapter implements KeyListener {
    protected BaseScreen screen;

    public void start() {
        screen.start();
    }

    public void stop() {
        screen.stop();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
