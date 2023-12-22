package controllers;

import enums.Names;
import models.*;
import views.MainScreen;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class MainController extends BaseController {
    private final BaseModel model;
    private final BaseModel model2;
    private final BaseModel model3;
    private final BaseModel model4;

    public MainController() {
        screen = new MainScreen(this);
        model = new MainModelCalculate(screen);
        model2 = new MainModelClear(screen);
        model3 = new MainModelInsert(screen);
        model4 = new MainModelBack(screen);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String name = ((JComponent) e.getSource()).getName();
        if (Objects.equals(name, Names.CALCULATE.name()))
            model.execute();
        else if (Objects.equals(name, Names.CLEAR.name()))
            model2.execute();
        else if (Objects.equals(name, Names.BACK.name()))
            model4.execute();
        else if (name.startsWith("ins")) {
            model3.setArg(name.substring(3));
            model3.execute();
        }
    }
}
