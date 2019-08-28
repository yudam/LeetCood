package com.mdy.string_struct;

public class MyClass {

    public static void main(String[] args) {

        int[] nums1 = {2, 5, 6};
        int[] nums2 = {3, 7};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);

    }


    /**
     * 1.有序数组
     * 2.不会同时为空
     * 时间复杂度O(log(m+n)),随着n的增大，呈现以2的n次方线性增长
     * <p>
     * 解决思路：
     * 1.创建一个长度为nums1+nums2的数组空间，存放两个数组中的元素。
     * 2.采用归并排序对合并空间中元素进行排序。
     * 3.合并空间的长度为2的倍数则获取mid左右元素取平均值，反之直接返回值
     *
     * 空间复杂度O(n)  时间复杂度O(log(m+n))
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] allNums;
        if (nums1 == null) {
            nums1 = new int[0];
        }
        if (nums2 == null) {
            nums2 = new int[0];
        }
        allNums = new int[nums1.length + nums2.length];

        for (int i = 0; i < allNums.length; i++) {
            if (i > nums1.length - 1) {
                allNums[i] = nums2[i - nums1.length];
            } else {
                allNums[i] = nums1[i];
            }
        }
        int[] soryArray = new int[allNums.length];
        mergeChild(allNums, soryArray, 0, allNums.length - 1);

        looger(allNums);

        double result;
        if (allNums.length % 2 == 0) {

            double left = allNums[allNums.length / 2 - 1];
            double right = allNums[allNums.length / 2];

            result = (left + right) / 2;

        } else {
            result = allNums[allNums.length / 2];
        }
        return result;
    }

    private static void mergeChild(int[] nums, int[] result, int start, int end) {
        if (start >= end) return;
        int mid = (end + start) / 2;

        mergeChild(nums, result, start, mid);
        mergeChild(nums, result, mid + 1, end);

        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                result[k++] = nums[i++];
            } else {
                result[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            result[k++] = nums[i++];
        }

        while (j <= end) {
            result[k++] = nums[j++];
        }
        while (start <= end) {
            nums[start] = result[start++];
        }
    }


    private static void looger(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n-----------------------");
    }
}
