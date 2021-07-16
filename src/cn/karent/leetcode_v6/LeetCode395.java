package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 至少有k个重复字符的最长子串
 * @author wan
 * @date 2021.07.16
 ***********************************************/
public class LeetCode395 {

    public int longestSubstring(String s, int k) {
        // 枚举滑动窗口内的字符种类
        char[] chs = s.toCharArray();
        int[] cache = new int[26];
        for (int i = 0; i < chs.length; i++) {
            cache[s.charAt(i) - 'a']++;
        }
        int ret = 0;
        for (int l = 1; l <= 26; l++) {
            int total = 0, less = 0;
            int[] tmps = new int[26];
            for (int i = 0, j = 0; i < chs.length; i++) {
                tmps[chs[i] - 'a']++;
                if( tmps[chs[i] - 'a'] == 1) {
                    total++;
                }
                if( tmps[chs[i] - 'a'] == k)
                    less++;
                while (total > l) {
                    tmps[chs[j]-'a']--;
                    if( tmps[chs[j]-'a'] == 0)
                        total--;
                    if( tmps[chs[j] - 'a'] == k-1)
                        less--;
                    j++;
                }
                if( less == total) {
                    ret = Math.max(ret, i - j + 1);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode395 lc = new LeetCode395();
//        String s = "aaabb";
//        int k = 3;
//        String s = "ababbc";
//        int k = 2;
        String s = "bbaaacbd";
        int k = 3;
        int ret = lc.longestSubstring(s, k);
        System.out.println(ret);
    }

}
