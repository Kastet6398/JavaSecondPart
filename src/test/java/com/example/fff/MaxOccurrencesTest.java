package com.example.fff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxOccurrencesTest {
    @Test
    public void mostPopularNumberTestCase1() {
        assertEquals(73, MaxOccurrences.mostPopularNumber(new int[] { 1, 9, 73, 74, 72, 10, 85, 73, 84, 13, 10, 4 }));
    }
    @Test
    public void mostPopularNumberTestCase2() {
        assertEquals(74, MaxOccurrences.mostPopularNumber(new int[] { 83, 74, 27, 94, 17, 81, 47, 74, 74, 47, 90 }));
    }
    @Test
    public void mostPopularNumberNotFound() {
        assertEquals(-1, MaxOccurrences.mostPopularNumber(new int[0]));
    }
}
