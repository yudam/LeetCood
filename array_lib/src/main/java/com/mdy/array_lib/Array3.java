package com.mdy.array_lib;

/**
 * User: maodayu
 * Date: 2020/7/31
 * Time: 下午5:42
 */
public class Array3 {

    public static void main(String[] args) {

    }


    public static int movesToMakeZigzag(int[] nums) {

        if (nums == null || nums.length < 2) return 0;

        int length = nums.length;
        int odd = 0;
        int even = 0;
        for (int i = 0; i < length; i++) {

            int d1, d2;

            d1 = (i > 0 && nums[i] >= nums[i - 1]) ? nums[i] - nums[i-1] + 1 : 0;
            d2 = (i < length - 1 && nums[i] >= nums[i+1]) ? nums[i] - nums[i+1] + 1 : 0;

            if (i % 2 == 0) {
                //当前位置是偶数
                even+=Math.max(d1,d2);
            } else {
                //当前位置是奇数
                odd+=Math.max(d1,d2);
            }

        }
        return Math.min(odd, even);
    }

    /**
     * 循环遍历，保证该位置元素比左右两边的元素都小，得出d1，d2。
     *
     * 如果当前位置是偶数，则按照奇数位比相邻的两个元素都大来求出d1和d2之间的最大值。
     * 如果当前位置是奇数，则按照偶数位比相邻的两个元素都大来求出d1和d2之间的最大值。
     *
     * 这里使用Math.max(d1,d2)，是为了表明，d1和d2之间的最大值一定满足两边元素减去该值
     * 都比中间值小。
     */

}
