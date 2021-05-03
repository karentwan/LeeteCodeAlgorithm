package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 不同的子序列 二
 * @author wan
 * @date 2021.04.21
 */
public class LeetCode940 {

    public int distinctSubseqII(String S) {
        int n = S.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        int[] last = new int[26];
        int MOD = ((int) (1e9 + 7));
        for (int i = 1; i < n+1; i++) {
            int x = S.charAt(i-1) - 'a';
            dp[i] = 2 * dp[i-1] % MOD;
            if( last[x] > 0) dp[i] -= dp[last[x]-1];
            dp[i] %= MOD;
            last[x] = i;
        }
        dp[n]--;
        return dp[n] < 0 ? dp[n] + MOD : dp[n];
    }

    public static void main(String[] args) {
        LeetCode940 lc = new LeetCode940();
//        String s = "aba";
        String s = "pcrdhwdxmqdznbenhwjsenjhvulyve";
        int ret = lc.distinctSubseqII(s);
        System.out.println(ret);
    }

}
