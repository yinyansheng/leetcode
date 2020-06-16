package com.donne.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-16
 */
public class P_720_词典中最长的单词 {
    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{"ogz", "eyj", "e", "ey", "hmn", "v", "hm",
                "ogznkb", "ogzn", "hmnm", "eyjuo", "vuq", "ogznk", "og", "eyjuoi", "d"}));
    }

    public static String longestWord(String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            Integer count = trie.getCount(words[i]);
            map.put(words[i], count);
        }

        Integer max = map.values().stream().max(Comparator.comparingInt(r -> r)).get();
        String key = map.entrySet().stream().filter(r -> r.getValue().equals(max)).min(Map.Entry.comparingByKey()).get().getKey();
        return key;
    }

}

class TrieNode {

    public TrieNode(boolean isEnd, char val) {
        this.isEnd = isEnd;
        this.val = val;
    }

    public Boolean isEnd = false;
    public Character val;
    public TrieNode[] children = new TrieNode[26];
}

class Trie {
    TrieNode root = new TrieNode(false, '&');

    public void insert(String word) {
        TrieNode currNode = root;
        for (char c : word.toCharArray()) {
            TrieNode child = currNode.children[c - 'a'];
            if (null == child) {
                currNode.children[c - 'a'] = new TrieNode(false, c);
            }
            currNode = currNode.children[c - 'a'];
        }
        currNode.isEnd = true;
    }

    public Integer getCount(String word) {
        TrieNode currNode = root;
        int depth = 0;
        for (char c : word.toCharArray()) {
            TrieNode child = currNode.children[c - 'a'];
            if (child.isEnd) {
                depth++;
            } else {
                return 0;
            }
            currNode = child;
        }
        return depth;
    }
}
