package com.mdy.sort;

/**
 * User: maodayu
 * Date: 2020/3/20
 * Time: 上午9:58
 */
public class Array2 {

    public static void main(String[] args) {
        int[][] nums = {{2, 4, 6, 8},
                {3, 6, 9, 10}};
        System.out.println(find(nums, 3));

    }


    /**
     * 4. 二维数组中的查找
     * 每一行从左到右递增，每一列从上至下递增，设计一个函数，判断给定的数值是否存在
     *
     * 思路：选取数组右上角的数字，如果大于该数字，则去除该数字所在的行，如小于该数字，则
     *      去除该数字所在的列。每次剔除一行或者一列，缩小范围。
     */
    public static boolean find(int[][] nums, int target) {

        if (nums == null || nums.length == 0) return false;
        int hLen = nums[0].length - 1;
        int k = 0;
        while (hLen >= 0 && k < nums.length) {

            if (target > nums[k][hLen]) {
                k++;
            } else if (target < nums[k][hLen]) {
                hLen--;
            } else {
                return true;
            }
        }
        return false;
    }
}
