package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 矩形区域不超过k的最大数值和
 * @author wan
 * @date 2021.04.22
 */
public class LeetCode363 {

 /*   // 暴力求解
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        if( m == 0) return 0;
        int n = matrix[0].length;
        int[][] preSum = new int[m+1][n+1];
        // 前缀和
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                preSum[i][j] += matrix[i-1][j-1] + preSum[i][j-1] + preSum[i-1][j] - preSum[i-1][j-1];
            }
        }
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = i+1; l <= m; l++) {
                    for (int p = j+1; p <= n; p++) {
                        int tmp = preSum[l][p] - preSum[i][p] - preSum[l][j] + preSum[i][j];
                        if( tmp <= k && tmp > ret) ret = tmp;
                    }
                }
            }
        }
        return ret;
    }
  */
    // 优化
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        if( m == 0) return 0;
        int n = matrix[0].length;
        int[][] preSum = new int[m+1][n+1];
        // 前缀和
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                preSum[i][j] += matrix[i-1][j-1] + preSum[i][j-1] + preSum[i-1][j] - preSum[i-1][j-1];
            }
        }
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j <= m; j++) {
                TreeSet<Integer> ts = new TreeSet<>();
                // 前缀和是从零开始的
                ts.add(0);
                for (int l = 1; l <= n; l++) {
                    int tmp = preSum[j][l] - preSum[i][l];
                    Integer val = ts.ceiling(tmp - k);
//                    System.out.println("tmp:" + tmp + "\tval:" + val);
                    if( val != null && tmp - val > ret) ret = tmp - val;
                    ts.add(tmp);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode363 lc = new LeetCode363();
//        int[][] matrix = {{1,0,1},{0,-2,3}};
//        int k = 2;
        int[][] matrix = {{2,2,-1}};
        int k = 3;
//        int[][] matrix = {{2,2,-1}};
//        int k = 0;
        int ret = lc.maxSumSubmatrix(matrix, k);
        System.out.println(ret);
    }

}
