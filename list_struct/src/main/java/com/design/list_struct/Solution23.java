package com.design.list_struct;

/**
 * 合并K个排序链表
 */
public class Solution23 {

    public static void main(String[] args) {


        ListNode listNode6 = new ListNode(5, null);
        ListNode listNode5 = new ListNode(4, listNode6);
        ListNode listNode4 = new ListNode(1, listNode5);

        ListNode listNode3 = new ListNode(4, null);
        ListNode listNode2 = new ListNode(3, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode listNode7 = new ListNode(6, null);
        ListNode listNode8 = new ListNode(2, listNode7);

        ListNode[] lists = {listNode4, listNode1, listNode8};

        ListNode listNode = mergeKLists(lists);

        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode preNode = new ListNode(0);
        ListNode head = preNode;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                preNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                preNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            preNode = preNode.next;
        }

        if (l1 != null) {
            preNode.next = l1;
        }

        if (l2 != null) {
            preNode.next = l2;
        }
        return head.next;
    }

    /**
     * 根据21题两两合并的思路，将k链表的合边转化为k-1个链表的合并
     */
    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        ListNode l1 = lists[0];

        for (int i = 1; i < lists.length; i++) {
            l1 = mergeTwoLists(l1, lists[i]);
        }
        return l1;
    }
}

