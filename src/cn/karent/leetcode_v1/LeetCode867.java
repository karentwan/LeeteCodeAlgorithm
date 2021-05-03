package cn.karent.leetcode_v1;

/**
 * 转置矩阵
 */
public class LeetCode867 {

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        if( m == 0) {
            return new int[0][0];
        }
        int n = matrix[0].length;
        int[][] ret = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret[j][i] = matrix[i][j];
            }
        }
        return ret;
    }

}
