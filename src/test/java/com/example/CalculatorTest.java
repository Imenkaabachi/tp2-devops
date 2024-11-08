package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(3, calculator.add(1, 2));
    }

    @Test
    public void testSubtract() {
        assertEquals(3, calculator.subtract(5, 2));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(3, 2));
    }

    @Test
    public void testDivide() {
        assertEquals(3, calculator.divide(6, 2));
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
    @Test
    public void testSquare() {
        assertEquals(9, calculator.square(3));
        assertEquals(0, calculator.square(0));
        assertEquals(16, calculator.square(-4));
    }

    @Test
    public void testPower() {
        assertEquals(8, calculator.power(2, 3));
        assertEquals(1, calculator.power(5, 0));  // any number to the power of 0 is 1
        assertEquals(16, calculator.power(-4, 2)); // negative base with an even exponent
    }

    @Test
    public void testAbsoluteValue() {
        assertEquals(5, calculator.absoluteValue(5));
        assertEquals(5, calculator.absoluteValue(-5));
        assertEquals(0, calculator.absoluteValue(0));
    }

    @Test
    public void testRacineCarree() {
        assertEquals(3.0, calculator.racineCarree(9), 0.001);
        assertEquals(0.0, calculator.racineCarree(0), 0.001);
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.racineCarree(-4);
        });
        assertEquals("Cannot calculate the square root of a negative number", exception.getMessage());
    }
}
