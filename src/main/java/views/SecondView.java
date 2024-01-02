package views;

import actions.Names;
import controllers.BaseController;

import javax.swing.*;
import java.awt.event.MouseListener;

public final class SecondView extends BaseView {

    public SecondView(BaseController controller) {
        super(controller);
    }

    @Override
    protected void initComponents() {
        setLayout(null);
        JButton button = new JButton("move");
        button.setName(Names.BTN_MOVE.name());
        button.setBounds(100, 100, 200, 50);
        button.addMouseListener((MouseListener) controller);
        add(button);
    }
}
