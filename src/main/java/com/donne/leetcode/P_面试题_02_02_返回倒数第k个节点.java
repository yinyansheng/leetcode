package com.donne.leetcode;

import com.donne.leetcode.model.ListNode;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-02
 */
public class P_面试题_02_02_返回倒数第k个节点 {
    public static void main(String[] args) {

    }

    public int kthToLast(ListNode head, int k) {
        ListNode p0 = head;
        ListNode p1 = head;

        while (k-- > 0) {
            p0 = p0.next;
        }

        while (p0 != null) {
            p0 = p0.next;
            p1 = p1.next;
        }

        return p1.val;
    }
}
