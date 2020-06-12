package com.donne.temp;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-12
 */
public class T6 {

    public static void main(String[] args) {
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
