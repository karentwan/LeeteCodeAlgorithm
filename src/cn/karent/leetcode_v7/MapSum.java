package cn.karent.leetcode_v7;

import java.util.*;

/***********************************************
 * description: 
 * @author wan
 * @date 2021.11.14
 ***********************************************/
public class MapSum {

    class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private int value = 0;

        public TrieNode get(char ch) {
            int idx = ch - 'a';
            return children[idx];
        }

        public TrieNode insert(char ch) {
            int idx = ch - 'a';
            if (children[idx] == null) {
                children[idx] = new TrieNode();
            }
            return children[idx];
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private Map<String, TrieNode> map = new HashMap<>();
    private TrieNode root = new TrieNode();

    public MapSum() {

    }

    public void insert(String key, int val) {
        if (map.containsKey(key)) {
            map.get(key).setValue(val);
            return;
        }
        char[] chs = key.toCharArray();
        TrieNode p = root;
        for (int i = 0; i < key.length(); i++) {
            p = p.insert(chs[i]);
        }
        p.setValue(val);
        map.put(key, p);
    }

    private int dfs(TrieNode p) {
        if (p == null) return 0;
        int ret = p.getValue();
        for (int i = 0; i < 26; i++) {
            ret += dfs(p.children[i]);
        }
        return ret;
    }

    public int sum(String prefix) {
        TrieNode p = root;
        char[] chs = prefix.toCharArray();
        for (int i = 0; i < prefix.length() && p != null; i++) {
            p = p.get(chs[i]);
        }
        return dfs(p);
    }


    public static void main(String[] args) {

    }

}
