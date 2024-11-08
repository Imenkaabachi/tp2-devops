package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {

    private final Calculator calculator = new Calculator();
    private final JTextField display = new JTextField();

    public CalculatorGUI() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 20));
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+",
            "Sq", "Pow", "Abs", "√"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    private int getDisplayValue() {
        return Integer.parseInt(display.getText());
    }

    private void setDisplayValue(String value) {
        display.setText(value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        try {
            switch (command) {
                case "C":
                    setDisplayValue("");
                    break;
                case "=":
                    // This could be extended for multi-step calculations
                    break;
                case "+":
                    int sum = calculator.add(getDisplayValue(), getDisplayValue());
                    setDisplayValue(String.valueOf(sum));
                    break;
                case "-":
                    int diff = calculator.subtract(getDisplayValue(), getDisplayValue());
                    setDisplayValue(String.valueOf(diff));
                    break;
                case "*":
                    int prod = calculator.multiply(getDisplayValue(), getDisplayValue());
                    setDisplayValue(String.valueOf(prod));
                    break;
                case "/":
                    int quotient = calculator.divide(getDisplayValue(), getDisplayValue());
                    setDisplayValue(String.valueOf(quotient));
                    break;
                case "Sq":
                    int square = calculator.square(getDisplayValue());
                    setDisplayValue(String.valueOf(square));
                    break;
                case "Pow":
                    int power = calculator.power(getDisplayValue(), 2); // Example with power 2
                    setDisplayValue(String.valueOf(power));
                    break;
                case "Abs":
                    int abs = calculator.absoluteValue(getDisplayValue());
                    setDisplayValue(String.valueOf(abs));
                    break;
                case "√":
                    double sqrt = calculator.racineCarree(getDisplayValue());
                    setDisplayValue(String.valueOf(sqrt));
                    break;
                default:
                    display.setText(display.getText() + command);
            }
        } catch (Exception ex) {
            setDisplayValue("Error");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorGUI calculatorGUI = new CalculatorGUI();
            calculatorGUI.setVisible(true);
        });
    }
}
