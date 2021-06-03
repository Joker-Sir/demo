package com.joker.demo.justlook.arithmetic.sort;

import java.util.Arrays;

/**
 * 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，
 * 并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。堆排序可以说是一种利用堆的概念来排序的选择排序。分为两种方法：
 *
 * 大顶堆：每个节点的值都大于或等于其子节点的值，在堆排序算法中用于升序排列；
 * 小顶堆：每个节点的值都小于或等于其子节点的值，在堆排序算法中用于降序排列；
 * 堆排序的平均时间复杂度为 Ο(nlogn)。
 * */
public class HeapSort {


    static int[] array = {5,3,6,4,1,8,9,2};

    public static void main(String[] args) {
        int len = array.length;

        buildMaxHeap(array, len);

        for (int i = len - 1; i > 0; i--) {
            swap(array, 0, i);
            len--;
            heapify(array, 0, len);
        }

        System.out.println(Arrays.toString(array));

    }


    /**
     * 构建堆
     * 从一半开始？ 减少循环次数？
     * */
    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    /**
     * 堆化
     * 1 2 4 8 16     i j  j  =2i
     * 0 1 3 7 15     x y  y+1=2(x+1) y=2x+2-1=2x-1
     * */
    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        //比较左子节点
        if (left < len && arr[left] > arr[largest ]) {
            largest = left;
        }
        //比较右子节点
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        //需要交换形成大顶堆 交换之后需要重新调整
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    /**
     * 交换
     * */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
