package com.design.list_struct;

/**
 * 移除元素
 */
public class Solution27 {

    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};

        int num = removeElement(nums, 2);

        for (int i = 0; i < num; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 思路：采用双指针发 start和i，start初始指向0位置，i从0开始遍历数组。
     * 若nums[i]!=val,将当前值放入start位置处，start位置+1 。重复当前步骤
     * 直到遍历结束。
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */

    public static int removeElement(int[] nums, int val) {

        int start = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[start++] = nums[i];
            }
        }
        return start;
    }
}
