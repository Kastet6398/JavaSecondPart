package views;

import actions.Names;
import controllers.BaseController;
import tools.Tools;

import javax.swing.*;

public final class MainView extends BaseView {

    public MainView(BaseController controller) {
        super(controller);
    }

    @Override
    protected void initComponents() {
        setLayout(null);
        JLabel picLabel = new JLabel(new ImageIcon(Tools.images.getFirst()));
        picLabel.setName(Names.LBL_HERO.name());
        picLabel.setBounds(0, 0, Tools.images.getFirst().getWidth(), Tools.images.getFirst().getHeight());
        add(picLabel);
    }
}
