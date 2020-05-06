package com.donne.dataStructure;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap =  new LinkedHashMap<Integer, String>(3, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 3;  // 容量大于capacity 时就删除
            }
        };

        linkedHashMap.put(1, "语文");
        linkedHashMap.put(2, "数学");
        linkedHashMap.put(3, "英语");

        System.out.println(linkedHashMap.get(1));

        linkedHashMap.put(4, "物理");

        linkedHashMap.forEach((k,v)-> System.out.println(v));
    }
}
