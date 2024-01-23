package com.example.fff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntToRomanTest {
    @Test
    void testConvert3947() {
        assertEquals("MMMCMXLVII", IntToRoman.intToRoman(3947));
    }
    @Test
    void testConvertNegative() {
        for (int i = -3999; i < 0; i++) {
            assertNull(IntToRoman.intToRoman(i));
        }
    }
    @Test
    void testConvert0() {
        assertNull(IntToRoman.intToRoman(0));
    }
    @Test
    public void testConvert99() {
        assertEquals("XCIX", IntToRoman.intToRoman(99));
    }
    @Test
    public void testConvert49() {
        assertEquals("XLIX", IntToRoman.intToRoman(49));
    }

    @Test
    public void testConvert50() {
        assertEquals("L", IntToRoman.intToRoman(50));
    }
    @Test
    public void testConvert3999() {
        assertEquals("MMMCMXCIX", IntToRoman.intToRoman(3999));
    }
}
