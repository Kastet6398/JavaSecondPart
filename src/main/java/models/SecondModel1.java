package models;

import controllers.BaseController;
import controllers.SecondController;
import views.BaseScreen;

public final class SecondModel1 extends BaseModel {
    public SecondModel1(BaseScreen screen) {
        super(screen);
    }

    @Override
    public void execute() {
        new MainModel2(((BaseController) arg).getScreen()).execute();
    }
}
