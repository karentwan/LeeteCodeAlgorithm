package cn.karent.leetcode;

import java.util.*;

/**
 * 重构字符串
 */
public class LeetCode767 {

    public String reorganizeString(String S) {
        int n = S.length();
        char[] cnts = new char[26];
        for(int i = 0; i < S.length(); i++) {
            cnts[S.charAt(i) - 'a']++;
            if( cnts[S.charAt(i) - 'a'] > (n+1)/2) {
                return "";
            }
        }
        PriorityQueue<Character> que = new PriorityQueue<>((k1, k2) -> {
            return cnts[k2 - 'a'] - cnts[k1 - 'a'];
        });
        for(char i = 'a'; i <= 'z'; i++) {
            if( cnts[i - 'a'] > 0) {
                que.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while( que.size() >= 2) {
            char ch1 = que.poll();
            char ch2 = que.poll();
            sb.append(ch1);
            sb.append(ch2);
            cnts[ch1 - 'a']--;
            cnts[ch2 - 'a']--;
            if( cnts[ch1 - 'a'] > 0) {
                que.offer(ch1);
            }
            if( cnts[ch2 - 'a'] > 0) {
                que.offer(ch2);
            }
        }
        if( !que.isEmpty()) {
            sb.append(que.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode767 lc = new LeetCode767();
        String s = "aab";
        String ret = lc.reorganizeString(s);
        System.out.println(ret);
    }
}
