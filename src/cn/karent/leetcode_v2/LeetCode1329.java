package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 将矩阵按对角线排序
 */
public class LeetCode1329 {

    private void process(int[][] mat, int startx, int starty, int m, int n) {
        List<Integer> tmp = new ArrayList<>();
        int x = startx;
        int y = starty;
        while ( x < m && y < n) {
            tmp.add(mat[x][y]);
            x++;
            y++;
        }
        Collections.sort(tmp);
        x = startx;
        y = starty;
        int k = 0;
        while ( x < m && y < n) {
            mat[x][y] = tmp.get(k++);
            x++;
            y++;
        }
    }

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        if( m == 0) {
            return mat;
        }
        int n = mat[0].length;
        for (int i = 0; i < n; i++) {
            process(mat, 0, i, m, n);
        }
        for (int i = 1; i < m; i++) {
            process(mat, i, 0, m, n);
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        LeetCode1329 lc = new LeetCode1329();
        print(mat);
        int[][] rets = lc.diagonalSort(mat);
        print(rets);
    }

    private static void print(int[][] rets) {
        for (int[] ret : rets) {
            System.out.print("[");
            for (int i : ret) {
                System.out.print(i + ",");
            }
            System.out.print("]");
        }
        System.out.println();
    }

}
