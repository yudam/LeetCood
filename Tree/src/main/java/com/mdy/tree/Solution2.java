package com.mdy.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * User: maodayu
 * Date: 2021/3/5 17:08
 */
public class Solution2 {

    public static void main(String[] args) {

    }

    //后序遍历  递归
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }


    //二叉树的深度   BFS算法
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int k = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            k++;
            for (int i = deque.size() - 1; i >= 0; i--) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return k;
    }
}
