package com.design.list_struct;

/**
 * 两两交换链表中的节点
 */
public class Solution24 {

    public static void main(String[] args) {

        ListNode listNode6 = new ListNode(6, null);
        ListNode listNode5 = new ListNode(5, listNode6);
        ListNode listNode4 = new ListNode(4, listNode5);

        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode listNode = swapPairs(listNode1);


        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }


    //递归方法
    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nextHead = head.next;
        head.next = swapPairs(nextHead.next);
        nextHead.next = head;
        return nextHead;
    }


    //节点交换（非递归）
    private static ListNode swapPairs2(ListNode head) {
        ListNode currNode = new ListNode(-1);
        ListNode result = currNode;
        currNode.next = head;
        ListNode tempNode;
        while (head != null && head.next != null) {

            ListNode nextHead = head.next;
            tempNode = head;
            currNode.next = nextHead;
            head = nextHead.next;
            nextHead.next = tempNode;
            tempNode.next = head;
            currNode = tempNode;

        }
        return result.next;
    }


    //数值交换
    private static ListNode swapPairs1(ListNode head) {
        ListNode result = head;
        while (head != null && head.next != null) {
            ListNode nextHead = head.next;
            int temp = head.val;
            head.val = nextHead.val;
            nextHead.val = temp;
            head = nextHead.next;
        }
        return result;
    }
}
