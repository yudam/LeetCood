package com.design.list_struct;

import java.util.*;

/**
 * User: maodayu
 * Date: 2019/10/11
 * Time: 18:23
 */
public class Test {


    public static void main(String[] args) {
//        int[] nums = {1, 2, 2, 3, 3, 3, 4, 5, 6, 6, 7};
//
//        removeDupliateNums(nums, 7);
//
//
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }

        Set<Integer> set=new TreeSet<>();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(9);
        list.add(2);
        list.add(9);

        Iterator iterator1=list.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        System.out.println("-------------------");
        set.addAll(list);
        list.clear();
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }




    public static int[] removeDupliateNums(int[] nums, int length) {
        if (nums.length <= length) return nums;
        int n = 1;
        for (int i = 1; n < length && i < nums.length; i++) {
            if (nums[i] <= nums[n - 1]) {
                continue;
            } else if (n == i) {
                n++;
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[n];
            nums[n++] = temp;
        }
        return nums;
    }
}
