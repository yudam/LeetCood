package com.mdy.string_struct;

/**
 * User: maodayu
 * Date: 2019/9/6
 * Time: 11:23
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix2(strs));
    }


    /**
     * 去除最短的字符串，根据最短的字符串的长度逐渐递减，依次和数组比较
     */
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";
        for (int j = 0; j < strs.length - 1; j++) {
            if (strs[j].length() < strs[j + 1].length()) {
                String temp = strs[j];
                strs[j] = strs[j + 1];
                strs[j + 1] = temp;
            }
        }
        String smallStr = strs[strs.length - 1];
        String result = "";
        for (int i = 0; i < smallStr.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                int end = smallStr.length() - i;
                result = smallStr.substring(0, end);
                if (!strs[j].substring(0, end).equals(result)) {
                    result = "";
                    break;
                }
            }
            if (result != "") return result;
        }
        return result;
    }

    /**
     * 水平查找法：
     * 该方法通过比较开始的两个字符串的统一前缀，在和之后的每一项字符串进行比较。
     * 时间复杂度O(S)
     * 空间复杂度O(1)
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {

            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                if (result.isEmpty()) return "";
            }

        }
        return result;
    }


    /**
     * 分治法，归并排序
     */

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int start = 0;
        int end = strs.length - 1;
        return longestCommon(strs, start, end);
    }

    /**
     * 分冶法：将问题划分为若干个小问题来比较。
     */

    public static String longestCommon(String[] strs, int start, int end) {

        if (start == end) return strs[start];

        int mid = (end + start) / 2;

        String leftStr = longestCommon(strs, start, mid);
        String rightStr = longestCommon(strs, mid + 1, end);


        while (rightStr.indexOf(leftStr) != 0) {
            leftStr = leftStr.substring(0, leftStr.length() - 1);
            if (leftStr.isEmpty()) return "";
        }

        return leftStr;
    }
}
