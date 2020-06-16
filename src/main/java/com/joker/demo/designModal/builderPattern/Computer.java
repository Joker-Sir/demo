package com.joker.demo.designModal.builderPattern;

/**
 * 抽象电脑类
 * */
public abstract class Computer {

    protected String board;
    protected String os;
    protected String display;

    protected void setBoard(String board) {
        this.board = board;
    }

    protected void setDisplay(String display) {
        this.display = display;
    }

    protected abstract void setOs();

    @Override
    public String toString() {
        return "Computer : board is " + board + ", os is " + os + ", display is " + display;
    }
}
