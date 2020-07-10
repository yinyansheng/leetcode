package com.donne.cm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印字符串
 * <p>
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * <p>
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 * <p>
 * 假设有这么一个类：
 * <p>
 * class FizzBuzz {
 * public FizzBuzz(int n) { ... }               // constructor
 * public void fizz(printFizz) { ... }          // only output "fizz"
 * public void buzz(printBuzz) { ... }          // only output "buzz"
 * public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 * public void number(printNumber) { ... }      // only output the numbers
 * }
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 * <p>
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 */
public class Main {

    private final static Object lock = new Object();
    private static int times = 15;
    private static volatile int tag = 1;

    public static void main(String[] args) {
        new Thread(() -> fizz()).start();
        new Thread(() -> buzz()).start();
        new Thread(() -> fizzbuzz()).start();
        new Thread(() -> number()).start();
    }

    // only output "fizz"
    public static void fizz() {
        while (tag <= times) {
            synchronized (lock) {
                if (tag % 15 != 0 && tag % 3 == 0) {
                    System.out.println("fizz");
                    tag++;
                }
                lock.notifyAll();
            }
        }
    }

    // only output "buzz"
    public static void buzz() {
        while (tag <= times) {
            synchronized (lock) {
                if (tag % 15 != 0 && tag % 5 == 0) {
                    System.out.println("buzz");
                    tag++;
                }
                lock.notifyAll();
            }
        }
    }

    public static void fizzbuzz() {
        while (tag <= times) {
            synchronized (lock) {
                if (tag % 15 == 0) {
                    System.out.println("fizzbuzz");
                    tag++;
                }
                lock.notifyAll();
            }
        }
    }

    // only output the numbers
    public static void number() {
        while (tag <= times) {
            synchronized (lock) {
                if (tag % 3 != 0 && tag % 5 != 0) {
                    if (tag <= 15) {
                        System.out.println(tag);
                    }
                    tag++;
                }
                lock.notifyAll();
            }
        }
    }

}
