package cn.karent.other;

import java.util.*;

/********************************************
 * description: AC自动机 -多模式串匹配算法
 * @author wan
 * @date 2021.06.20
 ********************************************/
public class Automaton {

    class Node {

        int end;

        Node[] children;

        Node fail;

        public Node() {
            children = new Node[26];
            end = 0;
        }

        public Node insert(char ch) {
            int idx = ch - 'a';
            if( children[idx] == null) children[idx] = new Node();
            return children[idx];
        }

        public Node get(char ch) {
            return children[ch - 'a'];
        }

        public int getWords() {
            return end;
        }

    }

    private Node root;

    public Automaton() {
        root = new Node();
    }

    private void insert(String s) {
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            p = p.insert(s.charAt(i));
        }
        p.end++;
    }

    public void getFail() {
        Queue<Node> que = new LinkedList<>();
        Node p = root;
        // 第二层单独处理
        Node[] cds = p.children;
        for (int i = 0; i < 26; i++) {
            if( cds[i] != null) {
                cds[i].fail = root;
                que.offer(cds[i]);
            } else cds[i] = root;
        }
        // 开始处理每一层的fail指针
        while (!que.isEmpty()) {
            p = que.poll();
            cds = p.children;
            for (int i = 0; i < 26; i++) {
                if( cds[i] != null) {
                    // 子节点的fail指针指向父节点的fail指针的相同子节点
                    cds[i].fail = p.fail.children[i];
                    que.offer(cds[i]);
                } else cds[i] = p.fail.children[i];
            }
        }
    }

    public int query(String s) {
        int cnt = 0;
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            p = p.get(s.charAt(i));
            for (Node t = p; t != null && t.end != -1; t = t.fail) {
                cnt += t.end;
                t.end = -1;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        Automaton lc = new Automaton();
//        String[] strs = {"a", "ab", "ac", "abc"};
//        String str = "abcd";
//        String[] strs = {"a", "aa", "aa"};
//        String str = "aaa";
//        String[] strs = {"a", "aa"};
//        String str = "aa";
        String[] strs = {"abcg", "bcd"};
        String str = "abcde";
        for (int i = 0; i < strs.length; i++) {
            lc.insert(strs[i]);
        }
        lc.getFail();
        int ret = lc.query(str);
        System.out.println(ret);
    }

}
