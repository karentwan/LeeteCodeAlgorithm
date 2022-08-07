package cn.karent.leetcode_v1.weeklycontest305;

import java.util.*;

/******************************************
 * 最长理想子序列
 * @author wan
 * @date 2022.08.07 11:07
 ******************************************/
public class LeetCode6138 {

    public int longestIdealString(String s, int k) {
        int[] cache = new int[26];
        int ret = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            for (int j = 0; j <= k; j++) {
                int idx = chs[i] - 'a';
                int t = cache[idx];
                if (idx + j <= 25) {
                    int prev = idx + j;
                    t = Math.max(t, cache[prev] + 1);
                }
                if (idx - j >= 0) {
                    int prev = idx - j;
                    t = Math.max(t, cache[prev] + 1);
                }
                cache[idx] = t;
                ret = Math.max(ret, cache[idx]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode6138 lc = new LeetCode6138();
//        String s = "acfgbd";
//        int k = 25;
        String s = "eduktdb";
        int k = 15;
        System.out.println(lc.longestIdealString(s, k));
    }

}
