package com.donne.leetcode;

import com.donne.leetcode.helper.LinkedListHelper;
import com.donne.leetcode.model.ListNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class P_25_K个一组翻转链表 {

    public static void main(String[] args) {
        ListNode node = LinkedListHelper.initLinkedList(1, 5);
        ListNode node1 = reverseKGroup(node, 3);
        LinkedListHelper.printLinkedList(node1);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (null == head) {
            return null;
        }

        ListNode ptr = head;
        Stack<ListNode> stack = new Stack<>();
        Queue<ListNode> queue = new ArrayDeque<>();

        int t = 0;
        while (ptr != null) {
            stack.push(ptr);
            t++;

            if (t == k) {
                t = 0;
                while (!stack.isEmpty()) {
                    queue.add(stack.pop());
                }
            }

            ptr = ptr.next;
        }

        Stack<ListNode> stack2 = new Stack<>();
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }

        while (!stack2.isEmpty()) {
            queue.add(stack2.pop());
        }

        ListNode res = new ListNode(queue.poll().val);
        ListNode ptr2 = res;

        while (!queue.isEmpty()) {
            ptr2.next = new ListNode(queue.poll().val);
            ptr2 = ptr2.next;
        }
        return res;
    }

}
