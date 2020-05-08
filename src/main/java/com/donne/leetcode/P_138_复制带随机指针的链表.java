package com.donne.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P_138_复制带随机指针的链表 {
    public static void main(String[] args) {

    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        /**
         * source -> target
         */
        Map<Node, Node> nodeMap = new HashMap<>();
        Node p = head;

        while (p != null) {
            nodeMap.put(p, new Node(p.val));
            p = p.next;
        }

        p = head;
        while (p != null) {
            //重建指针
            nodeMap.get(p).next = nodeMap.get(p.next);
            nodeMap.get(p).random = nodeMap.get(p.random);
            p = p.next;
        }

        return nodeMap.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
