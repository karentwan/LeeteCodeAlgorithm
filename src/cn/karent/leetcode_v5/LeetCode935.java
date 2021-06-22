package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 骑士拨号器
 * @author wan
 * @date 2021.06.22
 ***********************************************/
public class LeetCode935 {

    public int knightDialer(int n) {
        int[][] nodes = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},
                {0,1,7},{2,6},{1,3},{2,4}};
        int[][] dp = new int[2][10];
        int mod = 1_000_000_007;
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < n; i++) {
            int idx = ~i & 1;
            Arrays.fill(dp[idx], 0);
            for (int j = 0; j < nodes.length; j++) {
                for (int node : nodes[j]) {
                    dp[idx][j] += dp[i & 1][node];
                    dp[idx][j] %= mod;
                }
            }
        }
        int idx = ~n&1;
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[idx][i]) % mod;
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode935 lc = new LeetCode935();
        int n = 1;
        int ret = lc.knightDialer(n);
        System.out.println(ret);
    }

}
