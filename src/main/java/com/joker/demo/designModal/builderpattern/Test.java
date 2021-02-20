package com.joker.demo.designModal.builderpattern;

public class Test {

    public static void main(String[] args) {
        // Car car = Car.builder().dashboard("dashboard").engine("engine").light("light").build();
        Builder builder = new MacBuilder();
        Director director = new Director(builder);
        director.construct("intel","retina");
        Computer computer = builder.buildComputer();
        // builder.buildDisplay("retina");
        // builder.buildBoard("intel");
        // Computer computer = builder.buildComputer();
        System.out.println(computer.toString());
    }

}
