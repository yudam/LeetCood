package com.mdy.string_struct;

/**
 * User: maodayu
 * Date: 2021/2/2 19:08
 */
public class MyThread {

    public static void main(String[] args) {

        TestThread testThread = new TestThread();
        testThread.start();
        try {
            testThread.join(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread is run ");
        System.out.println("---------------------");
    }

    static class TestThread extends Thread {
        @Override
        public void run() {
            System.out.println("child thread is run ");
            long time = System.currentTimeMillis()+20000;
            while (System.currentTimeMillis()<time){
                notifyAll();
            }
            System.out.println("child thread is end ");
        }
    }

}