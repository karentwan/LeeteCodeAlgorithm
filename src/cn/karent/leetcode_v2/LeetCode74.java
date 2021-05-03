package cn.karent.leetcode_v2;

/**
 * 搜索二维矩阵
 */
public class LeetCode74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if( m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;
        while ( i < m && j >= 0) {
            if( matrix[i][j] == target) {
                return true;
            } else if( matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

}
