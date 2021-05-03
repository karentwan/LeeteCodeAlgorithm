package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 替换后的最长重复字符
 * @author wan
 * @date 2021.04.10
 */
public class LeetCode424 {

    public int characterReplacement(String s, int k) {
        int i = 0;
        int max = 0;
        int[] cache = new int[128];
        int ret = 0;
        for (int j = 0; j < s.length(); j++) {
            cache[s.charAt(j)]++;
            max = Math.max(max, cache[s.charAt(j)]);
            if( j - i + 1 - max <= k) {
                ret = Math.max(ret, j - i + 1);
            } else {
                cache[s.charAt(i)]--;
                i++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode424 lc = new LeetCode424();
//        String s = "ABAB";
//        int k = 2;
        String s = "AABABBA";
        int k = 1;
        int ret = lc.characterReplacement(s, k);
        System.out.println(ret);
    }

}
