package controllers;

import views.BaseScreen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;

/**
 * Controllers control a screen (view) by capturing button clicks, etc.
 * Optionally capture keyboard events.
 */
public abstract class BaseController extends MouseAdapter implements KeyListener {
    /**
     * The view that should to be controlled
     */
    protected BaseScreen screen;

    /**
     * Show the view window
     */
    public void start() {
        screen.start();
    }

    /**
     * Close the view window
     */
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
