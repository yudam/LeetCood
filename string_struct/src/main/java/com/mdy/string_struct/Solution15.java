package com.mdy.string_struct;

import java.util.LinkedList;
import java.util.List;

/**
 * 三数之和
 */
public class Solution15 {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> listList = threeSum(nums);

        for (int i = 0; i < listList.size(); i++) {

            List<Integer> list = listList.get(i);

            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.print("\n-------------\n");
        }

    }


    /**
     * 1.先对数组进行排序
     * 2.从头开始遍历，指定一个数字nums[i]，start和end分别指向i后面的两个指针。
     * 3.若sum>0 end--,若sum<0  start++
     * 4.若start==start++，则start++， 若 end==end--，则end--
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList = new LinkedList<>();
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
        int start;
        int end;
        for (int i = 0; i < nums.length - 2; i++) {
            start = i + 1;
            end = nums.length - 1;
            if (nums[i] > 0) break;   //锚点nums[i]>0 结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue;  //当前锚点值与前一位锚点值相等，跳过此次循环
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] > 0) {
                    end--;
                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                } else {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    listList.add(list);
                    while (start < end && nums[start] == nums[start + 1]) start++;//跳过重复数字
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    start++;
                    end--;
                }
            }
        }


        return listList;
    }
}
