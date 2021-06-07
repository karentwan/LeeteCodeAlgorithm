package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 目标和
 * @author wan
 * @date 2021.06.07
 ********************************************/
public class LeetCode494 {
/*
    private int ret = 0;

    private void dfs(int[] arr, int idx, int s, int sum) {
        if( idx >= arr.length) {
            ret = ret + (sum == s ? 1 : 0);
            return;
        }
        dfs(arr, idx+1, s, sum + arr[idx]);
        dfs(arr, idx+1, s, sum - arr[idx]);
    }

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, S, 0);
        return ret;
    }
   */

    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        int[] dp = new int[2001];
        if( n == 0) return 0;
        dp[nums[0] + 1000] += 1;
        dp[1000 - nums[0]] += 1;
        for (int i = 1; i < n; i++) {
            int t = nums[i];
            int[] np = new int[2001];
            for (int j = 0; j < 2001; j++) {
                if( j - t >= 0) np[j] += dp[j-t];
                if( j + t < 2001) np[j] += dp[j+t];
            }
            dp = np;
        }
        return dp[S + 1000];
    }

    public static void main(String[] args) {
        LeetCode494 lc = new LeetCode494();
//        int[] arr = {1, 1, 1, 1, 1};
//        int t = 3;
        int[] arr = {0,0,0,0,0,0,0,0,1};
        int t = 1;
        int ret = lc.findTargetSumWays(arr, t);
        System.out.println(ret);
    }

}
