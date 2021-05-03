package cn.karent.leetcode_v3;

import java.util.*;

/********************************************
 * description: 多米诺和托米诺平铺
 * @author wan
 * @date 2021.04.23
 ********************************************/
public class LeetCode790 {

    public int numTilings(int N) {
        if( N <= 1) return N;
        long[][] dp = new long[N+1][4];
        int base = ((int) (1e9 + 7));
        dp[0][0] = dp[0][3] = 1;
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i-1][3] % base;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % base;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % base;
            dp[i][3] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-1][3]) % base;
        }
        return ((int) dp[N-1][3]);
    }

    public static void main(String[] args) {
        LeetCode790 lc = new LeetCode790();
        int N = 3;
//        int N = 2;
        int ret = lc.numTilings(N);
        System.out.println(ret);
    }

}
