package com.donne.temp;

import com.donne.leetcode.helper.LinkedListHelper;
import com.donne.leetcode.model.ListNode;

public class T7 {
    public static void main(String[] args) {
        ListNode head = LinkedListHelper.initLinkedList(1, 5);
        reverseList(head);
    }

    public static ListNode reverseList(ListNode head) {
        return reverseList(null, head);
    }

    public static ListNode reverseList(ListNode curr, ListNode left) {
        if (left == null) {
            return curr;
        }

        ListNode leftNext = left.next;
        left.next = curr;

        return reverseList(left, leftNext);
    }
}
