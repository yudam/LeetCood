package com.design.list_struct;

/**
 * 两数相除
 */
public class Solution29 {

    public static void main(String[] args) {

        System.out.println(divide1(-2147483648, -1109186033));
    }

    //暴力法
    private static int divide(int dividend, int divisor) {

        if (dividend == 0 || divisor == 0) return 0;
        boolean isreverse = false;
        long count = 0;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            isreverse = true;

        if (isreverse) {
            if (dividend > 0) {
                while (dividend + divisor >= 0) {
                    dividend = dividend + divisor;
                    count++;
                }
            } else {
                while (dividend + divisor <= 0) {
                    dividend = dividend + divisor;
                    count++;
                }
            }
        } else {
            if (dividend > 0) {
                while (dividend >= divisor) {
                    dividend = dividend - divisor;
                    count++;
                }
            } else {
                while (dividend <= divisor) {
                    dividend = dividend - divisor;
                    count++;
                }
            }

        }

        if (isreverse) {
            if (count < Integer.MIN_VALUE) {
                count = Integer.MAX_VALUE;
            } else {
                count = -count;
            }

        } else {
            if (count > Integer.MAX_VALUE) {
                count = Integer.MAX_VALUE;
            }
        }

        return (int) count;
    }

    /**
     * >>右移表示减小多少倍
     * <<左移表示增大多少倍
     * <p>
     * 思路：
     * 1.首先判断输入接过符号，根据^原理。
     * 2.判断除数和被除数是否一致，一致返回1. 判断除数是否=integer.min_value，因为若是除数为最小的边界值，则表明除数>被除数，
     * 直接返回0.
     * 3.若是被除数为边界最小值，则减去被除数的值，在最后输出值时加上一位。然后把除数和被除数转化为正数处理。
     * <p>
     * 4.当除数小于被除数时，每次让除数增加一倍，tempresult也增加一倍,当除数若增加一倍则大于被除数时，跳出本次循环，被除数-除数。
     * result+tempresult,用剩下的被输数继续走之前的循环。
     * <p>
     * 5.最后根据输出符号和flag以及是否越界来返回result。
     * <p>
     * <p>
     * 注意 ：
     * 1. 这里使用long防止int溢出。
     * 2. tempresult=1，是为了当被除数和除数相除==1时，result需要+1.
     */

    private static int divide1(int dividend, int divisor) {

        long result = 0;
        boolean flag = false;
        boolean sign = false;
        if (dividend > 0 ^ divisor > 0) sign = true;

        if (dividend == divisor) return 1;

        if (divisor == Integer.MIN_VALUE) return 0;

        if (dividend == Integer.MIN_VALUE) {
            flag = true;
            dividend = sign ? dividend + divisor : dividend - divisor;
        }

        //转化为正数
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);


        while (divisor <= dividend) {

            int tempresult = 1;
            long tempdivisor = divisor;
            while (dividend >= tempdivisor << 1) {
                if (tempdivisor > Integer.MAX_VALUE >> 1) break;
                tempdivisor = tempdivisor << 1;
                tempresult = tempresult << 1;
            }
            result += tempresult;
            dividend -= tempdivisor;
        }

        //判断输出的符号
        if (sign) {
            result = -result;
        }

        //根据sign判断是+1位还是-1
        if (flag) {
            result += sign ? -1 : 1;
        }

        if (result > Integer.MAX_VALUE) result = Integer.MAX_VALUE;


        return (int) result;
    }
}
