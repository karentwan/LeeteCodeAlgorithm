package cn.karent.leetcode_v4.weeklycontest241;

import java.util.*;

/********************************************
 * description: 恰有k根木根可以看到的排列数目
 * @author wan
 * @date 2021.05.16
 ********************************************/
public class Algo5762 {

    public int rearrangeSticks(int n, int k) {
        long[][] dp = new long[n+1][k+1];
        dp[1][1] = 1;
        int MOD = ((int) (1e9 + 7));
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                // 是插在i-1个元素后面, 不是插在k个元素后面
                dp[i][j] = (dp[i-1][j] * (i-1) + dp[i-1][j-1]) % MOD;
            }
        }
        return ((int) dp[n][k]);
    }

    public static void main(String[] args) {

    }

}
