package models;

import enums.Names;
import views.BaseScreen;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.util.Objects;

public final class MainModelInsert extends BaseModel {
    public MainModelInsert(BaseScreen screen) {
        super(screen);
    }

    @Override
    public void execute() {
        JTextField textField = (JTextField) screen.getComponentByName(Names.EXPRESSION_FIELD.name());
        textField.requestFocus();

        try {
            if (Objects.equals(arg, "()")) {
                insertTextAtCaretPosition(textField, "(");
                if (!isClosingParenthesisNext(textField)) {
                    insertTextAtCaretPosition(textField, ")");
                    moveCaretPosition(textField, -1);
                }
            } else if (shouldInsertText(textField))
                insertTextAtCaretPosition(textField, (String) arg);
            else
                moveCaretPosition(textField, +1);
        } catch (BadLocationException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean shouldInsertText(JTextField textField) {
        return !(Objects.equals(arg, ")") && isClosingParenthesisNext(textField));
    }

    private boolean isClosingParenthesisNext(JTextField textField) {
        return textField.getText().length() > textField.getCaretPosition() &&
                textField.getText().charAt(textField.getCaretPosition()) == ')';
    }

    private void insertTextAtCaretPosition(JTextField textField, String text) throws BadLocationException {
        textField.getDocument().insertString(textField.getCaretPosition(), text, null);
        if (text.endsWith("()")) {
            textField.setCaretPosition(textField.getCaretPosition() - 1);
        }
    }

    private void moveCaretPosition(JTextField textField, int index) {
        textField.setCaretPosition(textField.getCaretPosition() + index);
    }
}
