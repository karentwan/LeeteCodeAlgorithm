package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 元素和为目标值的子矩阵数量
 * @author wan
 * @date 2021.05.29
 ********************************************/
public class LeetCode1074 {

    private int less(int[] tmps, int r, int target) {  // 小于
        int l = 0;
        while (l <= r) {
            int m = l + (r - l)/2;
            if( tmps[m] >= target) r = m-1;
            else l = m+1;
        }
        return r;
    }

    private int great(int[] tmps, int r, int target) {  // 大于
        int l = 0;
        while ( l <= r) {
            int m = l + (r-l)/2;
            if( tmps[m] > target) r = m-1;
            else l = m+1;
        }
        return l;
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        if( m == 0) return 0;
        int n = matrix[0].length;
        int[][] preSum = new int[m+1][n+1];
        int ret = 0;
        // 求前缀和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1]
                                - preSum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        for (int x1 = 0; x1 <= m; x1++) {
            for (int x2 = x1 + 1; x2 <= m; x2++) {
                int[] tmps = new int[n+1];
                for (int i = 1; i <= n; i++) {
                    int t = preSum[x2][i] - preSum[x1][i];
                    int t1 = t - target;
                    int left = less(tmps, i-1, t1);
                    int right = great(tmps, i-1, t1);
                    ret += left == right ? 0 : right - left - 1;
                    int j = i-1;
                    while ( j >= 0 && t < tmps[j]) {
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
        LeetCode1074 lc = new LeetCode1074();
        int[][] matrix = {{0,1,0},{1,1,1},{0,1,0}};
        int target = 0;
//        int[][] matrix = {{1,-1},{-1,1}};
//        int target = 0;
        int ret = lc.numSubmatrixSumTarget(matrix, target);
        System.out.println(ret);
    }

}
