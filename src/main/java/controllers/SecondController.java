package controllers;

import actions.Names;
import models.BaseModel;
import models.StepAndSwitchModel;
import views.SecondView;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class SecondController extends BaseController implements MouseListener {
    private final BaseModel model;

    public SecondController(BaseController controller) {
        view = new SecondView(this);
        model = new StepAndSwitchModel(controller.getView());
    }


    @Override
    public synchronized void mouseClicked(MouseEvent e) {
        if (Objects.equals(((JComponent) e.getSource()).getName(), Names.BTN_MOVE.name())) {
            Thread thread = new Thread(model::execute);
            thread.start();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
