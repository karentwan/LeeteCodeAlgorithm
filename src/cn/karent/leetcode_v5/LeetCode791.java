package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 自定义字符串排序
 * @author wan
 * @date 2021.06.25
 ***********************************************/
public class LeetCode791 {

    public String customSortString(String order, String str) {
        int[] cache = new int[26];
        for (int i = 0; i < order.length(); i++) {
            cache[order.charAt(i) - 'a'] = i;
        }
        char[] tmps = str.toCharArray();
        Character[] chs = new Character[tmps.length];
        for (int i = 0; i < chs.length; i++) {
            chs[i] = tmps[i];
        }
        Arrays.sort(chs, (k1 ,k2)->cache[k1 - 'a'] - cache[k2 - 'a']);
        for (int i = 0; i < chs.length; i++) {
            tmps[i] = chs[i];
        }
        return new String(tmps);
    }

    public static void main(String[] args) {
        LeetCode791 lc = new LeetCode791();
        String s = "cba";
        String t = "abcd";
        String ret = lc.customSortString(s, t);
        System.out.println(ret);
    }

}
