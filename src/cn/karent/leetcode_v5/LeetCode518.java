package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 零钱兑换二
 * @author wan
 * @date 2021.06.10
 ********************************************/
public class LeetCode518 {

  /*
    // 完全背包问题
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            int coin = coins[i-1];
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i-1][j];
                for (int k = 1; coin * k <= j; k++) {
                    int t = coin * k;
                    dp[i][j] += dp[i-1][j - t];
                }
            }
        }
        return dp[n][amount];
    }
  */

    // 完全背包优化
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int coin = coins[i-1];
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        LeetCode518 lc = new LeetCode518();
        int amount = 5;
        int[] coins = {1,2,5};
//        int amount = 3;
//        int[] coins = {2};
        int ret = lc.change(amount, coins);
        System.out.println(ret);
    }

}
