package com.joker.demo.designModal.builderPattern;

public class MacBuilder extends Builder {

    Computer macBook = new MacBook();

    @Override
    void buildDisplay(String display) {
        macBook.setDisplay(display);
    }

    @Override
    void buildBoard(String board) {
        macBook.setBoard(board);
    }

    @Override
    void buildOs() {
        macBook.setOs();
    }

    @Override
    Computer buildComputer() {
        return macBook;
    }

}
