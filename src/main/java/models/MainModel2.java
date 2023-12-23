package models;

import actions.Actions;
import views.BaseScreen;

import javax.swing.*;
import java.awt.*;

public class MainModel2 extends BaseModel{

    public MainModel2(BaseScreen screen) {
        super(screen);
    }

    @Override
    public void execute() {
        screen.getComponentByName(Actions.OPEN_WINDOW.name()).setBackground(Color.green);
    }
}
