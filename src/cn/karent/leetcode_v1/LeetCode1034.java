package cn.karent.leetcode_v1;

/**
 * 边框着色
 */
public class LeetCode1034 {

    private int m = 0;
    private int n = 0;
    private int[] rows   = {0, 0, 1, -1};
    private int[] colums = {1, -1, 0, 0};

    // return if border?
    private boolean dfs(int[][] grid, int x, int y, int oldColor, int newColor, boolean[][] visited) {
        if( x < 0 || x >= m || y < 0 || y >= n ) {
            return true;
        }
        if( visited[x][y] ) {
            return false;
        }
        if( grid[x][y] != oldColor) {
            return true;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + rows[i];
            int ny = y + colums[i];
            if( dfs(grid, nx, ny, oldColor, newColor, visited)) {
                grid[x][y] = newColor;
            }
        }
        return false;
    }

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        m = grid.length;
        if( m == 0) {
            return grid;
        }
        n = grid[0].length;
        if( r0 < 0 || r0 >= m || c0 < 0 || c0 >= n || grid[r0][c0] == color) {
            return grid;
        }
        boolean[][] visited = new boolean[m][n];
        dfs(grid, r0, c0, grid[r0][c0], color, visited);
        return grid;
    }

    public static void main(String[] args) {
        LeetCode1034 lc = new LeetCode1034();
        int[][] grid = {{1, 1}, {1,2}};
        int r0 = 1;
        int c0 = 0;
        int color = 3;
//        int[][] grid = {{1,1,1},{1,1,1},{1,1,1}};
//        int r0 = 1;
//        int c0 = 1;
//        int color = 2;
        int[][] rets = lc.colorBorder(grid, r0, c0, color);
        for (int[] ret : rets) {
            for (int i : ret) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
