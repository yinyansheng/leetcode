package com.donne.thread;

public class T {

    private static final Object object = new Object();
    private static volatile int times = 1;

    public static void main(String[] args) {
        new Thread(T::printDigit).start();
        new Thread(T::printLetter).start();
    }

    private static void printLetter() {
        while (times <= 52) {
            synchronized (object) {
                if ((times & 1) == 0 && times <= 52) {
                    System.out.print((char) ('A' + times / 2 - 1));
                    times++;
                    object.notifyAll();
                }
            }
        }
    }

    private static void printDigit() {
        while (times <= 52) {
            synchronized (object) {
                if ((times & 1) == 1 && times <= 52) {
                    System.out.print(times / 2 + 1);
                    times++;
                    object.notifyAll();
                }
            }
        }
    }
}
