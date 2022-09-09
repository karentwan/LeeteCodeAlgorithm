package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 超级丑数
 * @author wan
 * @date 2022.09.09 23:12
 ******************************************/
public class LeetCode313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n];
        dp[0] = 1;
        int[] p = new int[primes.length];
        for (int i = 1; i < n; i++) {
            long min = primes[0] * dp[p[0]];
            for (int j = 1; j < primes.length; j++) {
                min = Math.min(min, primes[j] * dp[p[j]]);
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * dp[p[j]] == min) {
                    p[j]++;
                }
            }
        }
        return (int) dp[n-1];
    }

    public static void main(String[] args) {
        LeetCode313 lc = new LeetCode313();
//        int n = 12;
//        int[] primes = {2,7,13,19};
        int n = 5911;
        int[] primes = {2,3,5,7};
        System.out.println(lc.nthSuperUglyNumber(n, primes));
    }

}
