package controllers;

import actions.Actions;
import models.BaseModel;
import models.SecondModel1;
import views.SecondScreen;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class SecondController extends BaseController {
    private final BaseModel model;

    public SecondController(Object arg) {
        screen = new SecondScreen(this);
        model = new SecondModel1(screen);
        model.setArg(arg);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (Objects.equals(((JComponent) e.getSource()).getName(), Actions.CHANGE_COLOR.name())) {
            model.execute();
        }
    }
}
