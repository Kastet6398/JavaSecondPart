package views;

import controllers.BaseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public abstract class BaseScreen extends JFrame {
    protected final BaseController controller;

    protected abstract void initComponents();

    public BaseScreen(BaseController controller, String title, int width, int height) {
        this.controller = controller;
        setTitle(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                evt.getWindow().dispose();
            }
        });
        initComponents();
        addMouseListenerToAllComponents(getContentPane(), controller);
    }

    public void start() {
        setVisible(true);
    }

    private static void addMouseListenerToAllComponents(Container container, MouseAdapter listener) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof Panel container1)
                addMouseListenerToAllComponents(container1, listener);
            component.addMouseListener(listener);
        }
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

    public void stop() {
        dispose();
    }
}
