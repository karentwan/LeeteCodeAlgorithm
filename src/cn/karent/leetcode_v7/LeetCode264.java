package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 丑数 二
 * @author wan
 * @date 2022.09.08 21:24
 ******************************************/
public class LeetCode264 {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p1 = 0, p2 = 0, p3 = 0;
        for (int i = 1; i < n; i++) {
            int n1 = dp[p1] * 2, n2 = dp[p2] * 3, n3 = dp[p3] * 5;
            dp[i] = Math.min(n3, Math.min(n1, n2));
            if (dp[i] == n1) p1++;
            if (dp[i] == n2) p2++;
            if (dp[i] == n3) p3++;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        LeetCode264 lc = new LeetCode264();
//        int n = 10;
        int n = 11;
        System.out.println(lc.nthUglyNumber(n));
    }

}
