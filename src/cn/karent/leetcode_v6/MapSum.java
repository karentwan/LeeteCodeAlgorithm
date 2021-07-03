package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 键值映射
 * @author wan
 * @date 2021.07.03
 ***********************************************/
public class MapSum {

    class Node {
        Node[] children = new Node[26];
        int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node get(char ch) {
            return children[ch - 'a'];
        }

        public Node insert(char ch) {
            if( children[ch - 'a'] == null) {
                children[ch - 'a'] = new Node();
            }
            return children[ch - 'a'];
        }

    }

    private Map<String, Node> map;

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
        root = new Node();
    }

    public void insert(String key, int val) {
        if( map.containsKey(key)) {
            map.get(key).setValue(val);
            return;
        }
        Node p = root;
        for (int i = 0; i < key.length(); i++) {
            p = p.insert(key.charAt(i));
        }
        p.setValue(val);
        map.put(key, p);
    }

    private int dfs(Node p) {
        if( p == null) return 0;
        int ret = p.value;
        Node[] children = p.children;
        for (int i = 0; i < 26; i++) {
            ret += dfs(children[i]);
        }
        return ret;
    }

    public int sum(String prefix) {
        Node p = root;
        for (int i = 0; i < prefix.length() && p != null; i++) {
            p = p.get(prefix.charAt(i));
        }
        return dfs(p);
    }

    public static void main(String[] args) {
        MapSum ms = new MapSum();
        ms.insert("apple", 3);
        System.out.println(ms.sum("ap"));
        ms.insert("app", 2);
    }

}
