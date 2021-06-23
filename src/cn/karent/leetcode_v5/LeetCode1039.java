package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 多边形三角剖分的最低得分
 * @author wan
 * @date 2021.06.23
 ***********************************************/
public class LeetCode1039 {

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k][j]
                            + values[i] * values[j] * values[k]);
                }
                dp[i][j] = min == Integer.MAX_VALUE ? 0 : min;
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        LeetCode1039 lc = new LeetCode1039();
//        int[] arr = {1,2,3};
        int[] arr = {3,7,4,5};
        int ret = lc.minScoreTriangulation(arr);
        System.out.println(ret);
    }

}
