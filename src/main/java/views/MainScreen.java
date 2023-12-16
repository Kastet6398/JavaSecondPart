package views;

import javax.swing.*;

public class MainScreen extends BaseScreen {
    @Override
    protected void initComponents() {
        setLayout(null);
        JButton button = new JButton("Start");
        button.setBounds(100, 100, 200, 50);
        add(button);
    }
}
