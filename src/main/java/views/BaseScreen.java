package views;

import javax.swing.*;

public abstract class BaseScreen extends JFrame {
    protected abstract void initComponents();
    public BaseScreen() {
        setTitle("Main Screen");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
    }
}
