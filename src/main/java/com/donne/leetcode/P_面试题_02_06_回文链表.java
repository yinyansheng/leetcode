package com.donne.leetcode;

import com.donne.leetcode.model.ListNode;

import java.awt.*;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-13
 */
public class P_面试题_02_06_回文链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        //ListNode node3 = new ListNode(1);

        head.next = node1;
        //node1.next = node2;
        //node2.next = node3;

        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }

        //快慢指针找到中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode midNode = fast != null ? slow.next : slow;

        //反转前一半得链表
        ListNode pre = head;
        ListNode curr = head.next;
        while (!curr.equals(slow)) {
            ListNode tmp = curr.next;
            curr.next = pre;

            pre = curr;
            curr = tmp;
        }
        head.next = null;

        //比较两个链表
        while (pre != null && midNode != null) {
            if (pre.val != midNode.val) {
                return false;
            }

            pre = pre.next;
            midNode = midNode.next;
        }

        return pre == null && midNode == null;
    }

}
