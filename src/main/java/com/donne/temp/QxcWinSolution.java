package com.donne.temp;

import com.donne.jvm.T;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QxcWinSolution {

    static ExecutorService executorService = Executors.newSingleThreadExecutor(new DefaultThreadFactory("AAAAAA"));

    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(() -> {
//            System.out.println("线程执行：" + Thread.currentThread().getState().toString());
//        });
//        thread.start();

        executorService.execute(() -> {
            System.out.println("线程执行：" + Thread.currentThread().getState().toString());
        });

        TimeUnit.SECONDS.sleep(200);

        //System.out.println(thread.getState().toString());


        // write your code here
        int[] numbers = new int[]{5, 3, 2, 4, 2, 3, 2};
        int[] hits = new int[]{1, 1, 1, 1, 1, 1, 0};
        for (int level = 1; level < 7; level++) {
            System.out.println(getWinCount(numbers, hits, level));
        }
    }

    /**
     * @param numbers [9,1,2,3,4,5,7]
     * @param hits    [0,1,0,1,1,1,1]
     * @param level   1：一等奖 2：二等奖 ...
     * @return
     */
    private static int getWinCount(int[] numbers, int[] hits, int level) {
        int total = 0;
        for (int i = 0, j = 7 - level; i < 7 && j < 7; i++, j++) {
            //判断是否全部为命中
            boolean hit = true;
            for (int k = i; k <= j; k++) {
                if (hits[k] == 0) {
                    hit = false;
                    break;
                }
            }

            if (!hit) {
                continue;
            }

            //命中数量=未中位置数量1*未中位置数量2
            int maxSerial = 8 - level;
            int tempSum = 1;
            if (i > 0) {
                int leftSum = (numbers[i - 1] - hits[i - 1]) * getSum(numbers, hits, 0, i - 2, 0, maxSerial, true);
                tempSum *= leftSum;
            }

            if (j < 6) {
                int rightSum = (numbers[j + 1] - hits[j + 1]) * getSum(numbers, hits, j + 2, 6, 0, maxSerial, false);
                tempSum *= rightSum;
            }
            total += tempSum;
        }

        return total;
    }

    public static void main2(String[] args) {
        int sum = getSum(new int[]{4, 3, 2}, new int[]{1, 1, 1}, 1, 2, 0, 2, true);
        System.out.println(sum);
    }

    private static int getSum(int[] numbers, int[] hits, int left, int right, int currSerial, int maxSerialCount, boolean prefix) {
        if (!prefix && currSerial == maxSerialCount) {
            return 0;
        }

        if (currSerial > maxSerialCount) {
            return 0;
        }

        if (left > right) {
            return 1;
        }

        //如果当前位置未有命中
        if (0 == hits[left]) {
            return numbers[left] * getSum(numbers, hits, left + 1, right, 0, maxSerialCount, prefix);
        }

        //如果当前位置有命中
        //命中情况+未命中情况
        return getSum(numbers, hits, left + 1, right, currSerial + 1, maxSerialCount, prefix) +
                (numbers[left] - 1) * getSum(numbers, hits, left + 1, right, 0, maxSerialCount, prefix);
    }
}