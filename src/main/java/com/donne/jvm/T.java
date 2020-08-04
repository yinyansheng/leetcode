package com.donne.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class T {
    public int m = 8;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = () -> {
            final List<Integer> firstRange = buildIntRange();
            firstRange.parallelStream().forEach((number) -> {
                try {
                    // do something slow
                    Thread.sleep(5);
                    System.out.println(Thread.currentThread().getName() + "....1111");
                } catch (InterruptedException e) {
                }
            });
        };


        ForkJoinPool forkJoinPool = new ForkJoinPool(3);
        forkJoinPool.submit(() -> {
            final List<Integer> secondRange = buildIntRange();
            secondRange.parallelStream().forEach((number) -> {
                try {
                    // do something slow
                    Thread.sleep(5);
                    System.out.println(Thread.currentThread().getName() + "....2222");
                } catch (InterruptedException e) {
                }
            });
        });

        new Thread(runnable1).start();


        TimeUnit.SECONDS.sleep(10);

    }

    private static List<Integer> buildIntRange() {
        Random random = new Random();
        int x = random.nextInt(200);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            list.add(i);
        }

        return list;
    }
}


