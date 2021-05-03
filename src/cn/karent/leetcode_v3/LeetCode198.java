package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 打家劫舍
 * @author wan
 * @date 2021.04.15
 */
public class LeetCode198 {

    public int rob(int[] nums) {
        if( nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if( i == 1) dp[i] = Math.max(dp[0], nums[1]);
            else dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        LeetCode198 lc = new LeetCode198();
        int[] nums = {1,2,3,1};
        int ret = lc.rob(nums);
        System.out.println(ret);
    }

}
