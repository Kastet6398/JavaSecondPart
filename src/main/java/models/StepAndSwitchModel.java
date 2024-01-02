package models;

import actions.Names;
import tools.Tools;
import views.BaseView;

import javax.swing.*;

public class StepAndSwitchModel extends BaseModel{

    public StepAndSwitchModel(BaseView view) {
        super(view);
        hero = (JLabel) view.getComponentByName(Names.LBL_HERO.name());
    }
    JLabel hero;

    @Override
    public synchronized void execute() {
        for (int i = 0; i < Tools.images.size() - 1; i++) {
            hero.setIcon(new ImageIcon(Tools.images.get(i)));
            step();
        }
        hero.setIcon(new ImageIcon(Tools.images.getLast()));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void step() {
        for (int j = 0; j < 100 / Tools.images.size(); j++) {
            hero.setBounds(hero.getX() + 1, hero.getY(), hero.getWidth(), hero.getHeight());
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
