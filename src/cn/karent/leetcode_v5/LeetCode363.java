package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 矩形区域不超过K的最大数值和
 * @author wan
 * @date 2021.05.29
 ********************************************/
public class LeetCode363 {

    private int gt(int[] tmps, int r, int target) {  // 大于等于target
        int l = 0;
        while (l < r) {
            int m = l + (r-l)/2;
            if( tmps[m] >= target) r = m;
            else l = m+1;
        }
        return l;
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        if( m == 0) return 0;
        int n = matrix[0].length;
        int[][] preSum = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1]
                        + matrix[i-1][j-1] - preSum[i-1][j-1];
            }
        }
        int ret = Integer.MIN_VALUE;
        for (int x1 = 0; x1 <= m; x1++) {
            for (int x2 = x1+1; x2 <= m; x2++) {
                int[] tmps = new int[n+1];
                for (int i = 1; i <= n; i++) {
                    int t = preSum[x2][i] - preSum[x1][i];
                    int idx = gt(tmps, i, t - k);
                    if( idx < i && t - tmps[idx] > ret) ret = t - tmps[idx];
                    // 插入
                    int j = i-1;
                    while (j >= 0 && t < tmps[j]) {
                        tmps[j+1] = tmps[j];
                        j--;
                    }
                    tmps[j+1] = t;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode363 lc = new LeetCode363();
        int[][] matrix = {{1,0,1},{0,-2,3}};
        int k = 2;
        int ret = lc.maxSumSubmatrix(matrix, k);
        System.out.println(ret);
    }

}
