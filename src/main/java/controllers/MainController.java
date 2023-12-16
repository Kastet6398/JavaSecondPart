package controllers;

import views.BaseScreen;
import views.MainScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {
    private BaseScreen screen;
    public MainController() {
        System.out.println("MainController");
    }

    public void createView() {
        screen = new MainScreen(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("MainController actionPerformed");
    }
}
