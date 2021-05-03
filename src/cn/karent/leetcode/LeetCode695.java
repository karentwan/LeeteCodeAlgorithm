package cn.karent.leetcode;

/**
 * 岛屿的最大面积
 */
public class LeetCode695 {

    private int m = 0;
    private int n = 0;

    private int dfs(int[][] grid, int x, int y) {
        if( x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || grid[x][y] == -1) {
            return 0;
        }
        grid[x][y] = -1;
        int[] rd = {1, -1, 0, 0};
        int[] cd = {0, 0, 1, -1};
        int val = 0;
        for(int i = 0; i < 4; i++) {
            int nx = x + rd[i];
            int ny = y + cd[i];
            val += dfs(grid, nx, ny);
        }
        return val + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        if( m == 0) {
            return 0;
        }
        n = grid[0].length;
        int ret = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ret = Math.max(ret, dfs(grid, i, j));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode695 lc = new LeetCode695();
//        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,1,1,0,1,0,0,0,0,0,0,0,0}, {0,1,0,0,1,1,0,0,1,0,1,0,0}, {0,1,0,0,1,1,0,0,1,1,1,0,0}, {0,0,0,0,0,0,0,0,0,0,1,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] grid = {{0,0,0,0,0,0,0,0}};
        int ret = lc.maxAreaOfIsland(grid);
        System.out.println(ret);
    }
}
