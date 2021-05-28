package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 删除子文件夹
 * @author wan
 * @date 2021.05.28
 ********************************************/
public class LeetCode1233 {

    class TrieNode {

        private boolean word;
        private Map<String, TrieNode> children;
        private List<Integer> idxs;

        public TrieNode() {
            children = new HashMap<>();
            idxs = new ArrayList<>();
        }

        public TrieNode insert(String key) {
            if( !children.containsKey(key)) {
                children.put(key, new TrieNode());
            }
            return children.get(key);
        }

        public TrieNode get(String key) {
            return children.get(key);
        }

        public boolean isWord() {
            return word;
        }

        public void setWord(boolean word) {
            this.word = word;
        }

        public List<Integer> getIdxs() {
            return idxs;
        }

        public void addIdx(int idx) {
            idxs.add(idx);
        }

        public Iterator<Map.Entry<String, TrieNode>> iterator() {
            return children.entrySet().iterator();
        }

    }

    class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String s, int idx) {
            TrieNode p = root;
            String[] keys = s.split("/");
            for (int i = 0; i < keys.length; i++) {
                p = p.insert(keys[i]);
            }
            p.setWord(true);
            p.addIdx(idx);
        }

        private void subDir(TrieNode p, Set<Integer> rets) {
            if( p.isWord() ) {
                rets.addAll(p.getIdxs());
            }
            TrieNode p1 = null;
            Iterator<Map.Entry<String, TrieNode>> iter = p.iterator();
            while ( iter.hasNext() ) {
                p1 = iter.next().getValue();
                subDir(p1, rets);
            }
        }

        private void dfs(TrieNode p, Set<Integer> rets) {
            TrieNode p1 = null;
            if( p.isWord() ) {
                Iterator<Map.Entry<String, TrieNode>> iter = p.iterator();
                while (iter.hasNext()) {
                    p1 = iter.next().getValue();
                    subDir(p1, rets);
                }
            } else {
                Iterator<Map.Entry<String, TrieNode>> iter = p.iterator();
                while (iter.hasNext()) {
                    p1 = iter.next().getValue();
                    dfs(p1, rets);
                }
            }
        }

        public Set<Integer> delete() {
            Set<Integer> rets = new HashSet<>();
            dfs(root, rets);
            return rets;
        }

    }

    public List<String> removeSubfolders(String[] folder) {
        Trie trie = new Trie();
        for (int i = 0; i < folder.length; i++) {
            trie.insert(folder[i], i);
        }
        Set<Integer> deletes = trie.delete();
        List<String> rets = new ArrayList<>();
        for (int i = 0; i < folder.length; i++) {
            if( !deletes.contains(i)) {
                rets.add(folder[i]);
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1233 lc = new LeetCode1233();
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        List<String> rets = lc.removeSubfolders(folder);
        System.out.println(rets);
    }

}
