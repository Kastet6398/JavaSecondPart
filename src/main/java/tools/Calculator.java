import net.objecthunter.exp4j.ExpressionBuilder;

public class Calculator {
    public static double calculate(String expression) {
        return new ExpressionBuilder(expression).build().evaluate();
    }
}
