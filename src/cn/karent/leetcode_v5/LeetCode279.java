package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 完全平方数
 * @author wan
 * @date 2021.06.11
 ********************************************/
public class LeetCode279 {

    public int numSquares(int n) {
        if( n <= 1) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode279 lc = new LeetCode279();
//        int n = 12;
        int n = 13;
        int ret = lc.numSquares(n);
        System.out.println(ret);
    }

}
