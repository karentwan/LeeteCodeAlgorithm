package cn.karent.leetcode_v6.weeklycontest252;

import java.util.*;

/***********************************************
 * description: 统计特殊子序列的数目
 * @author wan
 * @date 2021.08.01
 ***********************************************/
public class LeetCode5833 {

    public int countSpecialSubsequences(int[] nums) {
        int n = nums.length;
        if( n <= 3) return 0;
        long[] dp = new long[3];
        int mod = 1000_000_007;
        for (int i = 0; i < n; i++) {
            if( nums[i] == 0) {
                dp[0] = (2 * dp[0] + 1) % mod;
            } else if( nums[i] == 1) {
                dp[1] = (dp[1] * 2 + dp[0]) % mod;
            } else {
                dp[2] = (dp[2] * 2 + dp[1]) % mod;
            }
        }
        return ((int) dp[2]);
    }

    public static void main(String[] args) {
        LeetCode5833 lc = new LeetCode5833();
//        int[] arr = {0,1,2,2};
//        int[] arr = {1,1,2,2};
        int[] arr = {0,1,2,0,1,2};
        int ret = lc.countSpecialSubsequences(arr);
        System.out.println(ret);
    }

}
