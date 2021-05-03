package cn.karent.leetcode;

/**
 * 翻转图像
 */
public class LeetCode832 {

    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        if( m == 0) {
            return A;
        }
        int n = A[0].length;
        flip(A, m, n);
        return A;
    }

    private void flip(int[][] a, int m, int n) {
        int i = 0;
        while( i < m) {
            int j = 0, k = n-1;
            while( j <= k) {
                int t = a[i][j];
                a[i][j] = 1 - a[i][k];
                a[i][k] = 1 - t;
                j++;
                k--;
            }
            i++;
        }
    }

}
