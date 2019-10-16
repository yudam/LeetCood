package com.design.list_struct;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * User: maodayu
 * Date: 2019/10/11
 * Time: 17:41
 */
public class Solution22 {

    public static void main(String[] args) {

        List<String> result = generateParenthesis(2);

        for (String s : result) {
            System.out.println(s);
        }
    }

    public static List<String> generateParenthesis(int n) {
        char[] current = new char[n * 2];
        List<String> result = new LinkedList<>();
        generateAll(current, 0, result);

        return result;
    }


    public static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }


    /**
     *((((  ((()
     *
     *
     */
}
