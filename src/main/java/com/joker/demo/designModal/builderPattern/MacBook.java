package com.joker.demo.designModal.builderPattern;

public class MacBook extends Computer{

    protected MacBook(){

    }

    @Override
    protected void setOs() {
        os = "MacOs";
    }
}
