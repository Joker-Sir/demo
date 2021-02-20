package com.joker.demo.designModal.strategypattern;

/**
 * { @link https://www.runoob.com/design-pattern/strategy-pattern.html }
 * 一个类的行为或其算法可以在运行时更改
 * */
public class StrategyTest {

    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }

}
