package controllers;

import models.BaseModel;
import models.OpenSecondViewModel;
import views.MainView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainController extends BaseController implements MouseListener {

    public MainController() {
        view = new MainView(this);
        BaseModel model = new OpenSecondViewModel(view);
        model.execute();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
