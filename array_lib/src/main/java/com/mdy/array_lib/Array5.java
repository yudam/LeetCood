package com.mdy.array_lib;

/**
 * User: maodayu
 * Date: 2020/8/10
 * Time: 下午4:34
 */
public class Array5 {

    public static void main(String[] args) {

        int result = uniquePaths1(3, 2);
        System.out.println("result=" + result);
    }

    /**
     * 1 <= m, n <= 100
     * 题目数据保证答案小于等于 2 * 10 ^ 9
     */


    public static int uniquePaths1(int m, int n) {


        int[][] result = new int[m][n];

        for(int i=0;i<m;i++){
            result[i][0] = 1;
        }

        for(int i=0;i<n;i++){
            result[0][i]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i][j - 1] + result[i - 1][j];
            }
        }

        return result[m - 1][n - 1];
    }


    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[] end = {m - 1, n - 1, 0};

        nextStep(0, 0, end);
        return end[2];
    }


    private static void nextStep(int x, int y, int[] result) {

        if (x > result[0] || y > result[1]) return;

        if (x == result[0] && y == result[1]) {
            result[2]++;
        } else if (x == result[0]) {
            nextStep(x, y + 1, result);
        } else if (y == result[1]) {
            nextStep(x + 1, y, result);
        } else {
            nextStep(x, y + 1, result);
            nextStep(x + 1, y, result);
        }
    }
}
