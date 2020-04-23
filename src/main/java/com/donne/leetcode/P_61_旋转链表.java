package com.donne.leetcode;

import static com.donne.leetcode.helper.LinkedListHelper.*;

import com.donne.leetcode.model.ListNode;

public class P_61_旋转链表 {
    public static void main(String[] args) {
        ListNode head = initLinkedList(0, 5);
        printLinkedList(head);

        ListNode node = rotateRight(head, 2);
        System.out.println("=========");
        printLinkedList(node);
    }


    public static ListNode rotateRight(ListNode head, int k) {
        if (null == head) {
            return null;
        }

        //有环判断?

        //尾节点指向头节点
        ListNode curr = head;
        int size = 1;
        while (curr.next != null) {
            curr = curr.next;
            size++;
        }

        curr.next = head;

        curr = head;
        for (int i = 0; i < size - k % size - 1; i++) {
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;
        return head;
    }
}
