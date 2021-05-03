package cn.karent.leetcode;

import java.util.*;

/**
 * 连接词, 使用前缀树超时
 */
public class LeetCode472 {

    class TrieNode {

        private TrieNode[] children = new TrieNode[26];
        private boolean word = false;

        public TrieNode get(char ch) {
            int idx = ch - 'a';
            return children[idx];
        }

        public boolean isWord() {
            return this.word;
        }

        public void setWord(boolean flag) {
            word = flag;
        }

        public TrieNode insert(char ch) {
            TrieNode p = get(ch);
            if( p == null) {
                children[ch - 'a'] = new TrieNode();
            }
            return children[ch - 'a'];
        }

    }

    class Trie {

        public TrieNode root = new TrieNode();

        public void insert(String s) {
            TrieNode p = root;
            for(int i = 0; i < s.length(); i++) {
                p = p.insert(s.charAt(i));
            }
            p.setWord(true);
        }

        public TrieNode getRoot() {
            return root;
        }

        public boolean search(String s) {
            TrieNode p = root;
            for(int i = 0; i < s.length() && p != null; i++) {
                p = p.get(s.charAt(i));
            }
            return p != null && p.isWord();
        }

    }

    private boolean dfs(Trie trie, String word, int idx, int cnt) {
        TrieNode p = trie.root;
        for(int i = idx; i < word.length(); i++) {
            p = p.get(word.charAt(i));
            if( p == null) {
                return false;
            }
            if( p.isWord() && dfs(trie, word, i+1, cnt+1)) {
                return true;
            }
        }
        return p.isWord() && cnt > 0;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> rets = new ArrayList<>();
        Trie trie = new Trie();
        for(String word : words) {
            if( word.length() != 0)
                trie.insert(word);
        }
        for(String word : words) {
            if( dfs(trie, word, 0, 0)) {
                rets.add(word);
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode472 lc = new LeetCode472();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
//        String[] words = {"cat","dog","catdog"};
        List<String> rets = lc.findAllConcatenatedWordsInADict(words);
        for(String s : rets) {
            System.out.println(s);
        }
    }
}
