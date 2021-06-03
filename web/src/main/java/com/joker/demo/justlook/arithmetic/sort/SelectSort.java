package com.joker.demo.justlook.arithmetic.sort;


import java.util.Arrays;

/**
 * 选择排序：
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * 时间复杂度O()
 * */
public class SelectSort {

    static int[] array = {5,3,6,4,1,8,9,2};

    public static void main(String[] args) {
        int n = array.length;
        int minIndex, temp;
        for (int i = 0; i < n - 1; i++) {
            minIndex = i;
            //当前值与后面数组值一次比较获取最大（小）值下标
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            //交换值
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        System.out.println(Arrays.toString(array));

    }

}
