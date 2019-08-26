package com.mdy.string_struct;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyClass {

    public static void main(String[] args) {

    }


    /**
     * 1.有序数组
     * 2.不会同时为空
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List list = new LinkedList();
        if (nums1 != null) {
            list.add(Arrays.asList(nums1));
        }
        if (nums2 != null) {
            list.add(Arrays.asList(nums2));
        }


        return 0;
    }

    public static void sortList(int[] nums) {
        int count = nums.length;
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
