package views;

import controllers.BaseController;

import javax.swing.*;

public final class SecondScreen extends BaseScreen {

    public SecondScreen(BaseController controller) {
        super(controller);
    }

    @Override
    protected void initComponents() {
        setLayout(null);
        JLabel button = new JLabel("open");
        button.setBounds(100, 100, 200, 50);
        add(button);
    }
}
