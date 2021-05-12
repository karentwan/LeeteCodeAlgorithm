package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 矩阵中的幻方
 * @author wan
 * @date 2021.05.12
 ********************************************/
public class LeetCode840 {

    public int numMagicSquaresInside(int[][] grid) {
        int ret = 0;
        int m = grid.length;
        if( m == 0) return ret;
        int n = grid[0].length;
        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n-3; j++) {
                if( magicSquare(grid, i, j)) ret++;
            }
        }
        return ret;
    }

    private boolean magicSquare(int[][] grid, int s, int e) {
        int[] tmps = new int[9];
        for (int i = s; i < s + 3; i++) {
            for (int j = e; j < e+3; j++) {
                if( grid[i][j] > 9 || grid[i][j] <= 0) continue;
                tmps[grid[i][j] - 1]++;
            }
        }
        for (int i = 0; i < 9; i++) {
            if( tmps[i] == 0) return false;
        }
        int sum = grid[s][e] + grid[s][e+1] + grid[s][e+2];
        for (int i = 1; i < 3; i++) {
            int t = grid[s+i][e] + grid[s+i][e+1] + grid[s+i][e+2];
            if( sum != t) return false;
        }
        for (int i = 0; i < 3; i++) {
            int t = grid[s][e+i] + grid[s+1][e+i] + grid[s+2][e+i];
            if( sum != t) return false;
        }
        int t = grid[s][e] + grid[s+1][e+1] + grid[s+2][e+2];
        if( t != sum) return false;
        t = grid[s][e+2] + grid[s+1][e+1] + grid[s+2][e];
        if( t != sum) return false;
        return true;
    }

    public static void main(String[] args) {
        LeetCode840 lc = new LeetCode840();
//        int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
//        int[][] grid = {{10,3,5},{1,6,11},{7,9,2}};
        int[][] grid = {{7,0,5},{2,4,6},{3,8,1}};
        int ret = lc.numMagicSquaresInside(grid);
        System.out.println(ret);
    }

}
