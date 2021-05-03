package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 打家劫舍 二
 * @author wan
 * @date 2021.04.15
 */
public class LeetCode213 {

    public int rob(int[] nums) {
        int n = nums.length;
        if( n == 0) return 0;
        if( n == 1) return nums[0];
        if( n == 2) return Math.max(nums[0], nums[1]);
        int[][] dp = new int[n][2];
        dp[0][1] = nums[0];
        dp[1][0] = nums[1];
        dp[1][1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i-2][0] + nums[i], dp[i-1][0]);
            if( i != n-1) dp[i][1] = Math.max(dp[i-2][1] + nums[i], dp[i-1][1]);
            else dp[i][1] = dp[i-1][1];
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

    public static void main(String[] args) {
        LeetCode213 lc = new LeetCode213();
//        int[] nums = {2,3,2};
        int[] nums = {1,2,3,1};
//        int[] nums = {0};
//        int[] nums = {2,1,1,2};
        int ret = lc.rob(nums);
        System.out.println(ret);
    }

}
