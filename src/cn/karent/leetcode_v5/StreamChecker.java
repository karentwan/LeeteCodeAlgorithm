package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 字符流
 * @author wan
 * @date 2021.06.20
 ********************************************/
public class StreamChecker {

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
            if (children[idx] == null) children[idx] = new Node();
            return children[idx];
        }

        public Node get(char ch) {
            return children[ch - 'a'];
        }

        public int getWords() {
            return end;
        }

    }

    class Automaton {

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
                if (cds[i] != null) {
                    cds[i].fail = root;
                    que.offer(cds[i]);
                } else cds[i] = root;
            }
            // 开始处理每一层的fail指针
            while (!que.isEmpty()) {
                p = que.poll();
                p.end = p.end + p.fail.end;  // 这一行代码实在是太神奇了
                cds = p.children;
                for (int i = 0; i < 26; i++) {
                    if (cds[i] != null) {
                        // 子节点的fail指针指向父节点的fail指针的相同子节点
                        cds[i].fail = p.fail.children[i];
                        que.offer(cds[i]);
                    } else cds[i] = p.fail.children[i];
                }
            }
        }
    }

    private Automaton ac;

    public StreamChecker(String[] words) {
        ac = new Automaton();
        for (int i = 0; i < words.length; i++) {
            ac.insert(words[i]);
        }
        ac.getFail();
        current = ac.root;
    }

    private Node current;

    public boolean query(char letter) {
        current = current.children[letter - 'a'];
        return current.end > 0;
    }

    public static void main(String[] args) {

    }

}
