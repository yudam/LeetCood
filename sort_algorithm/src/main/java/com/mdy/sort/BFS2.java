package com.mdy.sort;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * User: maodayu
 * Date: 2021/2/19 17:14
 */
public class BFS2 {

    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, node6, node7, null);
        Node node1 = new Node(1, node2, node3, null);

        Node node = connect(node1);
        System.out.println(node);
    }

    /**
     * 递归做法
     */
    public static Node connectDG(Node root) {

        if (root == null) return null;

        //同一个父节点
        if (root.left != null) {
            root.left.next = root.right;
        }
        //不同的父节点
        if (root.right != null) {
            root.right.next = root.next != null ? root.next.left : null;
        }
        connectDG(root.left);
        connectDG(root.right);
        return root;
    }

    /**
     * BFS做法
     */
    public static Node connect(Node root) {

        Deque<Node> deque = new ArrayDeque<>();
        if (root == null) return null;
        deque.add(root);
        while (!deque.isEmpty()) {
            for (int i = deque.size() - 1; i >= 0; i--) {
                Node node = deque.poll();
                if (i > 0) {
                    node.next = deque.peek();
                }
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
        }
        return root;
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

}
