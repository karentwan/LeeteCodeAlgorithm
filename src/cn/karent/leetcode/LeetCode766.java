package cn.karent.leetcode;

/**
 * 托普利兹矩阵
 */
public class LeetCode766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        if( m == 0) {
            return true;
        }
        int n = matrix[0].length;
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if( matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode766 lc = new LeetCode766();
//        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        int[][] matrix = {{1,2},{2,2}};
        boolean ret = lc.isToeplitzMatrix(matrix);
        System.out.println(ret);
    }

}
