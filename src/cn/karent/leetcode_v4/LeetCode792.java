package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 匹配子序列的单词数
 * @author wan
 * @date 2021.05.07
 ********************************************/
public class LeetCode792 {

/*
    class TrieNode {

        private boolean word;
        private TrieNode[] children;
        private int cnt;

        public TrieNode() {
            children = new TrieNode[26];
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
            cnt++;
        }

        public int getCnt() {
            return cnt;
        }

        public TrieNode insert(char ch) {
            int idx = ch - 'a';
            if( children[idx] == null) children[idx] = new TrieNode();
            return children[idx];
        }

    }


    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                p = p.insert(s.charAt(i));
            }
            p.setWord(true);
        }

        private int ret = 0;

        private Set<String> visited = new HashSet<>();

        public void dfs(char[] chs, int idx, char prev, TrieNode p) {
            if( idx >= chs.length) {
                if( p.isWord() ) ret += p.getCnt();
                return;
            }
            TrieNode tmp = p.get(chs[idx]);
            if( tmp != null) {
                dfs(chs, idx + 1, chs[idx], tmp);
            }
            if( chs[idx] != prev) {
                dfs(chs, idx + 1, prev, p);
            }
        }

        public int match(String s) {
            char[] chs = s.toCharArray();
            dfs(chs, 0, (char) 0, root);
            return ret;
        }

    }
    // 超时
    public int numMatchingSubseq(String s, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int ret = trie.match(s);
        return ret;
    }

    */

    class Node {
        private String str;
        private int idx;

        public Node(String str, int idx) {
            this.str = str;
            this.idx = idx;
        }
    }

    public int numMatchingSubseq(String s, String[] words) {
        List<Node>[] list = new List[26];
        for (int i = 0; i < 26; i++) {
            list[i] = new ArrayList<>();
        }
        for (String word : words) {
            char ch = word.charAt(0);
            list[ch - 'a'].add(new Node(word, 0));
        }
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            List<Node> tmp = list[ch - 'a'];
            list[ch - 'a'] = new ArrayList<>();
            for (int j = 0; j < tmp.size(); j++) {
                Node node = tmp.get(j);
                node.idx++;
                if( node.idx >= node.str.length()) ret++;
                else {
                    char tc = node.str.charAt(node.idx);
                    list[tc - 'a'].add(node);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode792 lc = new LeetCode792();
//        String s = "abcde";
//        String[] words = {"a", "bb", "acd", "ace"};
//        String s = "dsahjpjauf";
//        String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
//        String s = "qlhxagxdqh";
//        String[] words = {"qlhxagxdq","qlhxagxdq","lhyiftwtut","yfzwraahab"};
        String s = "rwpddkvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvjubjgloeofnpjqlkdsqvruvabjrikfwronbrdyyjnakstqjac";
        String[] words = {"wpddkvbnn","lnagtva","kvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvju","rwpddkvbnnugln","gloeofnpjqlkdsqvruvabjrikfwronbrdyyj","vbgeinupkvgmgxeaaiuiyojmoqkahwvbpwugdainxciedbdkos","mspuhbykmmumtveoighlcgpcapzczomshiblnvhjzqjlfkpina","rgmliajkiknongrofpugfgajedxicdhxinzjakwnifvxwlokip","fhepktaipapyrbylskxddypwmuuxyoivcewzrdwwlrlhqwzikq","qatithxifaaiwyszlkgoljzkkweqkjjzvymedvclfxwcezqebx"};
        int ret = lc.numMatchingSubseq(s, words);
        System.out.println(ret);
    }

}
