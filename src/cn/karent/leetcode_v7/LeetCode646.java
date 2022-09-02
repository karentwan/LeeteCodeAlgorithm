package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 最长数对链
 * @author wan
 * @date 2022.09.03 00:12
 ******************************************/
public class LeetCode646 {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (k1, k2) -> k1[0] - k2[0]);
        int ret = 0;
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        for (int i = 1; i < pairs.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode646 lc = new LeetCode646();
        int[][] pairs = {{1,2}, {2,3}, {3,4}};
        System.out.println(lc.findLongestChain(pairs));
    }

}
