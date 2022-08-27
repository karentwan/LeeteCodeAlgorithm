package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 单字符重复子串的最大长度
 * @author wan
 * @date 2022.08.27 11:20
 ******************************************/
public class LeetCode1156 {

    public int maxRepOpt1(String text) {
        char[] chs = text.toCharArray();
        int[] cache = new int[26];
        int[] tmp = new int[26];
        for (int i = 0; i < chs.length; i++) {
            tmp[chs[i] - 'a']++;
        }
        int ret = 0, wnd = 0;
        char c = '\0';
        for (int i = 0, j = 0; i < chs.length; i++) {
            int idx = chs[i] - 'a';
            cache[idx]++;
            if (cache[idx] >= wnd) {
                wnd = cache[idx];
                c = chs[i];
            }
            if (i - j + 1 <= wnd + 1 && i - j + 1 <= tmp[c - 'a']) {
                ret = Math.max(ret, i -j + 1);
            } else {
                cache[chs[j] - 'a']--;
                j++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1156 lc = new LeetCode1156();
        String text = "ababa";
        System.out.println(lc.maxRepOpt1(text));
    }

}
