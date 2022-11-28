package cn.karent.leetcode_v8;

import java.util.*;

/******************************************
 * 最大平均值和的分组
 * @author wan
 * @date 2022.11.28 14:26
 ******************************************/
public class LeetCode813 {

    public double largestSumOfAverages(int[] nums, int k) {
        int m = nums.length;
        double[][] dp = new double[k][m];
        int[] preSum = new int[m+1];
        for (int i = 1; i <= m; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i-1] = preSum[i] * 1.0 / i;
        }
        for (int i = 1; i < k; i++) {
            for (int j = i; j < m; j++) {
                for (int l = i-1; l < j; l++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][l] + (preSum[j+1] - preSum[l+1]) * 1.0 / (j - l));
                }
            }
        }
        return dp[k-1][m-1];
    }

    public static void main(String[] args) {
        LeetCode813 lc = new LeetCode813();
//        int[] nums = {9,1,2,3,9};
//        int k = 3;
        int[] nums = {1,2,3,4,5,6,7};
        int k = 4;
        System.out.println(lc.largestSumOfAverages(nums, k));
    }

}
