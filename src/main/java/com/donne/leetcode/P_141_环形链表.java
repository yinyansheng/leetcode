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

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }
        
        return false;
    }
}
