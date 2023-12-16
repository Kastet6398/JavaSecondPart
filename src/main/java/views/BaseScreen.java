package views;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class BaseScreen extends JFrame {
    protected abstract void initComponents();
    public BaseScreen() {
        setTitle("Main Screen");
        setSize(600, 400);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
        initComponents();
        setVisible(true);
    }
}
