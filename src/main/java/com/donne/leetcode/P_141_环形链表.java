package com.donne.leetcode;

import com.donne.leetcode.model.ListNode;

public class P_141_环形链表 {
    public static void main(String[] args) {
        ListNode pre = null;
        ListNode head = null;

        for (int i = 0; i < 10; i++) {
            if (pre == null) {
                pre = new ListNode(i);
                head = pre;
                continue;
            }
            pre.next = new ListNode(i);
            pre = pre.next;
        }
        pre.next = head;

        System.out.println(hasCycle(head));

    }

    public static boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }

        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr.next != null && slowPtr.next.next != null) {
            System.out.println(fastPtr.val);
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next.next;
            if (fastPtr == slowPtr) {
                return true;
            }
        }


        return false;
    }
}
