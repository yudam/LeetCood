package com.mdy.string_struct;

/**
 * User: maodayu
 * Date: 2019/9/2
 * Time: 15:57
 */
public class IsPalindrome {

    public static void main(String[] args) {

        System.out.println(isPalindromeTwo(121));
    }

    /**
     * 转化为字符串解法，需要额外的内存空间
     */
    public static boolean isPalindrome(int x) {
        String nums = String.valueOf(x);
        if (nums.length() == 1) return true;
        boolean isOdd = nums.length() % 2 != 0;
        int start;
        int end;
        int mid = nums.length() / 2;
        if (isOdd) {
            start = mid - 1;
            end = mid + 1;
        } else {
            start = mid - 1;
            end = mid;
        }
        while (start >= 0 && end < nums.length()) {
            if (nums.charAt(start) == nums.charAt(end)) {
                start--;
                end++;
            } else {
                return false;
            }
        }

        return true;
    }


    /**
     * 解法；反转数字，比较大小
     */
    public static boolean isPalindromeTwo(int x) {

        if (x < 0) return false;
        int start = x;
        int res = 0;
        while (x != 0) {
            int last = x % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE && last > 7))
                return false;
            res = res * 10 + last;
        }
        return res == start;
    }

}
