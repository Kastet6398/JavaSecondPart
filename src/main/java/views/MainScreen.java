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
        JButton button = new JButton("open");
        button.setName(Actions.OPEN_WINDOW.name());
        button.setBounds(100, 100, 200, 50);
        button.addMouseListener(controller);
        add(button);
    }
}
