package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 字符频次唯一的最小删除次数
 */
public class LeetCode1647 {

    public int minDeletions(String s) {
        Integer[] cnts = new Integer[26];
        for (int i = 0; i < 26; i++) {
            cnts[i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
        }
        Arrays.sort(cnts, (k1, k2) -> {
            return k2 - k1;
        });
        int ret = 0;
        for (int i = 1; i < 26; i++) {
            if( cnts[i] > 0 && cnts[i] >= cnts[i-1]) {
                int delta = cnts[i-1] > 0 ? cnts[i-1] - 1 : 0;
                ret += cnts[i] - delta;
                cnts[i] = delta;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1647 lc = new LeetCode1647();
//        String s = "aab";
//        String s = "aaabbbcc";
//        String s = "ceabaacb";
//        String s = "abcabc";
//        String s = "abcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwz";
        String s = "bbcebab";
        int ret = lc.minDeletions(s);
        System.out.println(ret);
    }

}
