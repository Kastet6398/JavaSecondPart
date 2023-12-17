package views;

import controllers.BaseController;
import listeners.ExitListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public abstract class BaseScreen extends JFrame {
    protected final BaseController controller;

    protected abstract void initComponents();

    public BaseScreen(BaseController controller) {
        this.controller = controller;
    }

    public void start() {
        setTitle("Main Screen");
        setSize(600, 400);
        setLocationRelativeTo(null);
        addWindowListener(new ExitListener());
        initComponents();
        addMouseListenerToAllComponents(getContentPane(), controller);
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
        return this.getComponent(getContentPane(), name);
    }

    private Component getComponent(Container container, String name) {
        for (Component c : container.getComponents()) {
            if (Objects.equals(c.getName(), name))
                return c;
            if (c instanceof Panel container1)
                return getComponent(container1, name);
        }
        return null;
    }

    public void stop() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
