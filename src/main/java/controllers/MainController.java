package controllers;

import actions.Actions;
import models.MainModel;
import models.MainModel2;
import views.MainScreen;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class MainController extends BaseController {
    private final MainModel model;
    private final MainModel2 model2;

    public MainController() {
        screen = new MainScreen(this);
        model = new MainModel(screen);
        model2 = new MainModel2(screen);
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
