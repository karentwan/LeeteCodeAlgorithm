package cn.karent.util;

/**
 * 前缀树
 */
public class Trie {

    class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private boolean word = false;

        public TrieNode get(char ch) {
            int idx = ch - 'a';
            return children[idx];
        }

        public TrieNode insert(char ch) {
            int idx = ch - 'a';
            if( children[idx] == null) {
                children[idx] = new TrieNode();
            }
            return children[idx];
        }

        public void setWord(boolean word) {
            this.word = word;
        }

        public boolean isWord() {
            return this.word;
        }

    }

    private TrieNode root = new TrieNode();

    public void insert(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            p = p.insert(s.charAt(i));
        }
        p.setWord(true);
    }

    public boolean search(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length() && p != null; i++) {
            p = p.get(s.charAt(i));
        }
        return p != null && p.isWord();
    }

    public boolean startWith(String s) {
        TrieNode p = root;
        int i = 0;
        for(i = 0; i < s.length() && p != null; i++) {
            p = p.get(s.charAt(i));
        }
        return p != null && i == s.length();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = {"cat", "cats", "dog", "dogs", "catdog", "wan"};
        for(String s : words) {
            trie.insert(s);
        }
        System.out.println(trie.search("cat"));
        System.out.println(trie.search("cata"));
        System.out.println(trie.startWith("catss"));
    }

}
