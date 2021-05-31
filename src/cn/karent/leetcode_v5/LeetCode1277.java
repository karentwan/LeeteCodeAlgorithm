package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 统计全为1的正方形子矩阵
 * @author wan
 * @date 2021.05.31
 ********************************************/
public class LeetCode1277 {

/*
    private int convolution(int[][] matrix, int k, int area) {
        int mh = matrix.length;
        if( mh == 0) return 0;
        int mw = matrix[0].length;
        int ret = 0;
        for (int i = 0; i < mh - k + 1; i++) {
            for (int j = 0; j < mw - k + 1; j++) {
                int t = 0;
                for (int x = 0; x < k; x++) {
                    for (int y = 0; y < k; y++) {
                        t += matrix[i+x][j+y];
                    }
                }
                if( t == area) ret++;
            }
        }
        return ret;
    }

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        if( m == 0) return 0;
        int n = matrix[0].length;
        int ret = 0;
        int kMax = Math.min(m, n);
        for (int i = 1; i <= kMax; i++) {
            ret += convolution(matrix, i, i * i);
        }
        return ret;
    }
   */

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        if( m == 0) return 0;
        int n = matrix[0].length;
        int ret = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if( matrix[i][0] == 1) {
                dp[i][0] = 1;
                ret++;
            }
        }
        for (int i = 1; i < n; i++) {
            if( matrix[0][i] == 1) {
                dp[0][i] = 1;
                ret++;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if( matrix[i][j] == 0 ) dp[i][j] = 0;
                else dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                ret += dp[i][j];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1277 lc = new LeetCode1277();
//        int[][] matrix = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        int[][] matrix = {{1,0,1},{1,1,0},{1,1,0}};
        int ret = lc.countSquares(matrix);
        System.out.println(ret);
    }

}
