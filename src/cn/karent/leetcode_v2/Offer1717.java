package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 多次搜索
 * @author wan
 * @date 2021.04.07
 */
public class Offer1717 {
/*
    public int[][] multiSearch(String big, String[] smalls) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < big.length(); i++) {
            map.computeIfAbsent(big.charAt(i), (key) -> new ArrayList<>()).add(i);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (String small : smalls) {
            List<Integer> tmp = new ArrayList<>();
            list.add(tmp);
            if( small.length() > 0) {
                List<Integer> indices = map.getOrDefault(small.charAt(0), null);
                int n = small.length();
                for (int i = 0; indices != null && i < indices.size(); i++) {
                    int idx = indices.get(i);
                    if( idx + n <= big.length()) {
                        String sub = big.substring(idx, idx + n);
                        if( sub.equals(small)) {
                            tmp.add(idx);
                        }
                    }
                }
            }
        }
        int[][] rets = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> tmp = list.get(i);
            rets[i] = new int[tmp.size()];
            for (int j = 0; j < tmp.size(); j++) {
                rets[i][j] = tmp.get(j);
            }
        }
        return rets;
    }
    */

    class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private boolean word;
        private int sid = -1;

        public TrieNode insert(char ch) {
            int idx = ch - 'a';
            if( children[idx] == null) {
                children[idx] = new TrieNode();
            }
            return children[idx];
        }

        public TrieNode get(char ch) {
            int idx = ch - 'a';
            return children[idx];
        }

        public boolean isWord() {
            return word;
        }

        public void setWord(boolean word) {
            this.word = word;
        }
    }

    class Trie {
        private TrieNode root = new TrieNode();

        public void insert(String s, int idx) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                p = p.insert(s.charAt(i));
            }
            p.setWord(true);
            p.sid = idx;
        }

        public void match(String s, int idx, List<List<Integer>> rets) {
            TrieNode p = root;
            for (int i = idx; i < s.length() && p != null; i++) {
                if( p != root && p.isWord() ) {
                    rets.get(p.sid).add(idx);
                }
                p = p.get(s.charAt(i));
            }
            if( p != root && p != null && p.isWord()) {
                rets.get(p.sid).add(idx);
            }
        }
    }

    // 使用前缀树求解
    public int[][] multiSearch(String big, String[] smalls) {
        Trie trie = new Trie();
        for (int i = 0; i < smalls.length; i++) {
            trie.insert(smalls[i], i);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < smalls.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < big.length(); i++) {
            trie.match(big, i, list);
        }
        int[][] rets = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> tmp = list.get(i);
            rets[i] = new int[tmp.size()];
            for (int j = 0; j < tmp.size(); j++) {
                rets[i][j] = tmp.get(j);
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        Offer1717 lc = new Offer1717();
        String big = "mississippi";
        String[] smalls = {"is","ppi","hi","sis","i","ssippi"};
//        String big = "abc";
//        String[] smalls = {""};
        int[][] rets = lc.multiSearch(big, smalls);
        System.out.println("====================================>");
        for (int[] ret : rets) {
            for (int i : ret) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
