package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 停在原地的方案数
 * @author wan
 * @date 2021.05.13
 ********************************************/
public class LeetCode1269 {
/*
    private Map<String, Long> cache = new HashMap<>();

    private long dfs(int steps, int idx, int arrLen) {
        if( steps == 0) {
            return idx == 0 ?  1 : 0;
        }
        String key = steps + ":" + idx;
        if( cache.containsKey(key)) return cache.get(key);
        long ret = 0;
        if( idx < arrLen-1) {
            ret = dfs(steps-1, idx+1, arrLen);
        }
        if( idx > 0) {
            ret += dfs(steps-1, idx-1, arrLen);
        }
        ret += dfs(steps-1, idx, arrLen);
        int MOD = ((int) (1e9 + 7));
        ret = ret % MOD;
        cache.put(key, ret);
        return ret;
    }
    // 记忆化搜索
    public int numWays(int steps, int arrLen) {
        int ret = ((int) dfs(steps, 0, arrLen));
        return ret;
    }
   */
 /*   // dp
    public int numWays(int steps, int arrLen) {
        int MOD = ((int) (1e9 + 7));
        int[][] dp = new int[steps+1][arrLen];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j < arrLen; j++) {
                if( j > 0) {
                    dp[i][j] = dp[i-1][j-1] % MOD;
                }
                if( j < arrLen-1) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % MOD;
                }
                dp[i][j] = (dp[i][j] + dp[i-1][j]) % MOD;
            }
        }
        return dp[steps][0];
    }
 */
    public int numWays(int steps, int arrLen) {
        int MOD = ((int) (1e9 + 7));
        int n = Math.min(251, arrLen);
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            int[] nd = new int[n];
            for (int j = 0; j < n; j++) {
                if( j > 0) {
                    nd[j] = dp[j-1] % MOD;
                }
                if( j < n-1) {
                    nd[j] = (nd[j] + dp[j+1])%MOD;
                }
                nd[j] = (nd[j] + dp[j]) % MOD;
            }
            dp = nd;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        LeetCode1269 lc = new LeetCode1269();
//        int steps = 3;
//        int arrLen = 2;
//        int steps = 2;
//        int arrLen = 4;
        int steps = 4;
        int arrLen = 2;
        int ret = lc.numWays(steps, arrLen);
        System.out.println(ret);
    }

}
