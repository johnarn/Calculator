package com.example.calculator.Model;

import java.util.ArrayList;
import java.util.List;

public class CalculatorModel {

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

    public Double add(Double firstNumber, Double secondNumber) {
        return firstNumber + secondNumber;
    }

    public Double subtract(Double firstNumber, Double secondNumber) {
        return firstNumber - secondNumber;
    }

    public Double multiply(Double firstNumber, Double secondNumber) {
        return firstNumber * secondNumber;
    }

    public Double divide(Double firstNumber, Double secondNumber) {
        if (secondNumber == 0) {
            return null;
        }
        return firstNumber / secondNumber;
    }

    public double percentage(Double firstNumber) {
        return firstNumber / 100;
    }


    public String findResult(ArrayList<String> expression) {


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
                case ".":
                    expression.set(i, String.valueOf(Double.parseDouble(expression.get(i - 1)) + Double.parseDouble(expression.get(i + 1)) * 0.1 * expression.get(i + 1).length()));
                    expression.remove(i + 1);
                    expression.remove(i - 1);
                    i++;
                    break;
            }

        }

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

    private ArrayList<String> findOperands(ArrayList<String> expression, int operatorIndex) {
        ArrayList<String> operands = new ArrayList<>();
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
