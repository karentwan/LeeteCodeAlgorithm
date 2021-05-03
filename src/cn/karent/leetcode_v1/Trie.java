package cn.karent.leetcode_v1;

import java.util.*;

/**
 * 实现Trie(前缀树)
 * @author wan
 * @date 2021.04.14
 */
public class Trie {

    class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private boolean word;

        public boolean isWord() {
            return word;
        }

        public void setWord(boolean word) {
            this.word = word;
        }

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
    }

    private TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            p = p.insert(word.charAt(i));
        }
        p.setWord(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length() && p != null; i++) {
            p = p.get(word.charAt(i));
        }
        return p != null && p.isWord();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length() && p != null; i++) {
            p = p.get(prefix.charAt(i));
        }
        return p != null;
    }

    public static void main(String[] args) {

    }

}
