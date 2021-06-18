package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 分汤
 * @author wan
 * @date 2021.06.18
 ********************************************/
public class LeetCode808 {

    public double soupServings(int N) {
        int n = N / 25 + (N % 25 == 0 ? 0 : 1);
        if( N > 2000) return 1.0;
        double[][] dp = new double[n+1][n+1];
        dp[0][0] = 0.5;
        // dp[i][j] A用i, B用j的概率
        for (int i = 1; i <= n; i++) dp[0][i] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1;  j <= n; j++) {
                dp[i][j] = dp[Math.max(0, i-4)][j] + dp[Math.max(0, i-3)][j-1]
                        + dp[Math.max(0, i-2)][Math.max(j-2, 0)] + dp[i-1][Math.max(0, j-3)];
                dp[i][j] /= 4;
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        LeetCode808 lc = new LeetCode808();
        int N = 50;
        double ret = lc.soupServings(N);
        System.out.println(ret);
    }

}
