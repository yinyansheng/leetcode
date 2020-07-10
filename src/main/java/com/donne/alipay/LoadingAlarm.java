package com.donne.alipay;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Queue;

public class LoadingAlarm {
    private Integer warnMinuteThreshold;
    private BigDecimal warnRatioThreshold;
    private Queue<BigDecimal> queue = new ArrayDeque<>();

    /**
     * @param warnMinuteThreshold N
     * @param warnRatioThreshold  k%
     */
    public LoadingAlarm(Integer warnMinuteThreshold, BigDecimal warnRatioThreshold) {
        if (warnMinuteThreshold == null || warnMinuteThreshold < 0) {
            throw new IllegalArgumentException("warnMinuteThreshold can't be null or less than zero");
        }

        if (warnRatioThreshold == null) {
            throw new IllegalArgumentException("warnRatioThreshold can't be null");
        }

        this.warnMinuteThreshold = warnMinuteThreshold;
        this.warnRatioThreshold = warnRatioThreshold;
    }

    /**
     * 未作并发考虑，否则需相关同步操作
     *
     * @param todayValue     当前时间片的负载
     * @param yesterdayValue 昨天时间片的负载
     * @return warn value
     */
    public Boolean call(Integer todayValue, Integer yesterdayValue) {
        //0.corner case
        if (0 == yesterdayValue && 0 == todayValue) {
            return false;
        }

        //1.计算比例
        BigDecimal ratio = BigDecimal.ONE;
        if (yesterdayValue > 0) {
            ratio = BigDecimal.valueOf(todayValue).divide(BigDecimal.valueOf(yesterdayValue), BigDecimal.ROUND_DOWN, 2)
                    .subtract(BigDecimal.ONE);
        }

        //2.如果当前ratio小于k%，则清空队列，且返回false;
        if (ratio.compareTo(warnRatioThreshold) <= 0) {
            queue.clear();
            return false;
        }

        //3.如果当前ratio大于k%，则压入队列,且弹出多余的记录
        queue.add(ratio);
        while (queue.size() > warnMinuteThreshold) {
            queue.poll();
        }

        return queue.size() == warnMinuteThreshold;
    }

    /**
     * test case
     *
     * @param args
     */
    public static void main(String[] args) {
        LoadingAlarm loadingAlarm = new LoadingAlarm(3, BigDecimal.valueOf(0.1));
        System.out.println(loadingAlarm.call(12, 10));
        System.out.println(loadingAlarm.call(12, 10));
        System.out.println(loadingAlarm.call(12, 10));
        System.out.println(loadingAlarm.call(12, 11));
        System.out.println(loadingAlarm.call(12, 0));
        System.out.println(loadingAlarm.call(12, 0));
        System.out.println(loadingAlarm.call(12, 0));
        System.out.println(loadingAlarm.call(0, 0));
        System.out.println(loadingAlarm.call(0, 0));
    }
}
