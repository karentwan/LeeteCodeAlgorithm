package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 
 * @author wan
 * @date 2021.09.19
 ***********************************************/
public class LeetCode650 {

    public int minSteps1(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1;  j * j <= i; j++) {
                if( i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                    dp[i] = Math.min(dp[i], dp[i/j] + j);
                }
            }
        }
        return dp[n];
    }

    public int minSteps(int n) {
        int ret = 0;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                ret += i;
                n /= i;
            }
        }
        if( n > 1) {
            ret += n;
        }
        return ret;
    }

    public static void main(String[] args) {

    }

}
