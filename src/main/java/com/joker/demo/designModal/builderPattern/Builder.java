package com.joker.demo.designModal.builderPattern;

public abstract class Builder {

    abstract void buildDisplay(String display);

    abstract void buildBoard(String board);

    abstract void buildOs();

    abstract Computer buildComputer();


}
