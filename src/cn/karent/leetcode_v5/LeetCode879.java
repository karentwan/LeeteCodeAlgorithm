package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 盈利计划
 * @author wan
 * @date 2021.06.09
 ********************************************/
public class LeetCode879 {
/*
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int[][][] dp = new int[len+1][n+1][minProfit+1];
        dp[0][0][0] = 1;
        int mod = ((int) (1e9 + 7));
        for (int i = 1; i <= len; i++) {
            int p = profit[i-1];
            int g = group[i-1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = dp[i-1][j][k];
                    if( j >= g) {
                        *//**
                         * 前i份工作选用j个人盈利k,有两种可能, 一种是前i-1份工作选用j个人盈利k(不选i)
                         * 加上前i-1份工作选用j-g个人盈利max(k-p, 0)
                         * max(k-p, 0)其实可以看成是一个判断语句, 如果k < p, 说明第i份工作一个人就满足了条件,
                         * 前i-1份工作盈利为0都可以
                         *//*
                        dp[i][j][k] = (dp[i-1][j][k] + dp[i-1][j-g][Math.max(k-p, 0)]) % mod;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = (sum + dp[len][i][minProfit]) % mod;

        }
        return sum;
    }
   */

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int[][] dp = new int[n+1][minProfit+1];
        dp[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        int mod = ((int) (1e9 + 7));
        for (int i = 1; i <= len; i++) {
            int p = profit[i-1], g = group[i-1];
            for (int j = n; j >= 0; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    if( j >= g) dp[j][k] = (dp[j][k] + dp[j-g][Math.max(k - p, 0)]) % mod;
                }
            }
        }
        return dp[n][minProfit];
    }

    public static void main(String[] args) {
        LeetCode879 lc = new LeetCode879();
//        int n = 5;
//        int minProfit = 3;
//        int[] group = {2, 2};
//        int[] profit = {2,3};
//        int n = 10;
//        int minProfit = 5;
//        int[] group = {2, 3,5};
//        int[] profit = {6,7,8};
        int n = 64;
        int minProfit = 0;
        int[] group = {80,40};
        int[] profit = {88,88};
        int ret = lc.profitableSchemes(n, minProfit, group, profit);
        System.out.println(ret);
    }

}
