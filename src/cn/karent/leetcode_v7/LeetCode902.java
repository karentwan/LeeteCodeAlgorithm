package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 最大为N的数字组合
 * @author wan
 * @date 2022.08.14 16:51
 ******************************************/
public class LeetCode902 {

    int[] dp;

    char[] chs;

    private int dfs(char[] digits, int idx, boolean isLimited, boolean isNum) {
        if (idx == chs.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimited && dp[idx] > -1) {
            return dp[idx];
        }
        // 不选
        int ret = 0;
        if (!isNum) {
            ret = dfs(digits, idx + 1, false, false);
        }
        // 选
        int t = 0;
        for(char c : digits) {
            if (!isLimited || c <= chs[idx])
                t += dfs(digits, idx+1, isLimited && chs[idx] == c, true);
        }
        if (!isLimited) {
            dp[idx] = t;
        }
        return ret + t;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        chs = s.toCharArray();
        dp = new int[chs.length];
        Arrays.fill(dp, -1);
        char[] d = new char[digits.length];
        for (int i = 0; i < digits.length; i++) {
            d[i] = digits[i].charAt(0);
        }
        return dfs(d,0, true, false);
    }

    public static void main(String[] args) {
        LeetCode902 lc = new LeetCode902();
//        String[] s = {"1", "3", "5", "7"};
//        int n = 100;
        String[] s = {"1", "4", "9"};
        int n = 1000000000;
        System.out.println(lc.atMostNGivenDigitSet(s, n));
    }

}
