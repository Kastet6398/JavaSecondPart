package com.kastet6398.myapplication.models;

import androidx.annotation.NonNull;

import com.kastet6398.myapplication.annotations.UtilityClass;
import com.kastet6398.myapplication.annotations.DoNotUseThisConstructor;

import org.jetbrains.annotations.Contract;
import org.apache.commons.math3.complex.Complex;
import java.util.Objects;

@UtilityClass
public final class Calculator {
    @DoNotUseThisConstructor
    private Calculator() {
        throw new AssertionError("Instantiation of utility class 'Calculator'");
    }

    private static void moveToNextCharInExpression(@NonNull String expression, @NonNull int[] currentPositionAndChar) {
        currentPositionAndChar[1] = (++currentPositionAndChar[0] < expression.length()) ? expression.charAt(currentPositionAndChar[0]) : -1;
    }

    private static boolean doesCurrentCharMatch(int expectedChar, String expression, @NonNull int[] currentPositionAndChar) {
        if (currentPositionAndChar[1] == expectedChar) {
            moveToNextCharInExpression(expression, currentPositionAndChar);
            return true;
        }
        return false;
    }

    private static Complex parseExpression(String expression, int[] currentPositionAndChar) {
        Complex result = parseTerm(expression, currentPositionAndChar);
        for (; ; ) {
            if (doesCurrentCharMatch('+', expression, currentPositionAndChar))
                result = result.add(parseTerm(expression, currentPositionAndChar));
            else if (doesCurrentCharMatch('-', expression, currentPositionAndChar))
                result = result.subtract(parseTerm(expression, currentPositionAndChar));
            else return result;
        }
    }

    private static Complex parseTerm(String expression, int[] currentPositionAndChar) {
        Complex result = parseFactor(expression, currentPositionAndChar);
        for (; ; ) {
            if (doesCurrentCharMatch('*', expression, currentPositionAndChar))
                result = result.multiply(parseFactor(expression, currentPositionAndChar));
            else if (doesCurrentCharMatch('/', expression, currentPositionAndChar))
                result = result.divide(parseFactor(expression, currentPositionAndChar));
            else return result;
        }
    }

    private static Complex parseFactor(String expression, int[] currentPositionAndChar) {
        if (doesCurrentCharMatch('+', expression, currentPositionAndChar))
            return parseFactor(expression, currentPositionAndChar);
        if (doesCurrentCharMatch('-', expression, currentPositionAndChar))
            return Complex.ONE.negate().multiply(parseFactor(expression, currentPositionAndChar));

        Complex result;
        int startPosition = currentPositionAndChar[0];
        if (doesCurrentCharMatch('(', expression, currentPositionAndChar)) {
            result = parseExpression(expression, currentPositionAndChar);
            if (!doesCurrentCharMatch(')', expression, currentPositionAndChar))
                throw new RuntimeException("Missing ')'");
        } else if ((currentPositionAndChar[1] >= '0' && currentPositionAndChar[1] <= '9') || currentPositionAndChar[1] == '.') {
            while ((currentPositionAndChar[1] >= '0' && currentPositionAndChar[1] <= '9') || currentPositionAndChar[1] == '.')
                moveToNextCharInExpression(expression, currentPositionAndChar);
            result = Complex.valueOf(Double.parseDouble(expression.substring(startPosition, currentPositionAndChar[0])));
        } else if (currentPositionAndChar[1] >= 'a' && currentPositionAndChar[1] <= 'z') {
            while (currentPositionAndChar[1] >= 'a' && currentPositionAndChar[1] <= 'z')
                moveToNextCharInExpression(expression, currentPositionAndChar);

            String functionOrConstant = expression.substring(startPosition, currentPositionAndChar[0]);

            if (Constants.CONSTANTS.containsKey(functionOrConstant))
                result = Constants.CONSTANTS.get(functionOrConstant);
            else {
                result = parseFactor(expression, currentPositionAndChar);
                if (result == null)
                    throw new RuntimeException("Undefined constant.");
                else if (Constants.FUNCTIONS.containsKey(functionOrConstant))
                    result = Objects.requireNonNull(Constants.FUNCTIONS.get(functionOrConstant)).call(result);
                else throw new RuntimeException("Undefined function.");
            }

        } else throw new RuntimeException("Unexpected character");

        if (doesCurrentCharMatch('^', expression, currentPositionAndChar)) {
            result = Objects.requireNonNull(result).pow(parseFactor(expression, currentPositionAndChar));
        }

        return result;
    }

    @NonNull
    @Contract("_ -> new")
    public static Complex calculate(String expression) {
        expression = expression.replaceAll("([\\d)])i(\\b)", "$1*i$2").replaceAll("\\s+", "").toLowerCase();
        return parse(expression);
    }

    private static Complex parse(@NonNull String expression) {
        if (expression.isEmpty()) {
            throw new RuntimeException("Expression is empty.");
        }

        int[] currentPositionAndChar = {-1, -1};
        moveToNextCharInExpression(expression, currentPositionAndChar);

        Complex result = parseExpression(expression, currentPositionAndChar);

        if (currentPositionAndChar[0] < expression.length()) {
            throw new RuntimeException("Unexpected: " + currentPositionAndChar[1]);
        }

        return result;
    }
}
