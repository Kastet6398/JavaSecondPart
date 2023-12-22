package models;

import enums.Names;
import views.BaseScreen;

import javax.swing.*;

public final class MainModelInsert extends BaseModel {
    public MainModelInsert(BaseScreen screen) {
        super(screen);
    }

    @Override
    public void execute() {
        ((JTextField) screen.getComponentByName(Names.TEXT_FIELD.name())).setText("");
    }
}
