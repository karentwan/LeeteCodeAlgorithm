package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 两个字符串的删除操作
 * @author wan
 * @date 2021.09.25
 ***********************************************/
public class LeetCode583 {

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int n2 = word2.length();
        char[] chs1 = word1.toCharArray();
        char[] chs2 = word2.toCharArray();
        int[][] dp = new int[n+1][n2+1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n2; j++) {
                if( chs1[i-1] == chs2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }
        return dp[n][n2];
    }

    public static void main(String[] args) {

    }

}
