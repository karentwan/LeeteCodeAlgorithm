package cn.karent.leetcode_v7.weeklycontest306;

import java.util.*;

/******************************************
 * 矩阵中的局部最大值
 * @author wan
 * @date 2022.08.14 10:30
 ******************************************/
public class LeetCode6148 {

    public int[][] largestLocal(int[][] grid) {
        int m = grid.length;
        if (m == 0) return new int[0][0];
        int n = grid[0].length;
        int[][] rets = new int[m-2][n-2];
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int max = 0;
                for (int k1 = i; k1 < i+3; k1++) {
                    for (int k2 = j; k2 < j+3; k2++) {
                        max = Math.max(max, grid[k1][k2]);
                    }
                }
                rets[i][j] = max;
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode6148 lc = new LeetCode6148();
    }

}
