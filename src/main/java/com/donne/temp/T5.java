package com.donne.temp;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-11
 */
public class T5 {
    private static AtomicInteger a = new AtomicInteger(0);

    public static void main(String[] args) {
        new Thread(T5::add).start();
        new Thread(T5::add).start();
        new Thread(T5::add).start();
        new Thread(T5::add).start();
        new Thread(T5::add).start();
    }

    private static void add() {
        for (int i = 0; i < 10; i++) {
            System.out.println(a.incrementAndGet());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
