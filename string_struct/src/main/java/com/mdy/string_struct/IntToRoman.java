package com.mdy.string_struct;

/**
 * Title: 整数转罗马数字
 * Date: 2019/9/5
 * Time: 16:01
 */
public class IntToRoman {

    public static void main(String[] args) {

        System.out.println(intToRoman(1994));
    }

    /**
     * 贪心选择是指所求问题的整体最优解可以通过一系列局部最优的选择，即贪心选择来达到。
     * 这是贪心算法可行的第一个基本要素，也是贪心算法与动态规划算法的主要区别。
     * 贪心选择是采用从顶向下、以迭代的方法做出相继选择，每做一次贪心选择就将所求问题简化为一个规模更小的子问题。
     * 对于一个具体问题，要确定它是否具有贪心选择的性质，我们必须证明每一步所作的贪心选择最终能得到问题的最优解。
     * 通常可以首先证明问题的一个整体最优解，是从贪心选择开始的，而且作了贪心选择后，原问题简化为一个规模更小的类似子问题。
     * 然后，用数学归纳法证明，通过每一步贪心选择，最终可得到问题的一个整体最优解
     */


    public static String intToRoman(int num) {

        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < 13; i++) {
            while (num >= nums[i]) {
                stringBuffer.append(roman[i]);
                num -= nums[i];
            }
        }
        return stringBuffer.toString();
    }

}
