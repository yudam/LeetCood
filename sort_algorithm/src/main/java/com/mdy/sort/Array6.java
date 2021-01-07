package com.mdy.sort;

import java.util.*;

/**
 * User: maodayu
 * Date: 2020/6/1
 * Time: 下午4:56
 */
public class Array6 {


    public static void main(String[] args) {

//        List<String> list = new LinkedList<>();
//        int[] nums = {1, 2, 3};
//        allArray(list, nums, 0);
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        int[] nums1 ={2,5,3,3};
        System.out.println(Arrays.toString(thirdMaxNum(nums1)));


    }


    public static int[] thirdMaxNum(int[] nums) {

        int max[] ={Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};

        if(nums == null||nums.length ==0) return max;

        if(nums.length ==1){
            max[0] = nums[0];
            return max;
        }

        if(nums.length == 2){
            max[0] = nums[0];
            max[1] = nums[1];
            return max;
        }

        for (int num : nums) {

            if (num > max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = num;
            } else if (num > max[1]) {
                max[2] = max[1];
                max[1] = num;
            } else if (num > max[2]) {
                max[2] = num;
            }
        }
        return max;
    }


    /**
     * 数组的全排列
     * <p>
     * 例如 {1,2}的全排列，是1开头的2的全排列和2开头的1的全排列。
     * {3,4,5}的全排列，是3开头的加上{4,5}的全排列组合，4开头的加上{3,5}的全排列组合和5开头的加上{3,4}的
     * 全排列组合。
     * <p>
     * 通过上述，加入一个数组为r={r1,r2...rn},全排列R(r),那么R(p)=r1R(p1)+r2R(p2)+...+rnR(pn).
     * <p>
     * 数组中的所有数与第一个数交换，接着使用迭代处理剩余的n-1个数，注意每次交换首位数字后，后面需要交换回来。
     */
    public static void allArray(List<String> result, int[] nums, int start) {

        if (start == nums.length - 1) {
            result.add(Arrays.toString(nums));
            return;
        }
        //start表示首位，后面的数组元素都需要与start交换
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            allArray(result, nums, start + 1);
            swap(nums, i, start);
        }
    }


    private static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
