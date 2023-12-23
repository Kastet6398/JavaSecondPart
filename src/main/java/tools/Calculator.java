package tools;

import org.mariuszgromada.math.mxparser.*;

import java.io.Serial;

public final class Calculator {
    static {
        License.iConfirmNonCommercialUse("ADDEWFIEWJFWNE");
    }

    public static String calculate(String expression) {
        Expression expression1 = new Expression(expression, new Function("print", new Print()));
        if (!(expression1.checkSyntax() || expression1.checkLexSyntax())) {
            return expression1.getErrorMessage();
        }
        return "" + expression1.calculate();
    }

    static class Print implements FunctionExtensionVariadic {
        @Serial
        private static final long serialVersionUID = -1825198737392316170L;

        public double calculate(double... parameters) {
            for (double x : parameters)
                System.out.println(x);
            return 0;
        }

        public FunctionExtensionVariadic clone() {
            return new Print();
        }
    }
}