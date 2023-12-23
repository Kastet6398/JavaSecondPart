package models;

import actions.Actions;
import views.BaseScreen;

import java.awt.*;

public class SecondModelChangeColorToGreen extends BaseModel{

    public SecondModelChangeColorToGreen(BaseScreen screen) {
        super(screen);
    }

    @Override
    public void execute() {
        screen.getComponentByName(Actions.OPEN_WINDOW.name()).setBackground(Color.green);
    }
}
