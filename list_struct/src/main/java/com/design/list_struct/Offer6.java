package com.design.list_struct;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * User: maodayu
 * Date: 2021/2/8 17:39
 */
public class Offer6 {

    public static void main(String[] args) {
        ListNode listNode8 = new ListNode(8, null);
        ListNode listNode7 = new ListNode(7, listNode8);
        ListNode listNode6 = new ListNode(6, listNode7);
        ListNode listNode5 = new ListNode(5, listNode6);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        int[] result = reversePrint(listNode1);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

    public static int[] reversePrint(ListNode head){

        Stack<Integer> stack = new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head = head.next;
        }

        int[] result = new int[stack.size()];
        int i =0;
        while (!stack.empty()){
            result[i++] = stack.pop();
        }
        return result;
    }

}
