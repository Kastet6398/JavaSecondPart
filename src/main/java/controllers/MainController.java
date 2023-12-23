package controllers;

import actions.Actions;
import models.BaseModel;
import models.MainModel1;
import views.MainScreen;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class MainController extends BaseController {
    private final BaseModel model;

    public MainController() {
        screen = new MainScreen(this);
        model = new MainModel1(screen);
        model.setArg(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (Objects.equals(((JComponent) e.getSource()).getName(), Actions.OPEN_WINDOW.name())) {
            model.execute();
        }
    }
}
