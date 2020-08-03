package com.donne.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yinyansheng
 * @Date: 2020-08-03
 */
public class T5 {
    private static volatile int times = 0;
    private final static Object OBJECT = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> print('a', 0)).start();
        new Thread(() -> print('b', 1)).start();
        new Thread(() -> print('c', 2)).start();

        TimeUnit.SECONDS.sleep(5);
        System.out.println("end");
    }

    private static void print(Character c, int target) {
        while (times <= 10) {
            synchronized (OBJECT) {
                while (times % 3 == target) {
                    System.out.println(c);
                    times++;
                }
                OBJECT.notifyAll();
            }
        }
    }

}
