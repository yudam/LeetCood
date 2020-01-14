package com.mdy.treelib;

/**
 * User: maodayu
 * Date: 2020-01-13
 * Time: 16:12
 */
public class Node {

    public int  value;
    public Node left;
    public Node right;
    public int  count;

    public Node(int x) {
        value = x;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                ", count=" + count +
                '}';
    }
}
