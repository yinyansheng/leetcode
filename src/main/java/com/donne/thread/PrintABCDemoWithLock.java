package com.donne.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-09
 */
public class PrintABCDemoWithLock {

    private static Integer incr = 0;
    private static Integer times = 20;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> print('A', 0)).start();
        new Thread(() -> print('B', 1)).start();
        new Thread(() -> print('C', 2)).start();
    }

    private static void print(Character c, int tag) {
        for (int i = 0; i < times; ) {
            lock.lock();
            try {
                if (incr % 3 == tag) {
                    i++;
                    incr++;
                    System.out.print(c);
                }
            } finally {
                lock.unlock();
            }
        }
    }

}
