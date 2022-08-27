package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 替换后的最长重复字符
 * @author wan
 * @date 2022.08.27 11:44
 ******************************************/
public class LeetCode424 {

    public int characterReplacement(String s, int k) {
        char[] chs = s.toCharArray();
        int[] cache = new int[26];
        int max = 0, ret = 0;
        for (int i = 0, j = 0; i < chs.length; i++) {
            int idx = chs[i] - 'A';
            cache[idx]++;
            // 不需要是窗口内数量最多的字符串, 下一次的窗口扩张一定是窗口最多的字符也更多
            max = Math.max(max, cache[idx]);
            if (i - j + 1 > max + k) {
                cache[chs[j] - 'A']--;
                j++;
            } else {
                ret = Math.max(ret, i - j + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode424 lc = new LeetCode424();
//        String s = "ABAB";
        String s = "AABABBA";
        int k = 1;
        System.out.println(lc.characterReplacement(s, k));
    }

}
