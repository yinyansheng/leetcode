package com.donne.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T2 {

    private static final Lock lock = new ReentrantLock();
    private static volatile int times = 1;

    public static void main(String[] args) {
        new Thread(T2::printDigit).start();
        new Thread(T2::printLetter).start();
    }

    private static void printLetter() {
        while (times <= 52) {
            lock.lock();
            try {
                if ((times & 1) == 0 && times <= 52) {
                    System.out.print((char) ('A' + times / 2 - 1));
                    times++;
                }
            } finally {
                lock.unlock();
            }
        }

    }

    private static void printDigit() {
        while (times <= 52) {
            lock.lock();
            try {
                if ((times & 1) == 1 && times <= 52) {
                    System.out.print(times / 2 + 1);
                    times++;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
