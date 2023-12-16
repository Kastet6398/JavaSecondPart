package views;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainScreen extends BaseScreen {
    private final ActionListener actionListener;
    private JButton button;

    public MainScreen(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    @Override
    protected void initComponents() {
        setLayout(null);
        button = new JButton("Start");
        button.setBounds(100, 100, 200, 50);
        button.addActionListener(actionListener);
        add(button);
    }

    @Override
    protected void onState(int state) {
        switch (state) {
            case 0:
                button.setText("NEW!");
                break;
            default:
                throw new IllegalStateException("Illegal state: " + state);
        }
    }
}
