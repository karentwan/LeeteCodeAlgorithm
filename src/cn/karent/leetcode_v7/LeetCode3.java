package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 无重复字符的最长子串
 * @author wan
 * @date 2022.08.06 09:53
 ******************************************/
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        int[] cache = new int[128];
        int wnd = 0;  // 窗口内一共有多少个不同的字符串
        for (int i = 0, j = 0; i < s.length(); i++) {
            cache[s.charAt(i)]++;
            if (cache[s.charAt(i)] == 1) {
                wnd++;
            }
            while (wnd < i - j + 1) {
                cache[s.charAt(j)]--;
                if (cache[s.charAt(j)] == 0) wnd--;
                j++;
            }
            ret = Math.max(ret, wnd);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode3 lc = new LeetCode3();
//        String s = "abcabcbb";
//        String s = "bbbbb";
        String s = "pwwkew";
        System.out.println(lc.lengthOfLongestSubstring(s));
    }

}
