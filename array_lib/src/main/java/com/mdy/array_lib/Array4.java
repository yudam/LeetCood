package com.mdy.array_lib;

/**
 * User: maodayu
 * Date: 2020/8/4
 * Time: 下午6:21
 */
class Array4 {

    public static void main(String[] args) {

        int[] height = {1, 1, 4, 2, 1, 3};
        System.out.println(heightChecker(height));
    }

   /* 1 <= heights.length <= 100
            1 <= heights[i] <= 100*/

    public static int heightChecker(int[] heights) {

        if (heights == null || heights.length <= 1) return 0;

        int[] arr = new int[101];

        for (int i = 0; i < heights.length; i++) {
            arr[heights[i]]++;
        }

        int count = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) count++;
            }
        }


        return count;
    }

}
