package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 扰乱字符串
 * @author wan
 * @date 2021.04.16
 */
public class LeetCode87 {

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if(n == 0) return true;
        boolean[][][] dp = new boolean[n][n][n+1];
        for (int k = 1; k <= n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if( k == 1) {
                        dp[i][j][k] = dp[i][j][k] || s1.charAt(i) == s2.charAt(j);
                    } else {
                        for (int w = 1; w < k; w++) {
                            if( i + w >= n || j + w >= n || j+k-w >= n) break;
                            dp[i][j][k] = (dp[i][j][w] && dp[i+w][j+w][k-w]) ||
                                    (dp[i][j+k-w][w] && dp[i+w][j][k-w]);
                            if( dp[i][j][k] ) break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }

    public static void main(String[] args) {
        LeetCode87 lc = new LeetCode87();
        String s1 = "great";
        String s2 = "rgeat";
//        String s1 = "abcde";
//        String s2 = "caebd";
//        String s1 = "a";
//        String s2 = "a";
        boolean ret = lc.isScramble(s1, s2);
        System.out.println(ret);
    }

}
