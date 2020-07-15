package com.donne.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-15
 */
public class P_面试题_16_25_LRU缓存 {

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        lruCache.get(1);
        lruCache.get(2);

    }
}


class LruCache {
    transient Map<Integer, Node> table = new HashMap<>();
    transient Integer capacity;
    transient Node head;
    transient Node tail;

    static class Node {
        public Node() {
        }

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer key;
        public Integer value;

        public Node pre;
        public Node next;
    }

    public LruCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public void put(Integer key, Integer value) {
        Node node = table.get(key);

        //如果不存在
        if (null == node) {
            if (table.size() == capacity) {
                //移除队尾
                table.remove(tail.pre.key);
                Node temp = tail.pre.pre;
                temp.next = tail;
                tail.pre = temp;
            }

            node = new Node(key, value);
            table.put(key, node);
        }

        disconnect(node);

        //插入头部
        node.value = value;
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private void disconnect(Node node) {
        //断开
        Node pre = node.pre;
        Node next = node.next;

        if (pre != null) {
            pre.next = next;
        }
        if (next != null) {
            next.pre = pre;
        }
    }


    public void remove(Integer key) {
        Node node = table.get(key);
        table.remove(node.key);

        disconnect(node);
    }


    public Integer get(Integer key) {
        Node node = table.get(key);
        if (node == null) {
            return -1;
        }

        disconnect(node);

        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
        return node.value;
    }

}