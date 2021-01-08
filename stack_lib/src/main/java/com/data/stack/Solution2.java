package com.data.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 1. 用两个栈实现队列
 * 2. 用两个队列实现一个栈
 */
public class Solution2 {

    public static void main(String[] args) {
//        CQueue cQueue = new Solution2.CQueue();
//        cQueue.appendTail(3);
//        cQueue.appendTail(5);
//        cQueue.appendTail(7);
//        System.out.println(cQueue.deleteHead());
//        cQueue.appendTail(10);
//        System.out.println(cQueue.deleteHead());
//        System.out.println(cQueue.deleteHead());
//        System.out.println(cQueue.deleteHead());
//        System.out.println(cQueue.deleteHead());

        CStack cStack = new Solution2.CStack();
        cStack.appendTail(3);
        cStack.appendTail(5);
        cStack.appendTail(7);
        System.out.println(cStack.deleteHead());
        cStack.appendTail(10);
        System.out.println(cStack.deleteHead());
        System.out.println(cStack.deleteHead());
        System.out.println(cStack.deleteHead());
        System.out.println(cStack.deleteHead());

    }


    /**
     * 队列实现:先进先出
     */
    static class CQueue {

        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();


        public CQueue() {}

        //队尾插入
        public void appendTail(int value) {
            stack1.push(value);
        }

        //队头删除，若队列中没有元素，deleteHead 操作返回 -1
        public int deleteHead() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
                if (stack2.empty()) return -1;
            }
            return stack2.pop();
        }
    }

    /**
     * 栈实现 ：后进先出
     */

    static class CStack {

        //队尾插入，队头删除
        private ArrayDeque<Integer> deque1 = new ArrayDeque<>();
        private ArrayDeque<Integer> deque2 = new ArrayDeque<>();

        public CStack() {}

        public void appendTail(int value) {
            deque1.add(value);
        }

        public int deleteHead() {

            while (deque1.size() > 1) {
                deque2.add(deque1.poll());
            }

            if (deque1.size() != 0) {
                return deque1.poll();
            }

            while (deque2.size() > 1) {
                deque1.add(deque2.poll());
            }

            if (deque2.size() > 0) {
                return deque2.poll();
            }
            return -1;
        }
    }
}
