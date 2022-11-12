package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 多米诺和托米诺平铺
 * @author wan
 * @date 2022.11.12 11:38
 ******************************************/
public class LeetCode790 {

    public int numTilings(int n) {
        int mod = (int) 1e9+7;
        // 四种状态, 0: 空, 1: 只有上面被覆盖, 2: 只有下面被覆盖, 3: 全覆盖
        long[][] dp = new long[n+1][4];
        dp[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i-1][3];
            dp[i][1] = (dp[i-1][0] + dp[i-1][2])%mod;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1])%mod;
            dp[i][3] = (dp[i-1][3] + dp[i-1][1] + dp[i-1][2] + dp[i-1][0])%mod;
        }
        return (int) (dp[n][3] % mod);
    }

    public static void main(String[] args) {
        LeetCode790 lc = new LeetCode790();
        int n = 60;
        System.out.println(lc.numTilings(n));
    }

}
