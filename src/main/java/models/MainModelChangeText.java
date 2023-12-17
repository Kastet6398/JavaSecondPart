package models;

import actions.Actions;
import views.BaseScreen;

import javax.swing.*;

public final class MainModelChangeText extends BaseModel {
    public MainModelChangeText(BaseScreen screen) {
        super(screen);
    }
    @Override
    public void execute() {
        ((JButton) screen.getComponentByName(Actions.CHANGE_TEXT.name())).setText("new!!!");
    }
}
