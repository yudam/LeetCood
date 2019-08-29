package com.mdy.string_struct;

import java.util.LinkedList;
import java.util.List;

/**
 * User: maodayu
 * Date: 2019/8/29
 * Time: 18:47
 */
public class ZConvert {

    public static void main(String[] args) {


    }

    /**
     * 看了 官方的题解，真是被秀了智商，没想到可以这么解
     * <p>
     * 思路：1.在字符串不存在或为null，和行数为1或者字符串的长度小于行数的情况下，直接返回。
     * 2.根据行数的个数创建一个List集合，元素为StringBuffer。
     * 3.根据行数来添加字符，方向只有在最顶端和最底部的时候才会改变
     * 4.输出字符
     * <p>
     * 貌似比较耗时：估计还可以找规律，一次性添加一行的数据，然后总体输出
     */

    public String convert(String s, int numRows) {

        if (s == null || s.length() <= 0) return "";

        if (numRows == 1 || s.length() <= numRows) return s;

        List<StringBuffer> list = new LinkedList<>();

        for (int i = 0; i < numRows; i++) {
            list.add(i, new StringBuffer());
        }

        int crows = 0;
        boolean goingTo = false;

        //很秀的地方：从第一行开始到最后一行，每次添加一个元素，然后再反过来添加元素，
        for (char c : s.toCharArray()) {

            list.get(crows).append(c);

            if (crows == 0 || crows == numRows - 1) {
                goingTo = !goingTo;
            }
            crows += goingTo ? 1 : -1;
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            stringBuffer.append(list.get(i));
        }
        return stringBuffer.toString();
    }
}
