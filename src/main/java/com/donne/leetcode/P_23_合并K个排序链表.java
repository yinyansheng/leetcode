package com.donne.leetcode;

import com.donne.leetcode.helper.LinkedListHelper;
import com.donne.leetcode.model.ListNode;

import java.util.Arrays;

public class P_23_合并K个排序链表 {
    public static void main(String[] args) {
        ListNode l0= LinkedListHelper.initLinkedList(1,5);
        ListNode l1=LinkedListHelper.initLinkedList(3,8);
        ListNode node = mergeKLists(new ListNode[]{l0,l1});
        LinkedListHelper.printLinkedList(node);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode first=lists[0];
        for (int i = 1; i < lists.length; i++) {
            first=merge2Lists(first,lists[i]);
        }
        return first;
    }

    public static ListNode merge2Lists(ListNode list0,ListNode list1) {
       if(null==list0){
           return list1;
       }

       if(null==list1){
           return list0;
       }

       if(list0.val<list1.val){
           list0.next=merge2Lists(list0.next,list1);
            return list0;
       }

       list1.next=merge2Lists(list1.next,list0);
        return list1;
    }



}
