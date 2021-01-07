package com.mdy.sort;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中
 * 都不含重复的数字。例如：
 * 前序遍历序列｛ 1, 2, 4, 7, 3, 5, 6, 8｝和
 * 中序遍历序列｛4, 7, 2, 1, 5, 3, 8，6}，
 * 重建出下图所示的二叉树并输出它的头结点
 */
public class Array5 {

    public static class BinaryTreeNode {
        int            value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }


    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode head = construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);


        preArray(head);
        System.out.println("\n----------------");
        inArray(head);
    }

    public static BinaryTreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {

        if (ps > pe || is > ie) return null;
        int value = preorder[ps];
        int start = is;
        while (start <= ie && value != inorder[start]) {
            start++;
        }
        if (start > ie) {
            throw new RuntimeException("不存在该二叉树");
        }
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode();
        binaryTreeNode.value = preorder[ps];
        binaryTreeNode.left = construct(preorder, ps + 1, ps + start - is, inorder, is, start - 1);
        binaryTreeNode.right = construct(preorder, ps + start - is + 1, pe, inorder, start + 1, ie);

        return binaryTreeNode;
    }


    public static void preArray(BinaryTreeNode node) {
        if (node != null) {
            System.out.print(node.value + "   ");
            preArray(node.left);
            preArray(node.right);
        }
    }


    public static void inArray(BinaryTreeNode node) {
        if (node != null) {
            inArray(node.left);
            System.out.print(node.value + " ");
            inArray(node.right);
        }
    }
}
