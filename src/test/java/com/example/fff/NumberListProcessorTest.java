package com.example.fff;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberListProcessorTest {
    NumberListProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new NumberListProcessor();
        processor.addNumber(10);
        processor.addNumber(19);
        processor.addNumber(763);
        processor.addNumber(-362);
        processor.addNumber(947);
        processor.addNumber(-3);
    }

    @Test
    void processSumOfEvenNumbers() {
        assertEquals(-352, processor.processSumOfEvenNumbers());
    }

    @Test
    void processMultiplicationBy2() {
        assertEquals(List.of(20, 38, 1526, -724, 1894, -6), processor.processMultiplicationBy2());
    }

    @Test
    void processMaximumNumber() {
        assertEquals(947, processor.processMaximumNumber());
    }

    @Test
    void processOddNumbersAsString() {
        assertEquals("19, 763, 947, -3", processor.processOddNumbersAsString());
    }

    @Test
    void processAverage() {
        assertEquals(229, processor.processAverage());
    }
}
