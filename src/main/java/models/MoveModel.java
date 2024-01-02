package models;

import actions.Names;
import views.BaseView;

import java.awt.*;

public class MoveModel extends BaseModel{

    public MoveModel(BaseView view) {
        super(view);
    }

    @Override
    public synchronized void execute() {
        for (int i = 0; i < 100; i++) {
            Component hero = view.getComponentByName(Names.LBL_HERO.name());
            hero.setBounds(hero.getX() + 1, hero.getY(), hero.getWidth(), hero.getHeight());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
