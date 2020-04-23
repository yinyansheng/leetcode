package com.donne.leetcode.helper;

import com.donne.leetcode.model.ListNode;

public final class LinkedListHelper {

    public static ListNode initLinkedList(int start, int end) {
        ListNode pre = null;
        ListNode head = null;

        for (int i = start; i <= end; i++) {
            if (pre == null) {
                pre = new ListNode(i);
                head = pre;
                continue;
            }
            pre.next = new ListNode(i);
            pre = pre.next;
        }

        return head;
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
