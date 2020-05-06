package com.donne.dataStructure;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
    }
}
