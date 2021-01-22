package com.data.stack;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

import sun.security.krb5.internal.Ticket;

/**
 * User: maodayu
 * Date: 2021/1/13 19:07
 */
public class Solution5 {

    public static void main(String[] args) {

        String a ="abbaca";

        System.out.println(removeDuplicates(a));
    }


    public static String removeDuplicates(String S) {

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<S.length();i++){
            if(stack.empty()){
                stack.push(S.charAt(i));
            }else{
                if(stack.peek() == S.charAt(i)){
                    stack.pop();
                }else{
                    stack.push(S.charAt(i));
                }
            }
        }
        char[] subString = new char[stack.size()];
        int count = stack.size()-1;
        while(!stack.empty()){
            subString[count--] = stack.pop();
        }

        return String.valueOf(subString);
    }
}
