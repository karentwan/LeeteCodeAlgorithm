package cn.karent.leetcode_v1;

/**
 * 二维区域和检索 - 矩阵不可变
 * 二维矩阵 前缀和
 */
public class NumMatrix {

    private int[][] preSum = null;

    private int m;

    private int n;

    public NumMatrix(int[][] matrix) {
        m = matrix.length + 1;
        if( m == 1) {
            return;
        }
        n = matrix[0].length + 1;
        preSum = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i-1][j-1] - preSum[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ret = preSum[row2+1][col2+1] - preSum[row1][col2+1] - preSum[row2+1][col1] +
                preSum[row1][col1];
        return ret;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
        NumMatrix nm = new NumMatrix(matrix);
        int ret = nm.sumRegion(2, 1, 4, 3);
        System.out.println(ret);
        ret = nm.sumRegion(1,1,2,2);
        System.out.println(ret);
        ret = nm.sumRegion(1,2,2,4);
        System.out.println(ret);

    }
}
