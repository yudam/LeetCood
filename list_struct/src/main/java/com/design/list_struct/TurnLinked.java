package com.design.list_struct;

/**
 * User: maodayu
 * Date: 2021/2/25 15:59
 */
public class TurnLinked {

    public static void main(String[] args) {
        ListNode listNode8 = new ListNode(8, null);
        ListNode listNode7 = new ListNode(7, listNode8);
        ListNode listNode6 = new ListNode(6, listNode7);
        ListNode listNode5 = new ListNode(5, listNode6);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode result = reverseKGroup(listNode1, 3);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    //定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

    /**
     * 递归
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    /**
     * 双指针
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    //链表每隔k结点翻转一次123 456 789->321 654 987

    /**
     * start 、end指向最先开始的结点
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode init = new ListNode(0, head);
        ListNode start = init;
        ListNode end = init;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode pre = start.next;
            ListNode last = end.next;
            end.next = null;
            start.next = reverseList1(pre);
            pre.next = last;
            end = start = pre;
        }
        return init.next;
    }

}
