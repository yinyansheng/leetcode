package com.donne.leetcode;

import com.donne.leetcode.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-02
 */
public class P_面试题_02_01_移除重复节点 {
    public static void main(String[] args) {

    }

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode curr = head;
        ListNode pre = head;

        while (curr != null) {
            if (set.contains(curr.val)) {
                pre.next = curr.next;
            } else {
                set.add(curr.val);
                pre = curr;
            }
            curr = curr.next;
        }

        return head;
    }
}
