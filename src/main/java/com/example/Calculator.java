package com.example;

public class Calculator implements CalculatorInterface{
    public int add(int a, int b) {
        return a + b;
    }
  

    
    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
    @Override
    public int square(int a) {
        return a * a;
    }

    @Override
    public int power(int a, int b) {
        return (int) Math.pow(a, b);
    }

    @Override
    public int absoluteValue(int a) {
        return Math.abs(a);
    }

    @Override
    public double racineCarree(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot calculate the square root of a negative number");
        }
        return Math.sqrt(a);
    }

}
