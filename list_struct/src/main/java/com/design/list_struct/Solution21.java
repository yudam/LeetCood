package com.design.list_struct;

/**
 * 合并两个有序链表
 */
public class Solution21 {

    public static void main(String[] args) {


        ListNode listNode6 = new ListNode(4, null);
        ListNode listNode5 = new ListNode(2, listNode6);
        ListNode listNode4 = new ListNode(1, listNode5);

        ListNode listNode3 = new ListNode(4, null);
        ListNode listNode2 = new ListNode(3, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode listNode = mergeTwoLists(listNode4, listNode1);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    /**
     * 采用迭代法的思路
     * 维护两个指针 result 和head  ，head指向头结点result。
     * 循环比l1和l2的值，存放在result.next节点中，l1或者l2任意一个为null
     * 表明比较结束，将不为null的结点直接放入result的下一个节点中，因为是有序的
     * <p>
     * 时间复杂度O(m+n)
     * 空间复杂度O(1)
     */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = new ListNode(-1);
        ListNode head;

        head = result;
        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            result = result.next;
        }

        if (l1 != null) {
            result.next = l1;
        }

        if (l2 != null) {
            result.next = l2;
        }
        return head.next;
    }

    /**
     * 递归：比较大小，返回较小的节点，在比较下一个节点
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }

    }
}
