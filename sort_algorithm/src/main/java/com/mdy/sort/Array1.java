package com.mdy.sort;

/**
 * User: maodayu
 * Date: 2020/3/16
 * Time: 下午9:34
 */
public class Array1 {

    public static void main(String[] args) {

        int[] nums={4,0,5,1,2,3};

        System.out.println(duplicate(nums));
    }

    /**
     * 4,2,5,1,2,3
     * 2,2,5,1,4,3
     * 5,2,2,1,4,3
     * 3,2,2,1,4,5
     * 1,2,2,3,4,5
     * 2,1,2,3,4,5
     * true
     */


    public static boolean duplicate(int[] nums) {

        int k = 0;

        for (int i = 0; i < nums.length; i+=k) {

            if (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return true;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }else {
                k++;
            }
        }

        return false;
    }

    public static void duplicate1(int[] nums){

    }
}
