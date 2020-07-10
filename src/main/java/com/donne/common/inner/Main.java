package com.donne.common.inner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-19
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            iterator.remove();
            System.out.println(next);
        }


//        for (Integer ele : list) {
//            list.remove(ele);
//        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            list.remove(i);
        }


    }
}
