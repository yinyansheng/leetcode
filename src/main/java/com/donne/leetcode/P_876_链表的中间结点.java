package com.donne.leetcode;

import com.donne.leetcode.helper.LinkedListHelper;
import com.donne.leetcode.model.ListNode;

public class P_876_链表的中间结点 {
    public static void main(String[] args) {
        ListNode node = LinkedListHelper.initLinkedList(1, 6);
        ListNode node1 = middleNode(node);
        LinkedListHelper.printLinkedList(node1);
    }

    public static ListNode middleNode(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            slow = slow.next;
            fast = fast.next.next;

            if (null == fast || null == fast.next) {
                return slow;
            }
        }
    }
}
