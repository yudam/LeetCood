package com.mdy.sort;

/**
 * User: maodayu
 * Date: 2021/2/26 9:51
 */
public class FB {
    public static void main(String[] args) {

        System.out.println(maxPath(6));
    }

    //一个 N 阶的楼梯，每次能走一层或者两层，问一共有多少种走法。
    public static int maxPath(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int pre1 = 1;
        int pre2 = 2;
        for (int i = 2; i < n; i++) {
            int temp = pre1 + pre2;
            pre1 = pre2;
            pre2 = temp;
        }
        return pre2;
    }

    /**
     * f(n) = f(n-1) +f(n-3)
     */
}
