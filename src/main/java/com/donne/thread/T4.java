package com.donne.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T4 {

    static Lock lock = new ReentrantLock();
    static Condition c1 = lock.newCondition();
    static Condition c2 = lock.newCondition();

    public static void main(String[] args) {
        char[] chars0 = "123456".toCharArray();
        char[] chars1 = "ABCDEF".toCharArray();


        new Thread(() -> {
            lock.lock();
            try {
                for (char c : chars0) {
                    System.out.print(c);
                    c2.signal();
                    c1.await();
                }
                c2.signal();
            } catch (Exception ex) {

            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                for (char c : chars1) {
                    System.out.print(c);
                    c1.signal();
                    c2.await();
                }
                c1.signal();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();


    }

}
