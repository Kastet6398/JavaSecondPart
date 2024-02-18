package com.kastet6398.myapplication.models;

import org.apache.commons.math3.complex.Complex;

public final class Constants {
    public static final String DECIMAL_FORMAT = "#.#####";
    public static final String DECIMAL_REGEX = "-?\\d+(\\.\\d+)?";
    public static final java.util.Map<String, Complex> CONSTANTS = new java.util.HashMap<>();
    public static final java.util.Map<String, Function> FUNCTIONS = new java.util.HashMap<>();

    static {
        CONSTANTS.put("pi", Complex.valueOf(Math.PI));
        CONSTANTS.put("e", Complex.valueOf(Math.E));
        CONSTANTS.put("i", Complex.I);
        CONSTANTS.put("inf", Complex.INF);
        CONSTANTS.put("nan", Complex.NaN);

        FUNCTIONS.put("sin", Complex::sin);
        FUNCTIONS.put("cos", Complex::cos);
        FUNCTIONS.put("tan", Complex::tan);
        FUNCTIONS.put("abs", x -> new Complex(x.abs()));
        FUNCTIONS.put("asin", Complex::asin);
        FUNCTIONS.put("acos", Complex::acos);
        FUNCTIONS.put("conjugate", Complex::conjugate);
        FUNCTIONS.put("sinh", Complex::sinh);
        FUNCTIONS.put("cosh", Complex::cosh);
        FUNCTIONS.put("tanh", Complex::tanh);
        FUNCTIONS.put("reciprocal", Complex::reciprocal);
        FUNCTIONS.put("atan", Complex::atan);
        FUNCTIONS.put("sqrt", Complex::sqrt);
        FUNCTIONS.put("log", Complex::log);
    }
}
