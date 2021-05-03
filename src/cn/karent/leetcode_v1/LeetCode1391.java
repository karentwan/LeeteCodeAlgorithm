package cn.karent.leetcode_v1;

import java.util.*;

/**
 * 检查网格中是否存在有效路径
 */
public class LeetCode1391 {

    private int m;

    private int n;

    private int[] rows = {-1, 1, 0, 0};

    private int[] cols = {0, 0, -1, 1};

    private int[][][] edges = {
            {
                    {0,0,0,0,0,0},
                    {0,0,0,0,0,0},
                    {1,0,0,1,0,1},
                    {1,0,1,0,1,0},
            },
            {
                    {0,1,1,1,0,0},
                    {0,1,0,0,1,1},
                    {0,0,0,0,0,0},
                    {0,0,0,0,0,0}
            },
            {
                    {0,0,0,0,0,0},
                    {0,1,0,0,1,1},
                    {1,0,0,1,0,1},
                    {0,0,0,0,0,0}
            },
            {
                    {0,0,0,0,0,0},
                    {0,1,0,0,1,1},
                    {0,0,0,0,0,0},
                    {1,0,1,0,1,0}
            },
            {
                    {0,1,1,1,0,0},
                    {0,0,0,0,0,0},
                    {1,0,0,1,0,1},
                    {0,0,0,0,0,0}
            },
            {
                    {0,1,1,1,0,0},
                    {0,0,0,0,0,0},
                    {0,0,0,0,0,0},
                    {1,0,1,0,1,0}
            }
    };

    private boolean dfs(int[][] grid, int p, int d, int x, int y) {
        if( x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == -1 ) {
            return false;
        }
        if( p > 0 && d < 4 && edges[p-1][d][grid[x][y]-1] != 1) {
            return false;
        }
        if( x == m-1 && y == n-1) {
            return true;
        }
        int t = grid[x][y];
        grid[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            int nx = x + rows[i];
            int ny = y + cols[i];
            if( dfs(grid, t, i, nx, ny)) {
                grid[x][y] = t;
                return true;
            }
        }
        grid[x][y] = t;
        return false;
    }

    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        if( m == 0 ) {
            return true;
        }
        n = grid[0].length;
        return dfs(grid, -1,4, 0, 0);
    }

    public static void main(String[] args) {
        LeetCode1391 lc = new LeetCode1391();
//        int[][] grid = {{2,4,3},{6,5,2}};
//        int[][] grid = {{1,2,1},{1,2,1}};
        int[][] grid = {{1,1,1,1,1,1,3}};
        boolean ret = lc.hasValidPath(grid);
        System.out.println(ret);
    }

}
