package com.mdy.treelib.factory;

import java.util.*;

/**
 * User: maodayu
 * Date: 2020/6/29
 * Time: 下午3:09
 */
public class TestMain {


    public static void main(String[] args){
//        Factory factory1 = new Factory1();
//        factory1.getProductA().method();
//        factory1.getProductB().method();
//        Factory factory2 = new Factory2();
//        factory2.getProductA().method();
//        factory2.getProductB().method();
//
//
//        FactoryManager.getProduct(1).method();
//        FactoryManager.getProduct(2).method();


        List<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(10);
        list.add(100);
        list.add(1,12);

        System.out.println(list.size());

        for(int i =0;i<list.size();i++){
            System.out.println("i="+list.get(i));
        }

    }
}
