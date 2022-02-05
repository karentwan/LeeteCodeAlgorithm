package cn.karent.leetcode_v7;

import java.util.*;

/***********************************************
 * description: 黄金矿工, 回溯
 * @author wan
 * @date 2022.02.05
 ***********************************************/
public class LeetCode1219 {

    private int dfs(int[][] grid, int row, int col,
                    int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 0;
        }
        if (grid[row][col] == 0) {
            return 0;
        }
        int t = grid[row][col];
        grid[row][col] = 0;
        int[] dirs = {1, 0, -1, 0, 1};
        int ans = 0;
        for (int i = 1; i < dirs.length; i++) {
            int newRow = row + dirs[i - 1];
            int newCol = col + dirs[i];
            ans = Math.max(ans, dfs(grid, newRow, newCol, m, n));
        }
        ans += t;
        grid[row][col] = t;
        return ans;
    }

    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(grid, i, j, m, n));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1219 lc = new LeetCode1219();
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        System.out.println(lc.getMaximumGold(grid));
    }

}
