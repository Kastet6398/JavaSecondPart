package models;

import controllers.SecondController;
import views.BaseScreen;

public final class MainModel1 extends BaseModel {
    public MainModel1(BaseScreen screen) {
        super(screen);
    }

    @Override
    public void execute() {
        new SecondController(arg);
    }
}
