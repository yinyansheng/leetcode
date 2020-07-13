package com.donne.thread;

import java.util.concurrent.locks.LockSupport;

public class T3 {

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        char[] chars0 = "123456".toCharArray();
        char[] chars1 = "ABCDEF".toCharArray();

        t1 = new Thread(() -> {
            for (char c : chars0) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : chars1) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();
    }

}
