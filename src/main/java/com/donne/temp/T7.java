package com.donne.temp;

import com.donne.leetcode.helper.LinkedListHelper;
import com.donne.leetcode.model.ListNode;

import java.util.ArrayList;
import java.util.List;

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

class Solution23 {
    public static void main(String[] args) {
        String[] qwes = new Solution23().permutation("qwe");
    }

    public String[] permutation(String S) {
        List<String> results = new ArrayList();
        dfs(S.toCharArray(), results, 0);
        String[] ans = new String[results.size()];

        for (int i = 0; i < results.size(); i++) {
            ans[i] = results.get(i);
        }

        return ans;
    }

    public void dfs(char[] chars, List<String> results, int start) {
        if (start == chars.length - 1) {
            results.add(new String(chars));
            return;
        }

        for (int i = start; i < chars.length; i++) {
            //做出选择
            swap(chars, i, start);

            //递归
            dfs(chars, results, start + 1);

            //撤销选择
            swap(chars, i, start);
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
