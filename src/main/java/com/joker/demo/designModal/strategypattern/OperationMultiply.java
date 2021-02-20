package com.joker.demo.designModal.strategypattern;

public class OperationMultiply implements StrategyInterface {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
