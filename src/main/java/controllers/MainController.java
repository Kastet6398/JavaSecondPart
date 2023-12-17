package controllers;

import actions.Actions;
import models.MainModelChangeText;
import models.MainModelToUppercase;
import views.MainScreen;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class MainController extends BaseController {
    private final MainModelChangeText model;
    private final MainModelToUppercase model2;

    public MainController() {
        screen = new MainScreen(this);
        model = new MainModelChangeText(screen);
        model2 = new MainModelToUppercase(screen);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            switch (Actions.valueOf(((JComponent) e.getSource()).getName())) {
                case CHANGE_TEXT:
                    model.execute();
                    break;
                case TO_UPPERCASE:
                    model2.execute();
                    break;
            }
        } catch (IllegalArgumentException ignored) {}
    }
}
