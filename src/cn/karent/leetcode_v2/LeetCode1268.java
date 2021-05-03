package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 搜索推荐系统
 * @author wan
 * @date 2021.04.07
 */
public class LeetCode1268 {

    class TrieNode {

        private TrieNode[] children = new TrieNode[26];
        private boolean word;
        private int cnt = 0;

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

        private TrieNode current = null;

        private StringBuilder sb = new StringBuilder();

        public Trie() {
            current = root;
        }

        public void insert(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                p = p.insert(s.charAt(i));
            }
            p.setWord(true);
            p.cnt++;
        }

        private void traverse(TrieNode root, StringBuilder sb, List<String> ret) {
            if( ret.size() >= 3) {
                return;
            }
            if( root.isWord() ) {
                for (int i = 0; i < root.cnt; i++) {
                    ret.add(sb.toString());
                }
            }
            for (int i = 0; i < 26; i++) {
                if( root.children[i] != null) {
                    sb.append(((char) (i + 'a')));
                    traverse(root.children[i], sb, ret);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }

        public List<String> startWith(char ch) {
            List<String> ret = new ArrayList<>();
            if( current == null || current.get(ch) == null) {
                current = null;
                return ret;
            }
            sb.append(ch);
            List<String> tmp = new ArrayList<>();
            current = current.get(ch);
            traverse(current, new StringBuilder(), tmp);
            // 将后面的所有元素跟当前元素拼接起来
            for (int i = 0; i < 3 && i < tmp.size(); i++) {
                ret.add(sb.toString() + tmp.get(i));
            }
            return ret;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> rets = new ArrayList<>();
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> ret = trie.startWith(searchWord.charAt(i));
            rets.add(ret);
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1268 lc = new LeetCode1268();
        String[] products ={"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String>> rets = lc.suggestedProducts(products, searchWord);
        System.out.println(rets);
    }

}
