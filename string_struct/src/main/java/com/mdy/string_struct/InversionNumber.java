package com.mdy.string_struct;

/**
 * User: maodayu
 * Date: 2019/8/30
 * Time: 10:40
 */
public class InversionNumber {

    public static void main(String[] args) {


        int x = -123;
        System.out.println(reverse(x));

        int MIN_VALUE = -2147483648;
        int MAX_VALUE = 2147483647;

        System.out.println(MIN_VALUE - 2);
    }

    /**
     * 反转数字，主要难点在于判断溢出的条件
     * <p>
     * 1.首先不判断溢出，每次弹出整数最后一位，整整/10.
     * 2.将弹出的整数添加到temp中，按照temp=temp*10+pop。
     * 3.在每次扩大temp时，判断溢出条件。
     * <p>
     * 注意：7是2^31 - 1的个位数
     * 8是-2^31的个位数
     * 不能通过两数相加捕获异常来判断溢出，超出最小值会变为正数，超出最大值会变为负数
     */

    public static int reverse(int x) {

        int rev = 0;

        while (x != 0) {

            int pop = x % 10;
            x = x / 10;
            //左边的条件判断是否超出上下边界，右边的条件判断在边界的情况下，判断将要添加的剩余数是否超出边界的剩余数
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }

        return rev;
    }

}
