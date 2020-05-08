package com.donne.leetcode;

import com.donne.leetcode.helper.LinkedListHelper;
import com.donne.leetcode.model.ListNode;

public class P_206_反转链表 {
    public static void main(String[] args) {
        ListNode node = LinkedListHelper.initLinkedList(0, 5);
//        ListNode reverseList = reverseList(node);
        ListNode node1 = reverseList2(node);
        LinkedListHelper.printLinkedList(node1);
    }

    public static ListNode reverseList(ListNode head) {
        if (null == head) {
            return head;
        }

        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = null;

        return reverseList(head, next);
    }

    public static ListNode reverseList(ListNode list, ListNode head) {
        if (head == null) {
            return list;
        }

        ListNode next = head.next;
        head.next = list;
        return reverseList(head, next);
    }
}
