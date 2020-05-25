package com.donne.common.temp;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRUDemo {
    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(5);
        int i = lruCache.get(1);


        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("name1", "yys1");
        linkedHashMap.put("name2", "yys2");
        linkedHashMap.put("name3", "yys3");

        Set<Map.Entry<String, String>> entries = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + ":" + next.getValue());
        }

        linkedHashMap.get("name1");

        System.out.println("===");

        Set<Map.Entry<String, String>> entries1 = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator1 = entries1.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, String> next = iterator1.next();
            System.out.println(next.getKey() + ":" + next.getValue());
        }


    }
}
