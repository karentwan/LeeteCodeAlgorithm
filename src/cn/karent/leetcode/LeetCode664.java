package cn.karent.leetcode;

import java.util.*;

/**
 * 奇怪的打印机
 */
public class LeetCode664 {

    public int strangePrinter(String s) {
        int n = s.length();
        if( n == 0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }
        for(int i = n-1; i >= 0; i--) {
            for(int j = i+1; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
                for(int k = i+1; k <= j; k++) {
                    if( s.charAt(i) == s.charAt(k)) {
                        if( k + 1 <= j) {
                            dp[i][j] = Math.min(dp[i][j], dp[i][k-1] + dp[k+1][j]);
                        } else {
                            dp[i][j] = Math.min(dp[i][j], dp[i][k-1]);
                        }
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k-1] + dp[k][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        LeetCode664 lc = new LeetCode664();
        String s = "aaabbb";
//        String s = "abb";
        int ret = lc.strangePrinter(s);
        System.out.println(ret);
    }
}
