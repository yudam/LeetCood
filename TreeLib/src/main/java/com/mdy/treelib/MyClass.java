package com.mdy.treelib;

import sun.java2d.opengl.CGLSurfaceData.CGLVSyncOffScreenSurfaceData;

public class MyClass {
    public static void main(String[] args) {

        /*int[] number={12,5,2,37,8,10,15};
        BinarySearchTree bsTree=new BinarySearchTree();
        for(int i=0;i<number.length;i++){
            bsTree.add(number[i]);
        }

        System.out.println("前序遍历-----");
        bsTree.preNode();


        System.out.println("\n删除后前序遍历-----");
        bsTree.remove(5);
        bsTree.preNode();
*/


        TestNode testNode=new TestNode();
        testNode.val=11;

        TestNode testNode1=new TestNode();
        testNode1.val=100;
        testNode.mTestNode=testNode1;

        System.out.println(testNode.toString());

        testNode.test(testNode);
        System.out.println(testNode.toString());

    }

}
