package views;

import actions.Actions;
import controllers.BaseController;

import javax.swing.*;
import java.awt.event.MouseListener;

public final class SecondScreen extends BaseScreen {

    public SecondScreen(BaseController controller) {
        super(controller);
    }

    @Override
    protected void initComponents() {
        setLayout(null);
        JButton button = new JButton("change");
        button.setName(Actions.CHANGE_COLOR.name());
        button.setBounds(100, 100, 200, 50);
        button.addMouseListener((MouseListener) controller);
        add(button);
    }
}
