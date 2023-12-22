package tools;

import com.ezylang.evalex.Expression;

public class Calculator {
    public static String calculate(String expression) {
        try {
            return new Expression(expression).evaluate().getStringValue();
        } catch (Exception e) {
            return "ERROR";
        }
    }
}
