package models;

import controllers.BaseController;
import controllers.SecondController;
import views.BaseScreen;

public final class MainModel1 extends BaseModel {
    public MainModel1(BaseScreen screen) {
        super(screen);
    }

    @Override
    public void execute() {
        new SecondController(screen.getController());
    }
}
