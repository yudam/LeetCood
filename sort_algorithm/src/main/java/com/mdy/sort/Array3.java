package com.mdy.sort;

/**
 * User: maodayu
 * Date: 2020/3/20
 * Time: 下午1:59
 */
public class Array3 {

    public static void main(String[] args) {

        String msg="mao da yu zw";//每一个字符串的末尾还有一个\0操作符
        char[] response =new char[msg.length()+1000];

        for(int i=0;i<msg.length();i++){
            response[i]=msg.charAt(i);

        }

        System.out.println(String.valueOf(replaceBlack(response)));

    }


    /**
     * 5. 替换空格  51页
     * 实现一个函数，把字符串中的空格替换为%20，保证原先的字符串数组有足够的空余内存来存放替换后的数组。
     * 思路：从后往前遍历
     * 时间复杂度：O(n)
     */
    public static char[] replaceBlack(char[] msg) {

        if (msg == null || msg.length == 0) return msg;
        int sLen = 0;
        int bNums = 0;

        for (char c : msg) {
            if (c == '\0'){
                break;
            } else if( c==' '){
                bNums++;
            }
            sLen++;
        }

        int oldIndex = sLen - 1;
        int newIndex = sLen + bNums * 2 - 1;

        while (oldIndex >= 0 && newIndex >= 0) {
            if (msg[oldIndex] == ' ') {
                msg[newIndex--] = '0';
                msg[newIndex--] = '2';
                msg[newIndex--] = '%';
            } else {
                msg[newIndex--] = msg[oldIndex];
            }
            oldIndex--;
        }
        return msg;
    }
}
