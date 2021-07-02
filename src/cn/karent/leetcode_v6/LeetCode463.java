package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 岛屿的周长
 * @author wan
 * @date 2021.07.02
 ***********************************************/
public class LeetCode463 {

    public int islandPerimeter(int[][] grid) {
        int ret = 0;
        int m = grid.length;
        if( m == 0) return ret;
        int n = grid[0].length;
                    // 上下左右
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if( grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int newi = i + rows[k];
                        int newj = j + cols[k];
                        if (newi < 0 || newj < 0 ||
                                newi >= m || newj >= n
                                || grid[newi][newj] == 0)
                            ret++;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode463 lc = new LeetCode463();
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int ret = lc.islandPerimeter(grid);
        System.out.println(ret);
    }

}
