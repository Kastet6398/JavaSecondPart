package controllers;

import actions.Actions;
import models.BaseModel;
import models.SecondModelChangeColorToGreen;
import views.SecondScreen;

import javax.swing.JComponent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class SecondController extends BaseController implements MouseListener {
    private final BaseModel model;

    public SecondController(BaseController controller) {
        screen = new SecondScreen(this);
        model = new SecondModelChangeColorToGreen(controller.getScreen());
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (Objects.equals(((JComponent) e.getSource()).getName(), Actions.CHANGE_COLOR.name())) {
            model.execute();
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
