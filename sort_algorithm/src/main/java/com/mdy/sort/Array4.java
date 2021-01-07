package com.mdy.sort;

/**
 * User: maodayu
 * Date: 2020/4/17
 * Time: 下午4:41
 */
public class Array4 {

    public static void main(String[] args) {

        Node node = new Node(2);
        Node node1 = new Node(3);
        Node node2 = new Node(4);
        Node node3 = new Node(5);

        node.next=node1;
        node1.next=node2;
        node2.next=node3;

       // reversalList(node);

        Node head=reversalListNode(node);
        while (head!=null){
            System.out.println(head.key);
            head=head.next;
        }

    }


    /**
     * 58页
     * 输入一个链表的头节点，从尾到头反过来打印节点的值
     * 迭代法，先进后出
     */
    public static void reversalList(Node node) {
        if (node == null) return;
        if (node.next != null) {
            reversalList(node.next);
        }
        System.out.println(node.key);
    }


    /**
     * 反转链表，不使用额外的数据结构
     * 思路：迭代法遍历，每次都返回末尾的节点，若node的next不为null，则两者首尾替换。
     *
     */
    public static Node reversalListNode(Node node) {
        if (node == null) return null;
        Node head = node;
        if (node.next != null) {
            head=reversalListNode(node.next);
            node.next.next=node;
            node.next=null;
        }
       return head;
    }

    static class Node {

        Node(int data) {
            key = data;
        }

        int  key;
        Node next;
    }
}



