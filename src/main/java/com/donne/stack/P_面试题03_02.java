package com.donne.stack;

import java.util.Stack;

public class P_面试题03_02 {


    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(-1);

        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}


class MinStack2 {
    Stack<Integer> stack;
    Integer minValue;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (minValue == null) {
            minValue = x;
        }

        if (x <= minValue) {
            stack.push(minValue);
            minValue = x;
        }

        stack.push(x);
    }

    public void pop() {
        int pop = stack.pop();
        if (stack.isEmpty()) {
            minValue = null;
            return;
        }

        if (pop == minValue) {
            minValue = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack {
    transient Stack<Integer> stack;
    transient Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        if (pop.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
