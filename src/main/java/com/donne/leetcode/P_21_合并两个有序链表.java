package com.donne.leetcode;

import com.donne.leetcode.model.ListNode;

public class P_21_合并两个有序链表 {

    public static void main(String[] args) {
        //init l1 and l2
        ListNode l1_0 = new ListNode(0);
        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        l1_0.next = l1_1;
        l1_1.next = l1_2;

        ListNode l2_0 = new ListNode(1);
        ListNode l2_1 = new ListNode(3);
        ListNode l2_2 = new ListNode(5);
        l2_0.next = l2_1;
        l2_1.next = l2_2;

        ListNode newList = mergeTwoLists(l1_0, l2_0);

        ListNode curr = newList;
        while (curr.next != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }

        if (null == l2) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}