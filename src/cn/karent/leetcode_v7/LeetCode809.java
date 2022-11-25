package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 情感丰富的文字
 * @author wan
 * @date 2022.11.25 11:02
 ******************************************/
public class LeetCode809 {

    class Node {
        char c;
        int cnt;
        Node next;
    }

    private Node count(String s) {
        Node head = new Node();
        Node p = head, next = null;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i-1)) {
                next = new Node();
                next.c = s.charAt(i);
                next.cnt = 1;
                p.next = next;
                p = next;
            } else next.cnt++;
        }
        return head;
    }

    private boolean compare(Node p1, Node p2) {
        while (p1 != null && p2 != null) {
            if (p1.c != p2.c || p2.cnt > p1.cnt || (p1.cnt != p2.cnt && p1.cnt <= 2)) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1 == null && p2 == null;
    }

    public int expressiveWords(String s, String[] words) {
        Node meta = count(s);
        int ret = 0;
        for (String word : words) {
            Node tmp = count(word);
            if (compare(meta, tmp)) ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode809 lc = new LeetCode809();
//        String s = "heeellooo";
//        String[] words = {"hello", "hi", "helo"};
        String s = "aaa";
        String[] words = {"aaaa"};
        System.out.println(lc.expressiveWords(s, words));
    }

}
