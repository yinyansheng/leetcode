package com.donne.temp;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-12
 */
public class T6 {

    public static void main(String[] args) {
        List<Integer> integers = Collections.unmodifiableList(Arrays.asList(1, 2, 3));
        integers.add(4);

        Set<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        concurrentSkipListSet.add(1);
        concurrentSkipListSet.add(2);
        concurrentSkipListSet.add(3);

        Iterator<Integer> iterator = concurrentSkipListSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


}

class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                prices[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
