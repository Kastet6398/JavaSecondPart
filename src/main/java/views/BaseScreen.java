package views;

import listeners.ExitListener;

import javax.swing.*;

public abstract class BaseScreen extends JFrame {
    protected abstract void initComponents();
    protected abstract void onState(int state);

    public BaseScreen() {
        setTitle("Main Screen");
        setSize(600, 400);
        setLocationRelativeTo(null);
        addWindowListener(new ExitListener());
        initComponents();
        setVisible(true);
    }
}
