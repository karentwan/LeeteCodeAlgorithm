package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 香槟塔
 * @author wan
 * @date 2021.06.18
 ********************************************/
public class LeetCode799 {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[102][102];
        dp[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double t = (dp[i][j] - 1) / 2;
                if( t > 0) {
                    dp[i+1][j] += t;
                    dp[i+1][j+1] += t;
                }
            }
        }
        return Math.min(1, dp[query_row][query_glass]);
    }

    public static void main(String[] args) {

    }

}
