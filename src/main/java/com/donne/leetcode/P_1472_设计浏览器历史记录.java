package com.donne.leetcode;

import java.util.Stack;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-10
 */
public class P_1472_设计浏览器历史记录 {
    public static void main(String[] args) {
        /**
         * ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
         * [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
         */

        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        System.out.println(browserHistory.back(1));                   // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        System.out.println(browserHistory.back(1));                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        System.out.println(browserHistory.forward(1));                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        System.out.println(browserHistory.forward(2));                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        System.out.println(browserHistory.back(2));                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        System.out.println(browserHistory.back(7));                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"

    }

}

class BrowserHistory {
    private String currentPage;
    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();

    public BrowserHistory(String homepage) {
        visit(homepage);
    }

    public void visit(String url) {
        if (currentPage != null) {
            backStack.push(currentPage);
        }
        this.currentPage = url;
        forwardStack.clear();
    }

    public String back(int steps) {
        if (backStack.isEmpty()) {
            return currentPage;
        }

        forwardStack.push(currentPage);

        while (true) {
            steps--;
            String pop = backStack.pop();
            if (steps == 0 || backStack.isEmpty()) {
                this.currentPage = pop;
                return pop;
            }
            forwardStack.push(pop);
        }
    }

    public String forward(int steps) {
        if (forwardStack.isEmpty()) {
            return currentPage;
        }

        backStack.push(currentPage);

        while (true) {
            steps--;
            String pop = forwardStack.pop();
            if (steps == 0 || forwardStack.isEmpty()) {
                this.currentPage = pop;
                return pop;
            }
            backStack.push(pop);
        }
    }
}
