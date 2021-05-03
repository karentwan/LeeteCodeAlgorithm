package cn.karent.leetcode_v1;

/**
 * 统计封闭岛屿的数目
 */
public class LeetCode1254 {

    private int[] rows = {1, -1, 0, 0};

    private int[] cols = {0, 0, 1, -1};

    private int m;

    private int n;

    // 开始染色
    private void dfs(int[][] grid, int x, int y, boolean[][] visited, int color) {
        if( x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] == 1) {
            return;
        }
        visited[x][y] = true;
        grid[x][y] = color;
        for (int i = 0; i < 4; i++) {
            int nx = x + rows[i];
            int ny = y + cols[i];
            dfs(grid, nx, ny, visited, color);
        }
    }

    public int closedIsland(int[][] grid) {
        m = grid.length;
        if( m == 0) {
            return 0;
        }
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        //
        for (int i = 0; i < m; i++) {
            if( !visited[i][0] && grid[i][0] == 0) {
                dfs(grid, i, 0, visited, 1);
            }
            if( !visited[i][n-1] && grid[i][n-1] == 0) {
                dfs(grid, i, n-1, visited, 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if( !visited[0][i] && grid[0][i] == 0) {
                dfs(grid, 0, i, visited, 1);
            }
            if( !visited[m-1][i] && grid[m-1][i] == 0) {
                dfs(grid, m-1, i, visited, 1);
            }
        }
        int ret = 0;
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if( !visited[i][j] && grid[i][j] == 0) {
                    ret++;
                    dfs(grid, i, j, visited, 1);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1254 lc = new LeetCode1254();
//        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        int[][] grid = {{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
        int ret = lc.closedIsland(grid);
        System.out.println(ret);
    }

}
