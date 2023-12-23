package models;

import enums.Names;
import views.BaseScreen;

import javax.swing.*;
import javax.swing.text.BadLocationException;

public class MainModelBack extends BaseModel {
    public MainModelBack(BaseScreen screen) {
        super(screen);
    }

    @Override
    public void execute() {
        JTextField textField = (JTextField) screen.getComponentByName(Names.EXPRESSION_FIELD.name());
        try {
            textField.getDocument().remove(textField.getCaretPosition() - 1, 1);
        } catch (StringIndexOutOfBoundsException | BadLocationException ignored) {
        }
    }
}
