package com.donne.alipay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TradeDateCalculator {

    static class TradeDateNode {
        private String tradeDate;
        private Date startTime;
        private Date endTime;

        public String getTradeDate() {
            return tradeDate;
        }

        public TradeDateNode(String tradeDate, Date startTime, Date endTime) {
            this.tradeDate = tradeDate;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        /**
         * if target>=start && target < end then 0
         * if target>=end then 1;
         * if target<start then -1
         *
         * @param target
         * @return
         */
        public int compare(Date target) {
            if (startTime.compareTo(target) > 0) {
                return 1;
            }

            if (endTime.compareTo(target) <= 0) {
                return -1;
            }

            return 0;
        }
    }

    private List<String> tradeDayList = new ArrayList<>();
    private List<TradeDateNode> dateNodes = new ArrayList<>();

    public void init(List<String> tradeDayList) throws ParseException {
        Collections.sort(tradeDayList);
        this.tradeDayList = tradeDayList;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        for (String tradeDay : this.tradeDayList) {
            dateNodes.add(new TradeDateNode(tradeDay, sdf.parse(tradeDay.concat("0930")), sdf.parse(tradeDay.concat("1130"))));
            dateNodes.add(new TradeDateNode(tradeDay, sdf.parse(tradeDay.concat("1300")), sdf.parse(tradeDay.concat("1500"))));
        }
    }

    /**
     * 给定任意时间，返回给定时间的T+n交易日
     * 如果T交易日不存在，那么T+n也不存在，返回null
     */
    public String getTradeDay(Date time, int offsetDays) {
        if (null == dateNodes || dateNodes.size() == 0) {
            return null;
        }

        int nodeIndex = binarySearch(dateNodes, time);

        if (nodeIndex == dateNodes.size()) {
            return null;
        }

        int dayIndex = nodeIndex / 2 + offsetDays;
        if (dayIndex < 0) {
            return null;
        }

        return tradeDayList.get(dayIndex);
    }

    /**
     * 查找等于 或者 第一个大于目标日期的节点
     *
     * @param list
     * @param target
     * @return
     */
    private int binarySearch(List<TradeDateNode> list, Date target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int compare = list.get(mid).compare(target);
            if (compare == 0) {
                return mid;
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }


    /**
     * test case
     *
     * @param args
     */
    public static void main(String[] args) throws ParseException {
        TradeDateCalculator tradeDateCalculator = new TradeDateCalculator();
        tradeDateCalculator.init(Arrays.asList("20160701", "20160704", "20160705"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(tradeDateCalculator.getTradeDay(sdf.parse("2016-01-01 09:00:00"), 0));
        System.out.println(tradeDateCalculator.getTradeDay(sdf.parse("2016-07-01 09:30:00"), 0));
        System.out.println(tradeDateCalculator.getTradeDay(sdf.parse("2016-07-01 08:00:00"), 0));
        System.out.println(tradeDateCalculator.getTradeDay(sdf.parse("2016-07-01 15:00:00"), -1));
        System.out.println(tradeDateCalculator.getTradeDay(sdf.parse("2016-07-01 15:00:00"), 0));
        System.out.println(tradeDateCalculator.getTradeDay(sdf.parse("2016-07-01 15:00:00"), 1));
        System.out.println(tradeDateCalculator.getTradeDay(sdf.parse("2020-07-01 15:00:00"), 0));
    }

}
