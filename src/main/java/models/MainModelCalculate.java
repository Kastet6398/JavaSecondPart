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
        String expression = ((JTextField) screen.getComponentByName(Names.TEXT_FIELD.name())).getText();
        String result = Calculator.calculate(expression);
        ((JTextField) screen.getComponentByName(Names.RESULT.name())).setText(result);
    }
}
