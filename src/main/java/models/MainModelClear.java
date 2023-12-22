package models;

import enums.Names;
import tools.Calculator;
import views.BaseScreen;

import javax.swing.*;

public final class MainModelClear extends BaseModel {
    public MainModelClear(BaseScreen screen) {
        super(screen);
    }

    @Override
    public void execute() {
        ((JTextField) screen.getComponentByName(Names.TEXT_FIELD.name())).setText("");
    }
}
