package com.design.list_struct;

/**
 * 删除排序数组中的重复项
 */
public class Solution26 {

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates1(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 思路：使用两个指针start，end分别指向数组中相同的数据的最左和最右下标。
     * k指向需要替换数据的位置下标。当end指向数组最后一个下标时，直接
     * 添加到k下标处
     */

    public static int removeDuplicates(int[] nums) {

        if (nums.length < 2) return nums.length;
        int start = 0;
        int end = 0;
        int k = 0;
        while (end < nums.length) {  //end  超出数组边界  结束循环
            if (nums[start] == nums[end + 1]) { //start指针和end+1指针指向的数据相同，end+1
                end++;
            } else {  //走到这里表明end+1和start指向数据不同，end和start数据相同
                nums[k++] = nums[end++];
                start = end;
            }
            if (end == nums.length - 1)//若当前end为最后一项，则直接将当前end添加到k下标处
                nums[k++] = nums[end++];
        }

        return k;
    }

    /**
     * 双指针法
     * <p>
     * 只要nums[j] == nums[i]，增j递增
     * <p>
     * i表示慢指针，  j表示快指针。若nums[j] != nums[i]，则将nums[j]的值
     * 赋值给nums[i+1]，然后i递增。重复以上步骤
     */

    public static int removeDuplicates1(int[] nums) {
        if (nums.length < 2) return nums.length;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
