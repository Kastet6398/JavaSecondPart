package models;

import controllers.SecondController;
import views.BaseView;

public final class OpenSecondViewModel extends BaseModel {
    public OpenSecondViewModel(BaseView view) {
        super(view);
    }

    @Override
    public void execute() {
        new SecondController(view.getController());
    }
}
