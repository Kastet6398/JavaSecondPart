package models;

import enums.Names;
import tools.Calculator;
import views.BaseScreen;

import javax.swing.*;

public final class MainModelCalculate extends BaseModel {
    public MainModelCalculate(BaseScreen screen) {
        super(screen);
    }

    @Override
    public void execute() {
        JTextField expressionField = (JTextField) screen.getComponentByName(Names.EXPRESSION_FIELD.name());
        JTextField resultField = (JTextField) screen.getComponentByName(Names.RESULT_FIELD.name());

        String expression = expressionField.getText();
        String result = Calculator.calculate(expression);

        expressionField.requestFocus();
        resultField.setText(result);
        resultField.setCaretPosition(0);
    }
}
