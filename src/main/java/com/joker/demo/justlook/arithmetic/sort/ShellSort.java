package com.joker.demo.justlook.arithmetic.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 第一个突破O(n2)的排序算法，是简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 * */
public class ShellSort {

    static int[] array = {5,3,6,4,1,8,9,2};

    public static void main(String[] args) {

        int len = array.length;
        for (int gap = len / 2; gap > 0 ; gap = gap / 2) {
            for (int i = gap; i < len; i++) {
                //记录当前的值
                int j = i;
                int current = array[i];
                //比较是否大于当前值 大于则替换
                while (j - gap >= 0 && current < array[j - gap]){
                   array[j] = array[j - gap];
                   j = j - gap;
                }
                array[j] = current;
            }
        }

        System.out.println(Arrays.toString(array));

    }
}
