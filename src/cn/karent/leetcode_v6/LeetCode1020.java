package cn.karent.leetcode_v6;

/*******************************************
 * @author wan
 * @date: 2022-02-12 10:02
 * @description: 飞地的数量
 *  可以使用染色法, 从边缘开始深度优先对陆地进行染色
 *******************************************/
public class LeetCode1020 {
/*
    private int dfs(int[][] grid, int row, int col, int m, int n, boolean[] vis) {
        int[] dirs = {1, 0, -1, 0, 1};
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return -1;  // 出界
        }
        if (vis[row * n + col] || grid[row][col] == 0) {  // 已经访问过的节点
            return 0;
        }
        // 判断后再记录
        vis[row * n + col] = true;  // 记录访问过的单元格
        int ans = 1;
        for (int i = 1; i < dirs.length; i++) {
            int nrow = row + dirs[i-1];
            int ncol = col + dirs[i];
            int child = dfs(grid, nrow, ncol, m, n, vis);
            if (child == -1) {
                ans = -1;
            }
            if (ans > 0) {  // 如果不大于0, 说明已经有一条通路出界
                ans += child;
            }
        }
        return ans;
    }
    // 深度优先暴力搜索
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        boolean[] vis = new boolean[m * n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i * n + j] && grid[i][j] == 1) {
                    int d = dfs(grid, i, j, m, n, vis);
                    if (d > 0) ans += d;
                }
            }
        }
        return ans;
    }

  */

    private void dfs(int[][] grid, int row, int col, int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 2 || grid[row][col] == 0) {
            return;
        }
        int[] dirs = {1, 0, -1, 0, 1};
        grid[row][col] = 2;  // 陆地染色
        for (int i = 1; i < dirs.length; i++) {
            int nrow = row + dirs[i-1];
            int ncol = col + dirs[i];
            dfs(grid, nrow, ncol, m, n);
        }

    }

    // 深度优先染色法, 将直连边界的陆地染为2, 最后再统计地图上数值为1的陆地就是我们需要求得陆地
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m-1 || j == 0 || j == n-1) {  // 从边界开始染
                    dfs(grid, i, j, m, n);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1020 lc = new LeetCode1020();
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
//        int[][] grid = {{0,0,0,1,1,1,0,1,0,0},{1,1,0,0,0,1,0,1,1,1},{0,0,0,1,1,1,0,1,0,0},{0,1,1,0,0,0,1,0,1,0},{0,1,1,1,1,1,0,0,1,0},{0,0,1,0,1,1,1,1,0,1},{0,1,1,0,0,0,1,1,1,1},{0,0,1,0,0,1,0,1,0,1},{1,0,1,0,1,1,0,0,0,0},{0,0,0,0,1,1,0,0,0,1}};
        System.out.println(lc.numEnclaves(grid));
    }

}
