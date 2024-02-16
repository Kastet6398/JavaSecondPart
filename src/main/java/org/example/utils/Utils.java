package org.example.utils;

import com.ezylang.evalex.Expression;
import com.ezylang.evalex.bigmath.BigMathExpression;
import com.ezylang.evalex.bigmath.operators.bigdecimalmath.BigMathInfixPowerOfOperator;
import com.ezylang.evalex.config.ExpressionConfiguration;
import com.ezylang.evalex.data.EvaluationValue;
import com.ezylang.evalex.functions.AbstractFunction;
import com.ezylang.evalex.functions.FunctionParameter;
import com.ezylang.evalex.operators.OperatorIfc;
import com.ezylang.evalex.parser.Token;

import java.util.List;
import java.util.Map;
public class Utils extends BaseUtils {
    private Utils() {
        super();
    }

    public static String calculate(String expression) {
        try {
            ExpressionConfiguration configuration = ExpressionConfiguration.builder()
                    .decimalPlacesRounding(20)
                    .arraysAllowed(true)
                    .build()
                    .withAdditionalOperators(Map.entry("**", new BigMathInfixPowerOfOperator()))
                    .withAdditionalOperators(Map.entry("++",
                                                       new PrefixPlusPlusOperator()), Map.entry("++",
                                                                                                new PostfixPlusPlusOperator()))
                    .withAdditionalOperators(Map.entry("--",
                                                       new PrefixMinusMinusOperator()), Map.entry("--",
                                                                                                  new PostfixMinusMinusOperator()))
                    .withAdditionalFunctions(Map.entry("PRINT",
                                                       new PrintFunction()))
                    .withAdditionalFunctions(Map.entry("ARRAY",
                                                       new ArrayFunction()));
            return new BigMathExpression(expression, configuration).evaluate().getStringValue();
        } catch (Exception e) {
            return "ERROR";
        }
    }

    private static class PrefixPlusPlusOperator implements OperatorIfc {
        @Override
        public int getPrecedence() {
            return 100;
        }

        @Override
        public boolean isLeftAssociative() {
            return false;
        }

        @Override
        public boolean isPrefix() {
            return true;
        }

        @Override
        public boolean isPostfix() {
            return false;
        }

        @Override
        public boolean isInfix() {
            return false;
        }

        @Override
        public int getPrecedence(ExpressionConfiguration configuration) {
            return 3;
        }

        @Override
        public EvaluationValue evaluate(Expression expression, Token functionToken, EvaluationValue... parameterValues) {
            return expression.convertDoubleValue(parameterValues[0].getNumberValue().doubleValue() + 1.);
        }
    }

    private static class PostfixPlusPlusOperator implements OperatorIfc {
        @Override
        public int getPrecedence() {
            return 100;
        }

        @Override
        public boolean isLeftAssociative() {
            return false;
        }

        @Override
        public boolean isPrefix() {
            return false;
        }

        @Override
        public boolean isPostfix() {
            return true;
        }

        @Override
        public boolean isInfix() {
            return false;
        }

        @Override
        public int getPrecedence(ExpressionConfiguration configuration) {
            return 0;
        }

        @Override
        public EvaluationValue evaluate(Expression expression, Token functionToken, EvaluationValue... parameterValues) {
            return expression.convertDoubleValue(parameterValues[0].getNumberValue().doubleValue() + 1.);
        }
    }

    private static class PrefixMinusMinusOperator implements OperatorIfc {
        @Override
        public int getPrecedence() {
            return 100;
        }

        @Override
        public boolean isLeftAssociative() {
            return false;
        }

        @Override
        public boolean isPrefix() {
            return true;
        }

        @Override
        public boolean isPostfix() {
            return false;
        }

        @Override
        public boolean isInfix() {
            return false;
        }

        @Override
        public int getPrecedence(ExpressionConfiguration configuration) {
            return 0;
        }

        @Override
        public EvaluationValue evaluate(Expression expression, Token functionToken, EvaluationValue... parameterValues) {
            return expression.convertDoubleValue(parameterValues[0].getNumberValue().doubleValue() - 1.);
        }
    }

    private static class PostfixMinusMinusOperator implements OperatorIfc {
        @Override
        public int getPrecedence() {
            return 100;
        }

        @Override
        public boolean isLeftAssociative() {
            return false;
        }

        @Override
        public boolean isPrefix() {
            return false;
        }

        @Override
        public boolean isPostfix() {
            return true;
        }

        @Override
        public boolean isInfix() {
            return false;
        }

        @Override
        public int getPrecedence(ExpressionConfiguration configuration) {
            return 3;
        }

        @Override
        public EvaluationValue evaluate(Expression expression, Token functionToken, EvaluationValue... parameterValues) {
            return expression.convertDoubleValue(parameterValues[0].getNumberValue().doubleValue() - 1.);
        }
    }
    @FunctionParameter(name = "value", isVarArg = true)
    private static class PrintFunction extends AbstractFunction {
        @Override
        public EvaluationValue evaluate(
                Expression expression, Token functionToken, EvaluationValue... parameterValues) {
            for (EvaluationValue parameterValue : parameterValues)
                System.out.println(parameterValue.getStringValue());
            return new EvaluationValue(0);
        }
    }


    @FunctionParameter(name = "value", isVarArg = true)
    private static class ArrayFunction extends AbstractFunction {
        @Override
        public EvaluationValue evaluate(
                Expression expression, Token functionToken, EvaluationValue... parameterValues) {
            Object[] array = new Object[parameterValues.length];
            for (int i = 0; i < parameterValues.length; i++) {
                array[i] = parameterValues[i].getValue();
            }
            return new EvaluationValue(List.of(array));
        }
    }
}
