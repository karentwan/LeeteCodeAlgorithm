package cn.karent.leetcode_v3;

import java.util.*;

/**
 * @author wan
 * @date 2021.04.11
 */
public class LeetCode264 {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p1 = 0, p2 = 0, p3 = 0;
        int idx = 1;
        while (idx < n) {
            dp[idx] = Math.min(Math.min(dp[p1] * 2, dp[p2] * 3), dp[p3] * 5);
            if( dp[idx] == dp[p1] * 2) {
                p1++;
            }
            if( dp[idx] == dp[p2] * 3) {
                p2++;
            }
            if( dp[idx] == dp[p3] * 5) {
                p3++;
            }
            idx++;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        LeetCode264 lc = new LeetCode264();
        int n = 10;
        int ret = lc.nthUglyNumber(n);
        System.out.println(ret);
    }

}
