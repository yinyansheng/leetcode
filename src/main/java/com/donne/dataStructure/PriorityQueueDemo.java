package com.donne.dataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(2);
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(6);

        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());

        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(2, (o1, o2) -> o1 < o2 ? 1 : 0);
        priorityQueue2.add(5);
        priorityQueue2.add(1);
        priorityQueue2.add(6);
        priorityQueue2.add(61);

        System.out.println(priorityQueue2.peek());
        System.out.println(priorityQueue2.poll());
        System.out.println(priorityQueue2.peek());

    }
}
