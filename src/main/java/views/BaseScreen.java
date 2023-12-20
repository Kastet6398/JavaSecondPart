package views;

import controllers.BaseController;

import javax.swing.*;

public abstract class BaseScreen extends JFrame {
    protected final BaseController controller;
    protected abstract void initComponents();
    public BaseScreen(BaseController controller) {
        this.controller = controller;
        setTitle("Main Screen");
        setSize(600, 400);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }
}
