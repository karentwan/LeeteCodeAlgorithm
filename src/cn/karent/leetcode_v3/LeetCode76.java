package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 最小覆盖子串
 * @author wan
 * @date 2021.04.10
 */
public class LeetCode76 {

    public String minWindow(String s, String t) {
        int i = 0;
        int[] cache = new int[128];
        int[] mcache = new int[128];
        for (int j = 0; j < t.length(); j++) {
            mcache[t.charAt(j)]++;
        }
        int start = 0;
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < s.length(); j++) {
            cache[s.charAt(j)]++;
            while ( valid(cache, mcache) ) {
                if( j - i + 1 < min) {
                    min = j - i + 1;
                    start = i;
                }
                cache[s.charAt(i)]--;
                i++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }

    private boolean valid(int[] cache, int[] mcache) {
        for (int i = 0; i < 128; i++) {
            if( cache[i] < mcache[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
        String s = "a";
        String t = "aa";
        LeetCode76 lc = new LeetCode76();
        String ret = lc.minWindow(s, t);
        System.out.println(ret);
    }

}
