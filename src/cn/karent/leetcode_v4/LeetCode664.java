package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 奇怪的打印机
 * @author wan
 * @date 2021.05.24
 ********************************************/
public class LeetCode664 {

    public int strangePrinter(String s) {
        int n = s.length();
        if( n == 0) return 0;
        char[] chs = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int i = n-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < n; j++) {
                if( chs[i] == chs[j]) dp[i][j] = dp[i][j-1];
                else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        LeetCode664 lc = new LeetCode664();
//        String s = "aaabbb";
        String s = "aba";
        int ret = lc.strangePrinter(s);
        System.out.println(ret);
    }

}
