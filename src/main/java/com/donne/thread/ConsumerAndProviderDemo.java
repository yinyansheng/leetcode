package com.donne.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConsumerAndProviderDemo {

    private final static Object OBJECT = new Object();
    private final static Integer MAX_SIZE = 10;
    private final static List<Object> list = new LinkedList<>();

    private static void produce() throws InterruptedException {
        synchronized (OBJECT) {
            while (true) {
                if (list.size() + 1 > MAX_SIZE) {
                    System.out.println(Thread.currentThread().getName() + "仓库已满");
                    OBJECT.wait();
                }

                list.add(new Object());
                System.out.println(Thread.currentThread().getName() + "新增一个,size:" + list.size());
                OBJECT.notifyAll();
            }
        }
    }


    private static void consume() throws InterruptedException {
        synchronized (OBJECT) {
            while (true) {
                if (list.size() == 0) {
                    System.out.println(Thread.currentThread().getName() + "仓库为空");
                    OBJECT.wait();
                }


                list.remove(0);
                System.out.println(Thread.currentThread().getName() + "消费一个,size:" + list.size());
                OBJECT.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread p1 = new Thread(() -> {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "p1");

        Thread p2 = new Thread(() -> {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "p2");

        Thread p3 = new Thread(() -> {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "p3");

        Thread c1 = new Thread(() -> {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "c1");

        Thread c2 = new Thread(() -> {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "c2");

        Thread c3 = new Thread(() -> {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "c3");

        p1.start();
        p2.start();
        p3.start();
        Thread.sleep(3000);

        c1.start();
        c2.start();
        c3.start();

        TimeUnit.SECONDS.sleep(1000);
    }
}
