package org.example.utils;

public abstract class BaseUtils {
    protected BaseUtils() {
        throw new IllegalStateException(STR."Instantiation of utility class '\{getClass().getSimpleName()}'");
    }
}
