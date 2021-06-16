package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 
 * @author wan
 * @date 2021.06.16
 ********************************************/
public class LeetCode486 {

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }

    public static void main(String[] args) {

    }

}
