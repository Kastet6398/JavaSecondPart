package views;

import controllers.MainController;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainScreen extends BaseScreen {
    private ActionListener actionListener;

    public MainScreen(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    @Override
    protected void initComponents() {
        setLayout(null);
        JButton button = new JButton("Start");
        button.setBounds(100, 100, 200, 50);
        button.addActionListener(actionListener);
        add(button);
    }
}
