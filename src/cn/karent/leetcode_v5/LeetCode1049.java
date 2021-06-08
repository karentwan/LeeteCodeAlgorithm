package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 最后一块石头的重量 二
 * @author wan
 * @date 2021.06.08
 ********************************************/
public class LeetCode1049 {

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int m = sum / 2;
        int[][] dp = new int[n+1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i-1][j];
                if( j >= stones[i-1])
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - stones[i-1]] + stones[i-1]);
            }
        }
        return sum - 2 * dp[n][m];
    }

    public static void main(String[] args) {
        LeetCode1049 lc = new LeetCode1049();
        int[] stones = {2, 7, 4, 1, 8, 1};
        int ret = lc.lastStoneWeightII(stones);
        System.out.println(ret);
    }

}
