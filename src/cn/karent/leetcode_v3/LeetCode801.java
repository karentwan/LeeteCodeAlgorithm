package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 使序列递增的最小交换次数
 * @author wan
 * @date 2021.04.21
 */
public class LeetCode801 {

    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        if( n == 0) return 0;
        int[][] dp = new int[n][2];
        dp[0][1] = 1;
        int INFINITY = Integer.MAX_VALUE/2;
        for (int i = 1; i < n; i++) {
            if( A[i] > A[i-1] && B[i] > B[i-1]) dp[i][0] = dp[i-1][0];
            else dp[i][0] = INFINITY;
            if( A[i] > B[i-1] && B[i] > A[i-1]) dp[i][0] = Math.min(dp[i][0], dp[i-1][1]);
            else dp[i][0] = Math.min(dp[i][0], INFINITY);

            if( A[i] > B[i-1] && B[i] > A[i-1]) dp[i][1] = dp[i-1][0] + 1;
            else dp[i][1] = INFINITY;
            if( A[i] > A[i-1] && B[i] > B[i-1]) dp[i][1] = Math.min(dp[i][1], dp[i-1][1] + 1);
            else dp[i][1] = Math.min(dp[i][1], INFINITY);
        }
        return Math.min(dp[n-1][0], dp[n-1][1]);
    }

    public static void main(String[] args) {
        LeetCode801 lc = new LeetCode801();
        int[] A = {1,3,5,4};
        int[] B = {1, 2, 3, 7};
        int ret = lc.minSwap(A,B);
        System.out.println(ret);
    }

}
