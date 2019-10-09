package com.design.list_struct;

/**
 * User: maodayu
 * Date: 2019/9/26
 * Time: 16:58
 */
public class ListNode {

    int      val;
    ListNode next;

    ListNode(int x) { val = x; }


    public ListNode(int data, ListNode next) {
        this.val = data;
        this.next = next;
    }
}
