package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 构造k个回文字符串
 * @author wan
 * @date 2021.04.17
 */
public class LeetCode1400 {

    public boolean canConstruct(String s, int k) {
        int[] cache = new int[128];
        int odd = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cache[ch]++;
            if( cache[ch] % 2 != 0) odd++;
            else odd--;
        }
        if( odd > k || s.length() < k) return false;
        return true;
    }

    public static void main(String[] args) {
        LeetCode1400 lc = new LeetCode1400();
//        String s = "annabelle";
//        int k = 2;
//        String s = "leetcode";
//        int k = 3;
//        String s = "true";
//        int k = 4;
//        String s = "yzyzyzyzyzyzyzy";
//        int k = 2;
//        String s = "cr";
//        int k = 7;
        String s = "ibzkwaxxaggkiwjbeysz";
        int k = 15;
        boolean ret = lc.canConstruct(s, k);
        System.out.println(ret);
    }

}
