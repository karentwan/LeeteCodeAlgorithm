package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 粉刷房子三
 * @author wan
 * @date 2021.05.04
 ********************************************/
public class LeetCode1473 {

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][target+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= target; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE/2);
            }
        }
        if( houses[0] == 0) {
            for (int i = 1; i <= n; i++) {
                dp[0][1][i] = cost[0][i-1];
            }
        } else {
            dp[0][1][houses[0]] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= target; j++) {
                if( houses[i] == 0) {
                    for (int k = 1; k <= n; k++) {
                        // j-1里面不同的颜色染过来
                        for (int l = 1; l <= n; l++) {
                            if (l != k) {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j - 1][l] + cost[i][k-1]);
                            }
                        }
                        // j-1里面相同的颜色染过来
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k] + cost[i][k-1]);
                    }
                } else {
                    int color = houses[i];
                    for (int l = 1; l <= n; l++) {
                        if( l != color) {
                            dp[i][j][color] = Math.min(dp[i][j][color], dp[i-1][j-1][l]);
                        }
                    }
                    dp[i][j][color] = Math.min(dp[i][j][color], dp[i-1][j][color]);
                }
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            ret = Math.min(ret, dp[m-1][target][i]);
        }
        return ret == Integer.MAX_VALUE/2 ? -1 : ret;
    }

    public static void main(String[] args) {
        LeetCode1473 lc = new LeetCode1473();
//        int[] houses = {0, 0, 0, 0, 0};
//        int[][] cost = {{1,10},{10,1},{10,1},{1,10},{5,1}};
//        int m = 5;
//        int n = 2;
//        int target = 3;
//        int[] houses = {0,2,1,2,0};
//        int[][] cost = {{1,10},{10,1},{10,1},{1,10},{5,1}};
//        int m = 5;
//        int n = 2;
//        int target = 3;
        int[] houses = {3,1,2,3};
        int[][] cost = {{1,1,1},{1,1,1},{1,1,1},{1,1,1}};
        int m = 4;
        int n = 3;
        int target = 3;
//        int[] houses = {2,3,0};
//        int[][] cost = {{5,2,3},{3,4,1},{1,2,1}};
//        int m = 3;
//        int n = 3;
//        int target = 3;
        int ret = lc.minCost(houses, cost, m, n, target);
        System.out.println(ret);
    }

}
