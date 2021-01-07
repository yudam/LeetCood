package com.mdy.treelib.factory;

/**
 * User: maodayu
 * Date: 2020/6/29
 * Time: 下午3:08
 */
public class Factory2 extends Factory {
    @Override
    public Product getProductA() {
        return new ProductA2();
    }

    @Override
    public Product getProductB() {
        return new ProductB2();
    }
}
