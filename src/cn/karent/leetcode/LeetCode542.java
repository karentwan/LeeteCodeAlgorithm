package cn.karent.leetcode;

import java.util.*;

/**
 * 01矩阵
 * BFS 多源BFS
 */
public class LeetCode542 {


    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if( m == 0) {
            return new int[0][0];
        }
        int n = matrix[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( matrix[i][j] == 0) {
                    que.offer(new int[]{i, j});
                    matrix[i][j] = -1;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while( !que.isEmpty()) {
            int[] tmp = que.poll();
            for(int[] dir : dirs) {
                int nx = tmp[0] + dir[0];
                int ny = tmp[1] + dir[1];
                if( nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] != -1) {
                    dist[nx][ny] = dist[tmp[0]][tmp[1]] + 1;
                    que.offer(new int[]{nx, ny});
                    matrix[nx][ny] = -1;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        LeetCode542 lc = new LeetCode542();
//        int[][] matrix = {{0,0,0}, {0,1,0}, {0,0,0}};
//        int[][] matrix = {{0,0,0}, {0,1,0}, {1,1,1}};
//        int[][] matrix = {{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}};
        int[][] matrix = {{1,0,1,1,0,0,1,0,0,1},{0,1,1,0,1,0,1,0,1,1},{0,0,1,0,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,1},{0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},{0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,1,1,1,0,1},{1,1,1,1,1,1,1,0,1,0},{1,1,1,1,0,1,0,0,1,1}};
        int[][] rets = lc.updateMatrix(matrix);
        for(int i = 0; i < rets.length; i++) {
            for(int j = 0; j < rets[0].length; j++) {
                System.out.print(rets[i][j] + " ");
            }
            System.out.println();
        }
    }
}
