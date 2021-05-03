package cn.karent.leetcode_v1;

import java.util.*;

/**
 * 俄罗斯套娃信封问题
 * 最长上升子序列
 */
public class LeetCode354 {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (k1, k2) -> {
            if( k1[0] == k2[0]) {
                return k1[1] - k2[1];
            }
            return k1[0] - k2[0];
        });
        if( envelopes.length == 0 ) {
            return 0;
        }
        int ret = 1;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                ret = Math.max(ret, dp[i]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode354 lc = new LeetCode354();
//        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        int[][] envelopes = {{1,1},{1,1},{1,1}};
        int ret = lc.maxEnvelopes(envelopes);
        System.out.println(ret);
    }

}
