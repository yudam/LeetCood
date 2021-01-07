package com.mdy.treelib.factory.simple;

import com.mdy.treelib.factory.Product;

/**
 * User: maodayu
 * Date: 2020/6/29
 * Time: 下午3:32
 */
public class FactoryManager {

    public static Product getProduct(int type){
        switch (type){
            case 1:
               return new SimpleProduct1();
            default:
               return new SimpleProduct2();
        }
    }
}
