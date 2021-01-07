package com.mdy.treelib;

/**
 * User: maodayu
 * Date: 2020/6/24
 * Time: 下午4:17
 */
public class QuickSort {

    public static void main(String[] args) {

        int arr[] = {7, 5, 3, 2, 4, 1, 1, 2, 6};

        quicksort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    /**
     *快速排序：从最左或者最右找一个数为基准，比它大的放在右边，比它小的放在左边，迭代执行。
     */
    private static void quicksort(int[] arr, int low, int high) {

        if (arr.length < 1 || low >= high) return;

        int middleValue = arr[low];

        int start = low;
        int end = high;

        while (low < high) {

            if (arr[high] > middleValue) {
                high--;
            } else if (arr[low] < middleValue) {
                low++;
            } else{
                swap(arr,low,high);
            }
        }

        quicksort(arr, start, low - 1);
        quicksort(arr, low + 1, end);
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
