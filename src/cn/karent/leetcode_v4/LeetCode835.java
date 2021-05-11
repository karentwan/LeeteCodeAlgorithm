package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 图像重叠
 * @author wan
 * @date 2021.05.11
 ********************************************/
public class LeetCode835 {

    private int conv(int[][] img1, int[][] img2, int r, int c, int m, int n, int m1, int n1) {
        int ret = 0;
        for (int i = 0, i1 = r; i1 < m1 && i < m; i++, i1++) {
            for (int j = 0, j1 = c; j1 < n1 && j < n; j++, j1++) {
                ret += img1[i][j] * img2[i1][j1];
            }
        }
        return ret;
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        int m = img1.length;
        if( m == 0) return 0;
        int n = img1[0].length;
        int[][] tmps = new int[2 * m][2 * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmps[i + m][j+m] = img2[i][j];
            }
        }
        int ret = 0;
        for (int i = 0; i < 2 * m; i++) {
            for (int j = 0; j < 2 * n; j++) {
                ret = Math.max(ret, conv(img1, tmps, i, j, m, n, 2 * m, 2 * n));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode835 lc = new LeetCode835();
        int[][] A = {{1,1,0},{0,1,0},{0,1,0}};
        int[][] B = {{0,0,0},{0,1,1},{0,0,1}};
//        int[][] A = {{0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
//        int[][] B = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{1,0,0,0,0}};
        int ret = lc.largestOverlap(A, B);
        System.out.println(ret);
    }

}
