package com.data.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Solution1 {

    public static void main(String[] args) {

        System.out.println("result=" + isValid2("{[]}"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.equals("")) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else {
                char topChar = stack.peek();
                char subChar = s.charAt(i);
                if ((topChar == '[' && subChar == ']')
                        || (topChar == '{' && subChar == '}')
                        || (topChar == '(' && subChar == ')')) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.empty();
    }

    public static boolean isValid2(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
           if(map.get(s.charAt(i)) == null){
               stack.push(s.charAt(i));
           }else{
               if(stack.empty()) return false;
               if(stack.peek()==map.get(s.charAt(i))){
                   stack.pop();
               }else{
                   return false;
               }
           }
        }
        return stack.empty();
    }
}
