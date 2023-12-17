package models;

import actions.Actions;
import views.BaseScreen;

import javax.swing.*;

public final class MainModel2 extends BaseModel {
    public MainModel2(BaseScreen screen) {
        super(screen);
    }
    @Override
    public void execute() {
        JLabel label = new JLabel("MODEL2");
        label.setBounds(10, 200, 100, 100);
        screen.add(label);
        screen.repaint();
        JButton button = (JButton) screen.getComponentByName(Actions.TO_UPPERCASE.name());
        button.setText(button.getText().toUpperCase());
    }
}
