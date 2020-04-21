package com.donne.leetcode;

import com.donne.leetcode.model.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * aa bb
 */
public class P_链表倒数第N个节点 {
    public static void main(String[] args) {
        ListNode head = initList(5);
        printList(head);
        ListNode node = removeNthFromEnd2(head, 3);
        printList(node);
    }

    private static ListNode initList(int size) {
        ListNode head = null;
        ListNode curr = null;
        for (int i = 1; i < size + 1; i++) {
            ListNode node = new ListNode(i);
            if (curr == null) {
                head = node;
            } else {
                curr.next = node;
            }
            curr = node;
        }
        return head;
    }

    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println("empty");
            return;
        }

        ListNode curr;
        curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }

        System.out.println(" ");
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //1.计算单链表长度
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        //2.计算倒数第N个节点位置  L-N+1
        int index = size + 1 - n;

        if (index <= 0) {
            return null;
        }

        //3.删除第k节点，将第k-1指向第k+1个节点
        ListNode prev = null;
        curr = head;
        int k = 0;
        while (curr != null) {
            k++;
            if (k == index) {
                if (prev == null) {
                    //第一个节点
                    return curr.next;
                }
                //其它节点
                prev.next = curr.next;
                return head;
            }
            prev = curr;
            curr = curr.next;
        }

        return null;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        //两个指针 第一个指针走到第N个时,第二个指针开始走
        //当第一个指针 到到尾部时，第二个指针指向的为倒数第N个节点
        ListNode first = head;
        ListNode second = head;
        ListNode prev = null;

        int k = 0;
        while (first != null) {
            if (k++ >= n) {
                prev = second;
                second = second.next;
            }
            first = first.next;
        }

        if (prev == null) {
            //第一个节点
            return second.next;
        }
        //其它节点
        prev.next = second.next;
        return head;
    }
}

