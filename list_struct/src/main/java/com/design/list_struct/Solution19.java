package com.design.list_struct;

/**
 * 删除链表的倒数第N个节点
 */
public class Solution19 {

    public static void main(String[] args) {

        ListNode listNode8 = new ListNode(8, null);
        ListNode listNode7 = new ListNode(7, listNode8);
        ListNode listNode6 = new ListNode(6, listNode7);
        ListNode listNode5 = new ListNode(5, listNode6);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode listNode = removeNthFromEnd1(listNode1, 2);

        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }


    /**
     * first
     * second
     * 使用两个指针，分别指向head和距离head n个距离的位置上，然后遍历
     * 当second指向最后一个节点时，first刚好指向第n个结点的前一个结点
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode first = head;
        ListNode second = head;
        while (n > 0) {
            second = second.next;
            n--;
        }

        if (second == null) return null;

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;

        return head;
    }

    /**
     * 二次扫描法  需要扫描链表两次
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode last = reverseListNode(head);

        if (n == 1) return reverseListNode(last.next);

        ListNode curr = last;
        int k = 0;
        while ((k + 2) < n) {
            curr = curr.next;
            k++;
        }
        curr.next = curr.next.next;
        return reverseListNode(last);
    }

    public static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

}
