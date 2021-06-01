package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 元素和小于等于阈值的正方向最大边长
 * @author wan
 * @date 2021.06.01
 ********************************************/
public class LeetCode1292 {

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        if( m == 0) return 0;
        int n = mat[0].length;
        long[][] preSum = new long[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1]
                               + mat[i-1][j-1] - preSum[i-1][j-1];
            }
        }
        int kMax = Math.min(m, n);
        int l = 0, r = kMax;
        while (l <= r) {
            int medium = l + (r-l)/2;
            long t = count(preSum, medium);
            if( t == threshold) return medium;
            else if( t > threshold) r = medium-1;
            else l = medium+1;
        }
        return r;
    }

    private long count(long[][] preSum, int medium) {
        int m = preSum.length;
        int n = preSum[0].length;
        long ret = Integer.MAX_VALUE;
        for (int i = medium; i < m; i++) {
            for (int j = medium; j < n; j++) {
                // 计算正方形的元素和
                long t = preSum[i][j] - preSum[i][j-medium]
                        - preSum[i-medium][j] + preSum[i-medium][j-medium];
                ret = Math.min(t, ret);
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        LeetCode1292 lc = new LeetCode1292();
        int[][] mat = {{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
        int th = 4;
        int ret = lc.maxSideLength(mat, th);
        System.out.println(ret);
    }

}
