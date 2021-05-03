package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 实现strStr()
 * @author wan
 * @date 2021.04.20
 */
public class LeetCode28 {

    public int strStr(String haystack, String needle) {
        if( needle.length() == 0 ) return 0;
        char[] chs = needle.toCharArray();
        int i = 0, j = -1;
        int[] next = new int[chs.length];
        next[0] = -1;
        while ( i < chs.length - 1) {
            if( j == -1 || chs[j] == chs[i]) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        char[] patches = haystack.toCharArray();
        i = 0;
        j = 0;
        while ( j < chs.length && i < patches.length) {
            if( j == -1 || patches[i] == chs[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j == chs.length ? i - chs.length : -1;
    }

/*    public int strStr(String haystack, String needle) {
        if( needle.length() == 0 ) return 0;
        if( haystack.length() < needle.length()) return -1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
//            map.add(haystack.substring(i, i+needle.length()));
            String tmp = haystack.substring(i, i+needle.length());
            if( !map.containsKey(tmp)) {
                map.put(tmp, i);
            }
        }
        return map.containsKey(needle) ? map.get(needle) : -1;
    }*/

    public static void main(String[] args) {
        LeetCode28 lc = new LeetCode28();
        String haystack = "hello";
        String needle = "ll";
//        String haystack = "aaaaa";
//        String needle = "bba";
//        String haystack = "";
//        String needle = "";
        int ret = lc.strStr(haystack, needle);
        System.out.println(ret);
    }

}
