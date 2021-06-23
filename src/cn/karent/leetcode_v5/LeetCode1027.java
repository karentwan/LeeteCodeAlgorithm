package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 最长等差数列
 * @author wan
 * @date 2021.06.23
 ***********************************************/
public class LeetCode1027 {

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if( n == 0) return 0;
        int[][] dp = new int[n][20002];
        Arrays.fill(dp[0], 1);
        int ret = 1;
        for (int i = 1; i < n; i++) {
            Arrays.fill(dp[i], 1);
            for (int j = i-1; j >= 0; j--) {
                int t = nums[i] - nums[j] + 10000;
                dp[i][t] = Math.max(dp[i][t], dp[j][t] + 1);
                ret = Math.max(ret, dp[i][t]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1027 lc = new LeetCode1027();
//        int[] arr = {3, 6, 9, 12};
        int[] arr = {3, 6, 9, 12};
        int ret = lc.longestArithSeqLength(arr);
        System.out.println(ret);
    }

}
