package listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public final class ExitListener extends WindowAdapter {
    public void windowClosing(WindowEvent evt) {
        evt.getWindow().dispose();
    }
}