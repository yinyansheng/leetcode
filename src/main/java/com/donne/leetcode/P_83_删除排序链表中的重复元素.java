package com.donne.leetcode;

import com.donne.leetcode.model.ListNode;

public class P_83_删除排序链表中的重复元素 {

    public static void main(String[] args) {
        ListNode l1_0 = new ListNode(1);
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(3);
        ListNode l1_4 = new ListNode(3);
        l1_0.next = l1_1;
        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;

        ListNode node = deleteDuplicates2(l1_0);
    }

    //双指针
    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode ptr1 = head;
        while (ptr1 != null && ptr1.next != null) {
            ListNode ptr2 = ptr1.next;
            if (ptr1.val == ptr2.val) {
                while (ptr2 != null) {
                    if (ptr2.val != ptr1.val) {
                        break;
                    }
                    ptr2 = ptr2.next;
                }
                ptr1.next = ptr2;
            }

            ptr1 = ptr1.next;
        }

        return head;
    }


    //额外链表
    public static ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }

        ListNode result = new ListNode(head.val);
        ListNode ptr2 = result;

        ListNode ptr1 = head;
        while (ptr1 != null) {
            if (ptr1.val == ptr2.val) {
                ptr1 = ptr1.next;
                continue;
            }

            ptr2.next = new ListNode(ptr1.val);
            ptr2 = ptr2.next;
            ptr1 = ptr1.next;
        }

        return result;
    }
}
