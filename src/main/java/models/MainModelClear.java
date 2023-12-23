package models;

import enums.Names;
import views.BaseScreen;

import javax.swing.*;

public final class MainModelClear extends BaseModel {
    public MainModelClear(BaseScreen screen) {
        super(screen);
    }

    @Override
    public void execute() {
        ((JTextField) screen.getComponentByName(Names.EXPRESSION_FIELD.name())).setText("");
    }
}
