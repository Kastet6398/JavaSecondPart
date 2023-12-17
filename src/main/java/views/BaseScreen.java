package views;

import controllers.BaseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

/**
 * Screens (views) are what user sees, i.e. GUI.
 */
public abstract class BaseScreen extends JFrame {
    /**
     * Controller that controls this screen (view)
     */
    protected final BaseController controller;

    /**
     * Initialize components of this screen (view), i.e., create buttons, labels, etc.
     * Used to allow children
     * to add widgets before {@link #addMouseListenerToAllComponents(Container, MouseAdapter)}.
     * Used by constructor {@link #BaseScreen(BaseController)}
     */
    protected abstract void initComponents();

    /**
     * Initialize this screen (view).
     *
     * @param controller the {@link BaseController controller} that controls this screen (view)
     */
    public BaseScreen(BaseController controller) {
        this.controller = controller;
        setTitle("Main Screen");
        setSize(600, 400);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                evt.getWindow().dispose();
            }
        });
        initComponents();
        addMouseListenerToAllComponents(getContentPane(), controller);
    }

    /**
     * Show the window.
     */
    public void start() {
        setVisible(true);
    }

    /**
     * Add mouse listener
     */
    private static void addMouseListenerToAllComponents(Container container, MouseAdapter listener) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof Panel container1)
                addMouseListenerToAllComponents(container1, listener);
            component.addMouseListener(listener);
        }
    }


    /**
     * Search for the element with the given name in the whole screen (view).
     *
     * @param name the name of the element to search for.
     * @return the component with the given name or null if not found.
     */
    public Component getComponentByName(String name) {
        return this.getComponentByName(getContentPane(), name);
    }

    /**
     * Search for the element with the given name in the container ({@link Panel panel}).
     * Used internally by {@link #getComponentByName(String)} for recursion purposes.
     *
     * @param container the container ({@link Panel panel}) where to search for the element
     * @param name      the name of the element to search for.
     * @return the component with the given name or null if not found.
     */
    private Component getComponentByName(Container container, String name) {
        for (Component c : container.getComponents()) {
            if (Objects.equals(c.getName(), name))
                return c;
            if (c instanceof Panel container1)
                return getComponentByName(container1, name);
        }
        return null;
    }

    /**
     * Closes the view window.
     */
    public void stop() {
        dispose();
    }
}
