package com.design.list_struct;

/**
 * User: maodayu
 * Date: 2019/9/16
 * Time: 14:29
 */
public class list_overturn {


    /**
     * 给定一个单链表， 已K为一组，逆序遍历， 不足K的不逆序，然后按照顺序输出链表
     * 不得使用其他数据结构
     */
    public static void main(String[] args) {

        ListNode listNode8 = new ListNode(8, null);
        ListNode listNode7 = new ListNode(7, listNode8);
        ListNode listNode6 = new ListNode(6, listNode7);
        ListNode listNode5 = new ListNode(5, listNode6);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);


        ListNode listNode = array_overturn1(listNode1, 3);
        while (listNode != null) {
            System.out.print(listNode.data + "   ");
            listNode = listNode.next;
        }
    }

    /**
     * 逆序遍历单链表
     */
    public static ListNode overturn(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = overturn(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }


    /**
     * 按组逆序遍历单链表
     */
    public static ListNode overturnGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode result = overturnGroup(head.next, --k);
        head.next.next = head;
        head.next = null;
        return result;
    }


    /**
     * K 个一组翻转链表  3 2 1 6 5 4 7 8
     * 思路：1.按K个一组进行划分为每一个小组，通过递归方法，分别处理每一个小组，不满足K和的小组直接返回。
     * 2.对满足K个小组的链表进行翻转。
     * 3.把每一个递归并翻转的小组拼接在外层递归的后面。
     */
    public static ListNode array_overturn(ListNode head, int k) {
        ListNode temp = head;
        for (int i = 1; i < k && temp != null; i++) {//这里从1开始，是为了判断该小组是否满足K个
            temp = temp.next;
        }

        if (temp == null) return head;//不满足  注解返回链表头部
        ListNode tempHead = array_overturn(temp.next, k);//递归遍历子链表
        ListNode newHead = overturnGroup(head, k);//翻转当前链表
        head.next = tempHead;//拼接链表
        return newHead;
    }

    /**
     * K 个一组 倒序翻转链表
     * 1 2 5 4 3 8 7 6
     */
    public static ListNode array_overturn1(ListNode head, int k) {
        ListNode result = array_overturn(overturn(head), k);

        return overturn(result);
    }


    static class ListNode {
        public int      data;
        public ListNode next;

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }
}
