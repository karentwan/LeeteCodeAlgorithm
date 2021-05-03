package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 不同字符的最小子序列
 * @author wan
 * @date 2021.04.14
 */
public class LeetCode1081 {

    public String smallestSubsequence(String text) {
        Deque<Integer> st = new LinkedList<>();
        int[] cache = new int[128];
        for (int i = 0; i < text.length(); i++) {
            cache[text.charAt(i)]++;
        }
        int[] exist = new int[128];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            while (!st.isEmpty() &&
                    (ch < text.charAt(st.peekLast())
                    && cache[text.charAt(st.peekLast())] > 0
                            && exist[ch] == 0)) {
                exist[text.charAt(st.pollLast())]--;
            }
            if( exist[ch] == 0) {
                st.offerLast(i);
                exist[ch]++;
            }
            cache[ch]--;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(text.charAt(st.pollFirst()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode1081 lc = new LeetCode1081();
//        String s = "bcabc";
//        String s = "cbacdcbc";
        String s = "cbaacabcaaccaacababa";
        String ret = lc.smallestSubsequence(s);
        System.out.println(ret);
    }

}
