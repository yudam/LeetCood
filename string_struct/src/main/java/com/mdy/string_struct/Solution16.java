package com.mdy.string_struct;

/**
 * 最接近的三数之和
 */
public class Solution16 {

    public static void main(String[] args) {

        int[] nums = {-1, 2, 1, -4};
        int[] nums1 = {-3, -2, -5, 3, -4};

        int result = threeSumClosest(nums1, -1);

        System.out.print(result);
    }

    /**
     * 1.先对数组进行排序
     * 2.固定一个数字nums[i],L,R指向以后i之后的两端指针。
     * 3.比较sum和target的大小，小于target，L++，大于target R--  并比较result和sum距离target的大小
     * 4.等于target 直接返回该sum
     */

    public static int threeSumClosest(int[] nums, int target) {

        int result = nums[0] + nums[1] + nums[2];
        int k = 0;
        while (k < nums.length - 1) {
            for (int i = 0; i < nums.length - k - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
            k++;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int L = i + 1;
            int R = nums.length - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];

                if (sum > target) {
                    R--;
                    if (Math.abs(result - target) > Math.abs(sum - target)) {
                        result = sum;
                    }
                } else if (sum < target) {
                    L++;
                    if (Math.abs(result - target) > Math.abs(sum - target)) {
                        result = sum;
                    }
                } else {
                    return sum;
                }

            }
        }
        return result;
    }
}
