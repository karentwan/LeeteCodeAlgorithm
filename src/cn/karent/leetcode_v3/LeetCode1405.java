package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 最长快乐字符串
 * @author wan
 * @date 2021.04.17
 */
public class LeetCode1405 {

    class Node implements Comparable<Node>{
        private char ch;
        private int cnt;

        public Node(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return o.cnt - cnt;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        Node[] nodes = {new Node('a', a), new Node('b', b), new Node('c', c)};
        StringBuilder sb = new StringBuilder();
        while (true) {
            Arrays.sort(nodes);
            int n = sb.length();
            if( sb.length() >= 2 && sb.charAt(n-1) == nodes[0].ch
                    && sb.charAt(n-2) == nodes[0].ch) {
                if( nodes[1].cnt > 0) {
                    sb.append(nodes[1].ch);
                    nodes[1].cnt--;
                } else break;
            } else {
                if( nodes[0].cnt > 0) {
                    sb.append(nodes[0].ch);
                    nodes[0].cnt--;
                } else break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode1405 lc = new LeetCode1405();
//        int a = 1;
//        int b = 1;
//        int c = 7;
        int a = 2;
        int b = 2;
        int c = 1;
        String ret = lc.longestDiverseString(a, b, c);
        System.out.println(ret);
    }

}
