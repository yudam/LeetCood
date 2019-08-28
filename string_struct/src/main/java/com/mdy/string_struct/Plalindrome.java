package com.mdy.string_struct;

/**
 * User: maodayu
 * Date: 2019/8/28
 * Time: 9:41
 */
public class Plalindrome {

    public static void main(String[] args) {

        System.out.println(longestPalindrome("abcbad"));

        /**
         * 中心扩展算法：遍历每个元素，默认该元素为回文的中心，两侧为镜像
         * 字母数为偶数时，中心有n-1个(中心两数之间)，字母数为奇数时，中心有n个（中心数）
         * 也就是字母和字母之间的间隙都可以为中心
         * n+n-1=2n-1
         *
         * 根据长度和中心计算start end   len为回文的长度
         * end=i+len/2;
         *
         * start=end-len+1
         *
         * start=i+len/2-len+1
         *      =i-len/2+1
         *      =i-(len-1)/2
         */
    }


    public static String longestPalindrome(String s) {

        if (s == null || s.length() <= 0) return "";

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {

            int len1 = expandAroundCenter(s, i, i);//中心为奇数
            int len2 = expandAroundCenter(s, i, i + 1);//中心为偶数

            int len = Math.max(len1, len2);
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    //由中心向两侧展开比对，获取回文的长度，最短为1
    public static int expandAroundCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }
        return right - left - 1;
    }
}
