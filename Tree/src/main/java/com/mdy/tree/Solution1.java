package com.mdy.tree;

/**
 * User: maodayu
 * Date: 2021/3/1 18:58
 */
public class Solution1 {

    public static void main(String[] args) {
    }

    //给定一棵二叉搜索树，请找出其中第k大的节点。 1 <= k <= N
    int result, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    public void dfs(TreeNode root) {
        if (root == null || k <= 0) return;
        dfs(root.right);
        if (--k == 0) {
            result = root.val;
            return;
        }
        dfs(root.left);
    }


}
