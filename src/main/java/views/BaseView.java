package views;

import controllers.BaseController;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public abstract class BaseView extends JFrame {
    protected final BaseController controller;

    public BaseController getController() {
        return controller;
    }

    protected abstract void initComponents();
    public BaseView(BaseController controller) {
        this.controller = controller;
        setTitle("Main Screen");
        setSize(600, 400);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }
    public Component getComponentByName(String name) {
        return this.getComponentByName(getContentPane(), name);
    }

    private Component getComponentByName(Container container, String name) {
        for (Component c : container.getComponents()) {
            if (Objects.equals(c.getName(), name))
                return c;
            if (c instanceof Panel container1)
                return getComponentByName(container1, name);
        }
        return null;
    }
}
