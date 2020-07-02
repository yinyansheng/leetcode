package com.donne.leetcode;

import java.util.Stack;

public class P_剑指Offer_09_用两个栈实现队列 {
}


class CQueue {
    private Stack<Integer> stack0;
    private Stack<Integer> stack1;


    public CQueue() {
        stack0 = new Stack<>();
        stack1 = new Stack<>();
    }

    public void appendTail(int value) {
        if (!stack0.isEmpty()) {
            stack0.push(value);
        } else {
            stack1.push(value);
        }
    }

    public int deleteHead() {
        Stack<Integer> curr = stack0.isEmpty() ? stack1 : stack0;
        Stack<Integer> other = stack1.isEmpty() ? stack1 : stack0;

        while (!curr.isEmpty()) {
            other.push(curr.pop());
        }

        int res = other.isEmpty()?-1: other.pop();

        while(!other.isEmpty()){
            curr.push(other.pop());
        }

        return res;
    }
}
