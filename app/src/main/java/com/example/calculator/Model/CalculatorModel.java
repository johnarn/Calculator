package com.example.calculator.Model;

public class CalculatorModel {

    public Double calculate(String operand, Double firstNumber, Double secondNumber){

        if(operand == null || firstNumber == null || secondNumber == null){
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
        }
        return null;

    }

    public Double add(Double firstNumber, Double secondNumber){
        return firstNumber + secondNumber;
    }

    public Double subtract(Double firstNumber, Double secondNumber){
        return firstNumber - secondNumber;
    }

    public Double multiply(Double firstNumber, Double secondNumber){
        return firstNumber * secondNumber;
    }

    public Double divide(Double firstNumber, Double secondNumber){
        if(secondNumber == 0){
            return null;
        }
        return firstNumber / secondNumber;
    }


}
