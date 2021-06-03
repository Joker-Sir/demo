package com.joker.demo.util;


public class CompareUtil {

    public static <T extends Comparable> boolean compareTo(T source, T compared){
        if (!source.getClass().equals(compared.getClass())){
            return false;
        }
        return source.compareTo(compared) > 0;
    }

    public static void main(String[] args) {
        System.out.println("compareTo(13.245, \"3.2\") = " + compareTo(13.245, "3.2"));
    }


}
