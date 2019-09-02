package com.mdy.string_struct;

/**
 * User: maodayu
 * Date: 2019/9/2
 * Time: 10:48
 */
public class Atoi {

    public static void main(String[] args) {
        int nums = myAtoi("-91283472332");

        System.out.println(nums);
    }


    /**
     * 字符串转换整数
     * 取值范围[-2147483648,2147483647]
     * <p>
     * 这个题  没意思
     */
    public static int myAtoi(String str) {

        str = str.trim();

        if (str == null || str.length() <= 0) return 0;
        int start = 0;
        int sign = 1;
        int res = 0;
        int last;

        if (str.charAt(0) == '+') {
            sign = 1;
            start++;
        } else if (str.charAt(0) == '-') {
            sign = -1;
            start++;
        }

        last = sign == -1 ? 8 : 7;
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return res * sign;
            int curr = str.charAt(i) - '0';
            //判断res是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && curr > last))
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            res = res * 10 + curr;
        }
        return res * sign;
    }
}
