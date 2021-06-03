package com.joker.demo.designModal.builderpattern;

public class MacBook extends Computer{

    protected MacBook(){

    }

    @Override
    protected void setOs() {
        os = "MacOs";
    }
}
