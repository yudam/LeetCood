package com.mdy.treelib;

/**
 * User: maodayu
 * Date: 2020-01-14
 * Time: 11:02
 */
public class TestNode {

    public int val;

    public TestNode  mTestNode;


    public void test(TestNode testNode){

        if(testNode==null) return;

        if(testNode.val==100){
            testNode=null;
        }else{
            test(testNode.mTestNode);
        }
    }

    @Override
    public String toString() {
        return "TestNode{" +
                "val=" + val +
                ", mTestNode=" + mTestNode +
                '}';
    }
}
