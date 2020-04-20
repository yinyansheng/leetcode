package com.donne.leetcode;

import java.util.Stack;

public class P_155_最小栈 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(3);
        minStack.push(5);
        minStack.push(2);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }
}


class MinStack2 {

    private Stack<Integer> stack1 = new Stack<>();
    private Integer minValue = Integer.MIN_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {

    }

    public void push(int x) {
        if (stack1.empty()) {
            minValue = x;
            stack1.push(x);
            return;
        }

        if (minValue >= x) {
            stack1.push(minValue);
            minValue = x;
        }
        stack1.push(x);

    }

    public void pop() {
        Integer pop = stack1.pop();

        if (pop.equals(minValue)) {
            if (!stack1.empty()) {
                minValue = stack1.pop();
            }
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return minValue;

    }
}

class MinStack {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack1.push(x);

        if (stack2.empty()) {
            stack2.push(x);
            return;
        }

        Integer peek = stack2.peek();
        if (peek >= x) {
            stack2.push(x);
        }
    }

    public void pop() {
        Integer pop = stack1.pop();

        if (!stack2.empty()) {
            Integer peek = stack2.peek();
            if (peek.equals(pop)) {
                stack2.pop();
            }
        }

    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();

    }
}