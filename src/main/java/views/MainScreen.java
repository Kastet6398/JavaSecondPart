package views;

import actions.Actions;
import controllers.BaseController;

import javax.swing.*;

public final class MainScreen extends BaseScreen {

    public MainScreen(BaseController controller) {
        super(controller);
    }

    @Override
    protected void initComponents() {
        setLayout(null);
        JButton button = new JButton("CHANGE");
        button.setName(Actions.CHANGE_TEXT.name());
        button.setBounds(100, 100, 200, 50);
        add(button);

        JButton button2 = new JButton("to uppercase");
        button2.setName(Actions.TO_UPPERCASE.name());
        button2.setBounds(100, 300, 200, 50);
        add(button2);
    }
}
