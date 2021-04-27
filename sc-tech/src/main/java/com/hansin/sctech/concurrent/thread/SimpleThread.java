package com.hansin.sctech.concurrent.thread;

/**
 * @Date 17:54 2021/1/15
 **/
public class SimpleThread extends Thread {
    public Object object = new Object();
    public Integer count = 0;

    @Override
    public void run() {
        synchronized (object) {
            count++;
            System.out.println("count = " + count);
            System.out.println("object = " + object);
        }
    }
}
