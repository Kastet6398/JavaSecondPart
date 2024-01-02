package models;

import actions.Names;
import views.BaseView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class SwitchHeroModel extends BaseModel{

    public SwitchHeroModel(BaseView view) {
        super(view);
    }

    @Override
    public synchronized void execute() {
        JLabel hero = (JLabel) view.getComponentByName(Names.LBL_HERO.name());
        try {
            hero.setIcon(new ImageIcon(ImageIO.read(new File("hero-2.png"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            hero.setIcon(new ImageIcon(ImageIO.read(new File("hero.png"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
