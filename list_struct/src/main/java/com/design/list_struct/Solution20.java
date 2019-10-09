package com.design.list_struct;

import java.util.HashMap;
import java.util.Stack;

/**
 * 有效的括号
 */
public class Solution20 {


    public static void main(String[] args) {

        boolean isvalid = isValid("([])");

        System.out.println(isvalid);

    }


    /**
     * 采用入栈  栈顶数据对比，相同出栈 的思路，最后判断栈是否为空
     */

    public static boolean isValid(String s) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');


        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (map.get(s.charAt(i)) == null) {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) return false;
                if (map.get(s.charAt(i)) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (!stack.empty()) return false;
        return true;
    }


}
