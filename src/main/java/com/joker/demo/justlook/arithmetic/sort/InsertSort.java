package com.joker.demo.justlook.arithmetic.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
 * */
public class InsertSort {

    static int[] array = {5,3,6,4,1,8,9,2};

    public static void main(String[] args) {

        int len = array.length;
        int preIndex, current;
        for (int j = 0; j < len; j++) {
            preIndex = j - 1;
            //记录当前值
            current = array[j];
            //寻找有序序列中的相应位置
            while (preIndex >= 0 && array[preIndex] > current){
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            //在相应的位置插入值
            array[preIndex + 1] = current;
        }

        System.out.println(Arrays.toString(array));
    }


}
