package controllers;

import actions.Actions;
import models.BaseModel;
import models.MainModel1;
import views.MainScreen;

import javax.swing.JComponent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class MainController extends BaseController implements MouseListener {
    private final BaseModel model;

    public MainController() {
        screen = new MainScreen(this);
        model = new MainModel1(screen);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (Objects.equals(((JComponent) e.getSource()).getName(), Actions.OPEN_WINDOW.name())) {
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
