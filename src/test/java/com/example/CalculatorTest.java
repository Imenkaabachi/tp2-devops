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
}
