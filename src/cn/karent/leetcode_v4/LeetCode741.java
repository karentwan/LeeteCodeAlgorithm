package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 摘樱桃
 * @author wan
 * @date 2021.04.30
 ********************************************/
public class LeetCode741 {

    private int[][][] memo = null;

    private int dfs(int[][] grid, int m, int r1, int c1, int c2) {
        int r2 = r1 + c1 - c2;
        if( r1 >= m || c1 >= m || c2 >= m || r2 >= m
                || r2 < 0 || grid[r1][c1] == -1
                || grid[r2][c2] == -1 ) return Integer.MIN_VALUE/2;
        if( r1 == m-1 && c1 == m-1) return grid[r1][c1];
        if( memo[r1][c1][c2] != Integer.MIN_VALUE/2) return memo[r1][c1][c2];
        int ret = grid[r1][c1];
        if(c1 != c2) ret += grid[r2][c2];
        ret += Math.max(Math.max(dfs(grid, m, r1+1, c1, c2),
                                 dfs(grid, m, r1+1, c1, c2+1)),
                        Math.max(dfs(grid, m, r1, c1+1, c2),
                                 dfs(grid, m, r1, c1+1, c2+1)));
        memo[r1][c1][c2] = ret;
        return ret;
    }

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        if( m == 0) return 0;
        memo = new int[m][m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(memo[i][j], Integer.MIN_VALUE/2);
            }
        }
        return Math.max(dfs(grid, m, 0, 0, 0), 0);
    }

    public static void main(String[] args) {
        LeetCode741 lc = new LeetCode741();
//        int[][] grid = {{0, 1, -1},{1, 0, -1},{1, 1, 1}};
//        int[][] grid = {{1,1,-1},{1,-1,1},{-1,1,1}};
        int[][] grid = {{1,1,1,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,1},{1,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,1,1,1}};
        int ret = lc.cherryPickup(grid);
        System.out.println(ret);
    }

}
