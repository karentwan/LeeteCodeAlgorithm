package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 新21点
 * @author wan
 * @date 2021.06.21
 ***********************************************/
public class LeetCode837 {

    public double new21Game(int n, int k, int maxPts) {
        if( k == 0) return 1;
        double[] dp = new double[k + maxPts];
        for(int i = Math.min(n, k + maxPts - 1); i >= k; i--) {
            dp[i] = 1;
        }
        dp[k-1] = 1.0 * Math.min(n - k + 1, maxPts) / maxPts;
        for (int i = k-2; i >= 0; i--) {
            dp[i] = dp[i+1] + (dp[i+1] - dp[i+maxPts+1]) / maxPts;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        LeetCode837 lc = new LeetCode837();
        int n = 21;
        int k = 17;
        int w = 10;
        double ret = lc.new21Game(n, k, w);
        System.out.println(ret);
    }

}
