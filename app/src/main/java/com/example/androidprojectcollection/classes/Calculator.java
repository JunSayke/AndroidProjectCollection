package com.example.androidprojectcollection.classes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Calculator {
    public double evaluateSequential(String expression) {
        Queue<Double> operands = new LinkedList<>();
        Queue<Character> operators = new LinkedList<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                // Read the entire number
                StringBuilder numBuilder = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numBuilder.append(expression.charAt(i));
                    i++;
                }
                i--; // Move back one position to account for the last character read
                operands.add(Double.parseDouble(numBuilder.toString()));
            } else if (isOperator(ch)) {
                operators.add(ch);
            }
        }

        // Evaluate remaining operators
        while (!operators.isEmpty()) {
            double a = operands.remove();
            double b = operands.remove();
            operands.add(applyOperator(a, b, operators.remove()));
        }

        return operands.remove();
    }

    public double evaluateMDAS(String expression) {
        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                // Read the entire number
                StringBuilder numBuilder = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numBuilder.append(expression.charAt(i));
                    i++;
                }
                i--; // Move back one position to account for the last character read
                operands.push(Double.parseDouble(numBuilder.toString()));
            } else if (isOperator(ch)) {
                // Handle operators
                while (!operators.isEmpty() && hasHigherPrecedence(operators.peek(), ch)) {
                    double b = operands.pop();
                    double a = operands.pop();
                    operands.push(applyOperator(a, b, operators.pop()));
                }
                operators.push(ch);
            }
        }

        // Evaluate remaining operators
        while (!operators.isEmpty()) {
            double b = operands.pop();
            double a = operands.pop();
            operands.push(applyOperator(a, b, operators.pop()));
        }

        return operands.pop();
    }

    public boolean isOperator(char op) {
        return op == '*' || op == '/' || op == '+' || op == '-';
    }

    private boolean hasHigherPrecedence(char op1, char op2) {
        return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
    }

    private double applyOperator(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
