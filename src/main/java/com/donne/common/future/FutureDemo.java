package com.donne.common.future;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> submit = executorService.submit(() -> {
            Thread.sleep(200);
            return 100;
        });

        //Thread.sleep(2000);
        System.out.println("do some other things");
        System.out.println(submit.get());


        String join = CompletableFuture.supplyAsync(() -> {
            return "hello";
        }).thenApplyAsync(v -> {
            return v + " world!";
        }).join();

        System.out.println(join);


        ListeningExecutorService executorService2 = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

        ListenableFuture<Integer> listenableFuture = executorService2.submit(() -> {
            Thread.sleep(2000);
            return 100;
        });


        listenableFuture.addListener(() -> {
            try {
                System.out.println("get listenable future's result " + listenableFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }, executorService2);

        TimeUnit.SECONDS.sleep(3);

        System.out.println("end...");
    }
}
