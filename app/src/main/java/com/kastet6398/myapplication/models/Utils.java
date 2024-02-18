package com.kastet6398.myapplication.models;

import androidx.annotation.NonNull;

import com.kastet6398.myapplication.annotations.DoNotUseThisConstructor;
import com.kastet6398.myapplication.annotations.UtilityClass;

import org.apache.commons.math3.complex.Complex;

@UtilityClass
public class Utils {
    @DoNotUseThisConstructor
    private Utils() {
        throw new AssertionError("Instantiation of utility class 'Utils'");
    }
    @NonNull
    public static String roundNumbersInString(String input) {

        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(Constants.DECIMAL_REGEX).matcher(input);

        StringBuffer result = new StringBuffer();


        while (matcher.find()) {
            matcher.appendReplacement(result, new java.text.DecimalFormat(Constants.DECIMAL_FORMAT).format(Double.parseDouble(matcher.group())));
        }

        matcher.appendTail(result);

        return result.toString();
    }

    @NonNull
    public static String formatComplex(@NonNull Complex value) {
        String resultString = ((value.getReal() != 0 ? value.getReal() + (!(value.getImaginary() <= 0) ? " + " : "") : "") + (value.getImaginary() != 0 ? value.getImaginary() + " * i" : ""))
                .replaceAll("--", "-")
                .replaceAll("-\\+", "-")
                .replaceAll("\\+-", "-")
                .replaceAll("--", "-");
        if (resultString.isEmpty()) return "0";
        return roundNumbersInString(resultString);
    }
}
