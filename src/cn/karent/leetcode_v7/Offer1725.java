package cn.karent.leetcode_v7;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/******************************************
 * 单词矩阵
 * @author wan
 * @date 2022.09.04 09:22
 ******************************************/
public class Offer1725 {

    class TrieNode {
        TrieNode[] children = new TrieNode[128];
        boolean word;

        public TrieNode insert(char idx) {
            if (children[idx] == null) children[idx] = new TrieNode();
            return children[idx];
        }

        public TrieNode get(char idx) {
            return children[idx];
        }

    }

    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String s) {
            char[] chs = s.toCharArray();
            TrieNode p = root;
            for (int i = 0; i < chs.length; i++) {
                p = p.insert(chs[i]);
            }
        }
    }

    int wnd = 0;
    List<String> rets;

    private TrieNode[] getNext(char[] chs, TrieNode[] nodes) {
        TrieNode[] next = new TrieNode[nodes.length];
        for (int i = 0; i < chs.length; i++) {
            next[i] = nodes[i].get(chs[i]);
            if (next[i] == null) return null;
        }
        return next;
    }

    private void dfs(List<String> words, TrieNode[] nodes, int size, int length, List<String> tmp, int maxLen) {
        if (words.get(0).length() * maxLen <= wnd) return;
        for (int i = 0; i < words.size(); i++) {
            char[] chs = words.get(i).toCharArray();
            if (chs.length == size) {
                TrieNode[] next = getNext(chs, nodes);
                if (next != null) {
                    tmp.add(words.get(i));
                    if (size * (length + 1) > wnd) {
                        wnd = size * (length + 1);
                        rets = new ArrayList<>(tmp);
                    }
                    dfs(words, next, size, length + 1, tmp, maxLen);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    public String[] maxRectangle(String[] words) {
        if (words.length == 0) return new String[0];
        Arrays.sort(words, (k1, k2)-> k2.length() - k1.length());
        Trie trie = new Trie();
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
            map.computeIfAbsent(words[i].length(), k->new ArrayList<>()).add(words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            int size = words[i].length();
            TrieNode[] nodes = new TrieNode[size];
            Arrays.fill(nodes, trie.root);
            TrieNode[] next = getNext(words[i].toCharArray(), nodes);
            if (next != null) {
                List<String> tmp = new ArrayList<>();
                tmp.add(words[i]);
                if (size > wnd) {
                    wnd = size;
                    rets = new ArrayList<>(tmp);
                }
                dfs(map.get(words[i].length()), next, size, 1, tmp, words[0].length());
            }
        }
        return rets.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Offer1725 lc = new Offer1725();
//        String[] str = {"this", "real", "hard", "trh", "hea", "iar", "sld"};
//        String[] str = {"hjhbr", "dixpgflm", "jjzgr", "gb", "ruzih", "zvthz", "rcadj", "agched", "jwvouurr", "hpmyrbq", "rdzfv", "pdffy", "ihsvg", "dihvb", "fhdwixmy", "cpvhj", "x", "aotsh", "qgahgz", "upoij"};
//        String[] str = {"lcauj", "mdlby", "myulp", "yvkqn", "usajk", "rpj", "bojvf",
//                "ukmkb", "afqbhs", "j", "ebe", "yacov", "wsaep",
//                "zdk", "wziqrdd", "pcjfn", "nlrehaq", "dasrc", "lruvq", "dvca"};
        String[] str = {"aa"};
        String[] strs = lc.maxRectangle(str);
        LeetCodeUtil.print(strs);
    }

}
