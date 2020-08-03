package com.donne.thread;

<<<<<<< HEAD
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

=======
import javafx.concurrent.Task;

import java.util.concurrent.*;

public class T5 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        }).start();

        Callable callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(4);
                return "callable";
            }
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> submit = executor.submit(callable);

        String str = submit.get();

        System.out.println(str);

        System.out.println("end");

        TimeUnit.SECONDS.sleep(2);

    }
>>>>>>> 43dcf3a14b5a71303107ed0322091f8a4b9cc146
}
