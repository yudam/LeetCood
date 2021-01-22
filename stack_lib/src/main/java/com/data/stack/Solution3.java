package com.data.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * User: maodayu
 * Date: 2021/1/8 17:53
 */
public class Solution3 {

    public static void main(String[] args) {

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = nextGreaterElement(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        if (nums1.length == 0 || nums2.length == 0) return result;
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] > stack.peek()) {
                while (!stack.empty()&&nums2[i]>stack.peek()) {
                    map.put(stack.pop(), nums2[i]);
                }
            }
            stack.push(nums2[i]);
        }


        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
