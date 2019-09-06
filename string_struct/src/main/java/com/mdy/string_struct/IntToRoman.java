package com.mdy.string_struct;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 整数转罗马数字
 * Date: 2019/9/5
 * Time: 16:01
 */
public class IntToRoman {

    public static void main(String[] args) {

        // System.out.println(intToRoman(1994));

        System.out.println(romanToInt("MCMXCIV"));
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


    /**
     * 从后往前遍历，若后一位小于前一位，表明是字符组成的数字，则加上该双字符表示数字，并减去后一位表示的数字。
     * 若后一位不小于前一位，则加上前一位的数字。
     * <p>
     * start：前一位数字， next 后一位数字   res总数
     * <p>
     * next小于start，下一次肯定是next>=start,
     * 所以这两个罗马数字表示的值num分两次加入：第一次加入两数的值（start-next）-下一次要加入的值next
     * 下一次比较  直接加入next。
     * 总的公式为：start-next-next+next=start-next
     */
    public static int romanToInt(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int res = 0;
        int index = s.length() - 1;
        while (index >= 0) {
            int start = map.get(s.substring(index, index + 1));
            if (index == 0) return res + start;
            int next = map.get(s.substring(index - 1, index));
            if (next < start) {
                res += (start - next - next);
            } else {
                res += start;
            }
            index--;
        }

        return res;
    }


}
