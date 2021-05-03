package cn.karent.leetcode_v1;

/**
 * 不同路径 三
 */
public class LeetCode980 {

    private int ret = 0;

    private int row;

    private int column;

    private int[] rows = {1, -1, 0, 0};

    private int[] colums = {0, 0, 1, -1};

    private int endx;

    private int endy;

    private void dfs(int[][] grid, int x, int y, int n, boolean[][] visited) {
        if(n == 0 && x == endx && y == endy) {
            ret++;
            return;
        }
        if( x < 0 || x >= row || y < 0 || y >= column ||
                grid[x][y] == -1 || grid[x][y] == 2 || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + rows[i];
            int ny = y + colums[i];
            dfs(grid, nx, ny, n-1, visited);
        }
        visited[x][y] = false;
    }

    public int uniquePathsIII(int[][] grid) {
        row = grid.length;
        if( row == 0) {
            return ret;
        }
        column = grid[0].length;
        int startx = 0;
        int starty = 0;
        int n = 1;
        endx = 0;
        endy = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if( grid[i][j] == 0) {
                    n++;
                } else if( grid[i][j] == 1) {
                    startx = i;
                    starty = j;
                } else if( grid[i][j] == 2) {
                    endx = i;
                    endy = j;
                }
            }
        }
        dfs(grid, startx, starty, n, new boolean[row][column]);
        return ret;
    }

    public static void main(String[] args) {
        LeetCode980 lc = new LeetCode980();
//        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        int ret = lc.uniquePathsIII(grid);
        System.out.println(ret);
    }

}
