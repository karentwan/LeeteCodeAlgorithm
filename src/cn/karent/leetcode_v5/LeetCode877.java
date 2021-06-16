package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 石子游戏
 * @author wan
 * @date 2021.06.16
 ********************************************/
public class LeetCode877 {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                // 最小可以转换成最大,
                dp[i][j] = Math.max(piles[i] -dp[i+1][j], piles[j]-dp[i][j-1]);
            }
        }
        return dp[0][n-1] > 0;
    }

    public static void main(String[] args) {
        LeetCode877 lc = new LeetCode877();
//        int[] arr = {5, 3, 4, 5};
        int[] arr = {3,7,2,3};
        boolean ret = lc.stoneGame(arr);
        System.out.println(ret);
    }

}
