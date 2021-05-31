package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 最大正方形
 * @author wan
 * @date 2021.05.31
 ********************************************/
public class LeetCode221 {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if( m == 0) return 0;
        int n = matrix[0].length;
        int ret = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            if( dp[i][0] == 1) ret = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
            if( dp[0][i] == 1) ret = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if( matrix[i][j] == '0') dp[i][j] = 0;
                else dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                if( dp[i][j] > ret) ret = dp[i][j];
            }
        }
        return ret * ret;
    }

    public static void main(String[] args) {

    }

}
