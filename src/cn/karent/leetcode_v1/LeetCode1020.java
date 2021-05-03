package cn.karent.leetcode_v1;

/**
 * 飞地的数量
 */
public class LeetCode1020 {

    private int m = 0;
    private int n = 0;
    private int[] rows = {1, -1, 0, 0};
    private int[] colums = {0, 0, 1, -1};

    // 从边缘开始染色
    private void dfs(int[][] grid, int x, int y) {
        if( x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || grid[x][y] == -1) {
            return;
        }
        grid[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            int nx = x + rows[i];
            int ny = y + colums[i];
            dfs(grid, nx, ny);
        }
    }

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        if( m == 0) {
            return 0;
        }
        n = grid[0].length;
        int ret = 0;
        // 行
        for (int i = 0; i < n; i++) {
            if( grid[0][i] == 1) {
                dfs(grid, 0, i);
            }
            if( grid[m-1][i] == 1) {
                dfs(grid, m-1, i);
            }
        }
        // 列
        for (int i = 0; i < m; i++) {
            if( grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if( grid[i][n-1] == 1) {
                dfs(grid, i, n-1);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if( grid[i][j] == 1) {
                    ret++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1020 lc = new LeetCode1020();
//        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        int[][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
//        int[][] grid = {{0,0,0,1,1,1,0,1,0,0},{1,1,0,0,0,1,0,1,1,1},{0,0,0,1,1,1,0,1,0,0},{0,1,1,0,0,0,1,0,1,0},{0,1,1,1,1,1,0,0,1,0},{0,0,1,0,1,1,1,1,0,1},{0,1,1,0,0,0,1,1,1,1},{0,0,1,0,0,1,0,1,0,1},{1,0,1,0,1,1,0,0,0,0},{0,0,0,0,1,1,0,0,0,1}};
        int ret = lc.numEnclaves(grid);
        System.out.println(ret);
    }

}
