package com.donne.leetcode;

import java.util.Stack;

/**
 *
 */
class P_括号匹配 {

    public static void main(String[] args) {
        String input = "{[()]}a";
        System.out.println(isValid(input));
    }

    public static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (!stack.isEmpty() && judge(stack.peek(), c)) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        return stack.isEmpty();
    }

    private static boolean judge(char a1, char a2) {
        if (a1 == '(' && a2 == ')') {
            return true;
        }

        if (a1 == '[' && a2 == ']') {
            return true;
        }

        if (a1 == '{' && a2 == '}') {
            return true;
        }
        return false;
    }
}