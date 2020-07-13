package com.donne.leetcode;

import com.sun.deploy.util.StringUtils;

import java.util.Stack;

public class P_71_简化路径 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s : split) {
            switch (s) {
                case "":
                case ".":
                    break;
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(s);
            }
        }

        String simplifyPath = "";
        while (!stack.isEmpty()) {
            simplifyPath += ("/" + stack.pop());
        }

        return "".equals(simplifyPath) ? "/" : simplifyPath;
    }
}
