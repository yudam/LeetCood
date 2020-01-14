package com.mdy.treelib;

/**
 * 二分搜索树
 */
public class BinarySearchTree {

    private Node root;//根结点

    /**
     * 添加结点
     */
    public void add(int e) {
        root = add(root, e);
    }

    /**
     * 1.首先判断结点是否为null，若为null，则直接new一个Node对象赋值为e并返回给上一结点。
     * 2.value小于结点，遍历该结点的左子树，value大于结点，遍历该结点的右子树。
     * 3.若该结点已存在，直接返回该结点，遍历结束。
     * 4.重复上述步骤。
     */
    private Node add(Node node, int e) {
        if (node == null) {
            return new Node(e);
        }
        if (e < node.value) {
            node.left = add(node.left, e);
        } else if (e > node.value) {
            node.right = add(node.right, e);
        } else {
            return node;
        }
        return node;
    }


    /**
     * 删除任意节点
     */
    public Node remove(int value) {
        if (root == null) return null;
        return remove(root, value);
    }


    /**
     * 1.判断结点是否为null，若为null直接返回。
     * 2.若要删除的值小于结点值，则遍历该结点的左子树，若大于结点值，则遍历右子树。
     * 3.若等于该结点值，此时判断该结点的左子树和右子树是否为null。
     * 4.若左子树为null，则把该结点的右子树替代该结点。若右子树为null，则把该结点的左子树当作该结点。
     * 5.若该结点的左右子树不为null，则获取该结点的右子树中的最小结点并删除该结点。
     * 把该最小结点作为被删除的结点替换，然后把该最小结点作为被删除结点的右子树的跟节点。然后返回该最小结点。
     */
    private Node remove(Node node, int value) {
        if (node == null) return null;

        if (node.value > value) {
            node.left = remove(node.left, value);
            return node;
        } else if (node.value < value) {
            node.right = remove(node.right, value);
            return node;
        } else {
            if (node.left == null) {
                Node rNode = node.right;
                node.right = null;
                return rNode;
            }

            if (node.right == null) {
                Node lNode = node.left;
                node.left = null;
                return lNode;
            }

            Node minNode = iterater(node.right);
            minNode.right = remove(node.right, minNode.value);
            minNode.left = node.left;
            node.right = node.left = null;
            return minNode;
        }
    }


    /**
     * 以某个节点为跟节点的最小值结点
     */
    private Node iterater(Node node) {

        if (node.left == null) {
            return node;
        }
        return iterater(node.left);
    }


    /**
     * 前序遍历
     */
    public void preNode() {
        preNode(root);
    }

    private void preNode(Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preNode(node.left);
        preNode(node.right);
    }


    /**
     * 中序遍历
     */
    public void centerNode() {
        centerNode(root);
    }

    private void centerNode(Node node) {
        if (node == null) return;
        centerNode(node.left);
        System.out.print(node.value + "  ");
        centerNode(node.right);
    }


    /**
     * 后序遍历
     */
    public void postNode() {
        postNode(root);
    }

    private void postNode(Node node) {
        if (node == null) return;
        postNode(node.left);
        postNode(node.right);
        System.out.print(node.value + "  ");
    }
}
