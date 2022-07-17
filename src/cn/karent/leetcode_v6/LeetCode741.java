package cn.karent.leetcode_v6;

import java.util.Arrays;

/******************************************
 * 摘樱桃
 * @author wan
 * @date 2022.07.10 10:21
 ******************************************/
public class LeetCode741 {

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] f = new int[n*2-1][n][n];
        for (int i = 0; i < n * 2 - 1; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(f[i][j], Integer.MIN_VALUE);
            }
        }
        f[0][0][0] = grid[0][0];
        for (int k = 1; k < n*2-1; k++) {
            for (int x1 = Math.max(k-n+1, 0); x1 <= Math.min(k, n-1); x1++) {
                int y1 = k-x1;
                if (grid[x1][y1] == -1) {
                    continue;
                }
                for (int x2 = x1; x2 <= Math.min(k, n-1); x2++) {
                    int y2 = k-x2;
                    if (grid[x2][y2] == -1) {
                        continue;
                    }
                    int ret = f[k-1][x1][x2];
                    if (x1 > 0) {
                        ret = Math.max(ret, f[k-1][x1-1][x2]);
                    }
                    if (x2 > 0) {
                        ret = Math.max(ret, f[k-1][x1][x2-1]);
                    }
                    if (x1 > 0 && x2 > 0) {
                        ret = Math.max(ret, f[k-1][x1-1][x2-1]);
                    }
                    ret += grid[x1][y1];
                    if (x2 != x1) {
                        ret += grid[x2][y2];
                    }
                    f[k][x1][x2] = ret;
                }
            }
        }
        return Math.max(f[n*2-2][n-1][n-1], 0);
    }


    public static void main(String[] args) {
        LeetCode741 lc = new LeetCode741();
//        int[][] grid = {{0, 1, -1}, {1, 0, -1},{1, 1,  1}};
        int[][] grid = {{1,1,1,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,1},{1,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,1,1,1}};
        System.out.println(lc.cherryPickup(grid));
    }

}
