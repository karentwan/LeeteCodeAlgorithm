package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 下降路径最小和
 * @author wan
 * @date 2021.04.19
 */
public class LeetCode931 {

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        if( m == 0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n+2];
        for (int i = 1; i <= n; i++) {
            dp[0][i] = matrix[0][i-1];
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = dp[i][n+1] = Integer.MAX_VALUE/2;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i-1][j+1]) + matrix[i][j-1];
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            ret = Math.min(dp[m-1][i], ret);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode931 lc = new LeetCode931();
//        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int[][] matrix = {{-19,57},{-40,-5}};
        int ret = lc.minFallingPathSum(matrix);
        System.out.println(ret);
    }

}
