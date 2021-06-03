package com.joker.demo.justlook.arithmetic.sort;

import java.util.Arrays;

/**
 * 冒泡排序：
 * 依次比较相邻两个数的大小进行替换，重复直到排序完成。
 * 时间复杂度：O(n^2)  稳定
 * */
public class BubbleSort {

    static int[] array = {5,3,6,4,1,8,9,2};

    public static void swap(int[] array,int i, int j){
        int temp ;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    };

    public static void main(String[] args) {
        //循环次数
        for (int i = 0; i < array.length - 1; i++) {
            //比较次数
            for (int j = 0; j < array.length - 1 - i; j++) {
                int a = array[j];
                int b = array[j + 1];
                if (a > b){
                    swap(array,j,j+1);
                }
            }
        }
        System.out.println(Arrays.toString(array));

    }

}
