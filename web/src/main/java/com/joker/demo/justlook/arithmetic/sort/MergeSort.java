package com.joker.demo.justlook.arithmetic.sort;

import java.util.Arrays;


/**
 * 有效、稳定的排序算法，
 * 该算法是采用分治法(Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；
 * 即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为二路归并。
 * 当有 n 个记录时，需进行 logn 轮归并排序，每一轮归并，其比较次数不超过 n，元素移动次数都是 n，因此，归并排序的时间复杂度为 O(nlogn)。
 * 归并排序时需要和待排序记录个数相等的存储空间，所以空间复杂度为 O(n)。
 * 归并排序适用于数据量大，并且对稳定性有要求的场景。
 * */
public class MergeSort {

    static int[] array = {5,3,6,4,1,8,9,2};

    public static void main(String[] args) {
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        //数组合并
        if (arr[mid] > (arr[mid + 1])){
            merge(arr, l, mid, r);
            System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        }
    }

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(int[] arr, int l, int mid, int r) {

        int[] aux = Arrays.copyOfRange(arr, l, r + 1);

        //标记左边起始索引i
        //标记右边起始索引j
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {  
                //左边部分比较完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                //右边部分比较完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < (aux[j - l])) {  
                //左边指定元素小于右边指定元素
                arr[k] = aux[i - l];
                i++;
            } else {  
                //左边指定元素大于等于右边指定元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

}