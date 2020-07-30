package com.donne.thread;

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
}
