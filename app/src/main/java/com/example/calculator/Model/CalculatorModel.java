package com.example.calculator.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * CalculatorModel contains all the business logic of the calculator app
 */
public class CalculatorModel {

    /**
     * Calculate the result of the given expression
     *
     * @param operand      operand of the expression
     * @param firstNumber  first operator of the expression
     * @param secondNumber second operator of the expression
     * @return the result of the expression
     */
    public Double calculate(String operand, Double firstNumber, Double secondNumber) {

        if (operand == null || firstNumber == null || secondNumber == null) {
            return null;
        }

        switch (operand) {
            case "+":
                return add(firstNumber, secondNumber);
            case "-":
                return subtract(firstNumber, secondNumber);
            case "/":
                return divide(firstNumber, secondNumber);
            case "*":
                return multiply(firstNumber, secondNumber);
            case "%":
                return percentage(firstNumber);
        }
        return null;

    }

    /**
     * Calculate the sum of two numbers
     */
    public Double add(Double firstNumber, Double secondNumber) {
        return firstNumber + secondNumber;
    }

    /**
     * Calculate the difference of two numbers
     */
    public Double subtract(Double firstNumber, Double secondNumber) {
        return firstNumber - secondNumber;
    }

    /**
     * Calculate the product of two numbers
     */
    public Double multiply(Double firstNumber, Double secondNumber) {
        return firstNumber * secondNumber;
    }

    /**
     * Calculate the quotient of two numbers
     */
    public Double divide(Double firstNumber, Double secondNumber) {
        if (secondNumber == 0) {
            return null;
        }
        return firstNumber / secondNumber;
    }

    /**
     * Calculate the percentage of a number
     */
    public Double percentage(Double firstNumber) {
        return firstNumber / 100;
    }

    /**
     * Calculate the result of the whole expression of edittext
     */
    public String findResult(ArrayList<String> expression) {

        //First calculate the percentages, divisions and multiplications in the expression
        for (int i = 1; i < expression.size(); i++) {
            switch (expression.get(i)) {
                case "%": {
                    List<String> operands = findOperands(expression, i);
                    expression.set(i, calculate("%", Double.parseDouble(operands.get(0)), Double.parseDouble("0")).toString());
                    break;
                }
                case "/": {
                    List<String> operands = findOperands(expression, i);
                    expression.set(i, calculate("/", Double.parseDouble(operands.get(0)), Double.parseDouble(operands.get(1))).toString());
                    break;
                }
                case "*": {
                    List<String> operands = findOperands(expression, i);
                    expression.set(i, calculate("*", Double.parseDouble(operands.get(0)), Double.parseDouble(operands.get(1))).toString());
                    break;
                }
                case ".": {
                    expression.set(i, String.valueOf(Double.parseDouble(expression.get(i - 1)) + Double.parseDouble(expression.get(i + 1)) * 0.1 * expression.get(i + 1).length()));
                    expression.remove(i + 1);
                    expression.remove(i - 1);
                    i++;
                    break;
                }
            }
        }

        //Calculate the sums and the differences of the expression
        for (int i = 1; i < expression.size(); i++) {
            switch (expression.get(i)) {
                case "+": {
                    List<String> operands = findOperands(expression, i);
                    expression.set(i, calculate("+", Double.parseDouble(operands.get(0)), Double.parseDouble(operands.get(1))).toString());
                    break;
                }
                case "-": {
                    List<String> operands = findOperands(expression, i);
                    expression.set(i, calculate("-", Double.parseDouble(operands.get(0)), Double.parseDouble(operands.get(1))).toString());
                    break;
                }
            }
        }
        ArrayList<String> result = findOperands(expression, -1);
        return result.get(0);
    }

    /**
     * Find the two operands of a given expression
     */
    private ArrayList<String> findOperands(ArrayList<String> expression, int operatorIndex) {
        ArrayList<String> operands = new ArrayList<>();

        //If there is no operator return the operand
        if (operatorIndex == -1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < expression.size(); i++) {
                sb.append(expression.get(i));
            }
            String str = sb.toString();
            ArrayList<String> operand = new ArrayList<>();
            operand.add(str);
            return operand;
        }

        //Find the first and the second operand
        String firstNumber = "", secondNumber = "";
        for (int j = operatorIndex - 1; j >= 0; j--) {
            if (!expression.get(j).equals("+") && !expression.get(j).equals("-") && !expression.get(j).equals("*") && !expression.get(j).equals("/") && !expression.get(j).equals("%")) {
                firstNumber = expression.get(j) + firstNumber;
                expression.set(j, "");
            } else {
                break;
            }
        }
        for (int j = operatorIndex + 1; j < expression.size(); j++) {
            if (!expression.get(j).equals("+") && !expression.get(j).equals("-") && !expression.get(j).equals("*") && !expression.get(j).equals("/") && !expression.get(j).equals("%")) {
                secondNumber = secondNumber + expression.get(j);
                expression.set(j, "");
            } else {
                break;
            }
        }

        operands.add(firstNumber);
        operands.add(secondNumber);
        return operands;


    }
}
