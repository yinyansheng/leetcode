package com.donne.leetcode;

import com.donne.leetcode.model.ListNode;

import static com.donne.leetcode.helper.LinkedListHelper.initLinkedList;
import static com.donne.leetcode.helper.LinkedListHelper.printLinkedList;

public class P_2_两数相加 {
    public static void main(String[] args) {
        ListNode listNode1 = initLinkedList(8, 9);
        ListNode listNode2 = initLinkedList(2, 2);

        ListNode listNode = addTwoNumbers(listNode2, listNode1);
        printLinkedList(listNode);
    }

    /**
     * 个位   十位  百位
     * 2    3   4
     * 1    2
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }

        if (null == l2) {
            return l1;
        }


        int carry = 0;
        ListNode cur = new ListNode(0);
        ListNode head = cur;

        while (l1 != null || l2 != null) {
            int sum = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return head.next;
    }
}
