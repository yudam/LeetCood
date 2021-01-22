package com.data.stack;

import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: maodayu
 * Date: 2021/1/13 18:13
 */
public class Solution4 {

    public static void main(String[] args) {
        ReentrantLock lock  = new ReentrantLock();
    }

    class MinStack {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> subStack = new Stack<>();

        public MinStack() {
        }

        public void push(int x) {
            stack.push(x);
            if (subStack.empty()||subStack.peek() > x) {
                subStack.push(x);
            } else {
                subStack.push(subStack.peek());
            }

        }

        public void pop() {
            stack.pop();
            subStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return subStack.peek();
        }
    }
}
