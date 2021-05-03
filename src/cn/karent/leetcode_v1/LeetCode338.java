package cn.karent.leetcode_v1;

/**
 * 比特位计数
 */
public class LeetCode338 {

    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        for (int i = 1; i < num+1; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

}
