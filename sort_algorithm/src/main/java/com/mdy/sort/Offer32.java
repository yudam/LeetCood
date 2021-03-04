package com.mdy.sort;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * User: maodayu
 * Date: 2021/2/10 10:06
 */
public class Offer32 {

    public static void main(String[] args) {

    }

    //从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arrList = new LinkedList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.add(root);
        }
        while (deque.size() > 0) {
            List<Integer> preList = new LinkedList<>();
            int size = deque.size();
            for (int i = size - 1; i >= 0; i--) {
                TreeNode node = deque.pop();
                preList.add(node.val);
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            arrList.add(preList);
        }
        return arrList;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
