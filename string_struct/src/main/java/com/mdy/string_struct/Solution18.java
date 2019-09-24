package com.mdy.string_struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 四数之和
 */
public class Solution18 {

    public static void main(String[] args) {

        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> listList = fourSum(nums, 0);

        for (List<Integer> list : listList) {

            for (Integer integer : list) {

                System.out.print(integer + " ");
            }
            System.out.print("\n-----------\n");
        }
    }

    /**
     * 思路：四数之和  转换为三数之和，按照之前三数之和的方式解答
     * 1.循环遍历数组，固定一个i的值，取target-nums[i]取差集。
     * 2.从i+1位置开始再次遍历 按照三数之和开始遍历，固定nums[i+1]的值，取L,R左右两端指针，做循环判断
     * 3.这里从i+1位置开始是为了减少判断次数，剔除重复的列表，一些额外的去重判断，可以通过Set转List来执行
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        List<List<Integer>> lists = new LinkedList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> listList = threeSum(nums, target - nums[i], i);
            for (List<Integer> list : listList) {
                lists.add(list);
            }
        }
        return lists;
    }

    /**
     * -2,-1,0,0,1,2      target=0
     */
    public static List<List<Integer>> threeSum(int[] nums, int target, int index) {
        List<List<Integer>> listList = new ArrayList<>();
        for (int i = index + 1; i < nums.length - 2; i++) {
            if (nums[i] == nums[i - 1] & (i - 1) > index) continue;
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];

                if (sum < target) {
                    L++;
                } else if (sum > target) {
                    R--;
                } else {
                    listList.add(Arrays.asList(nums[index], nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                }
            }
        }
        return listList;
    }
}
