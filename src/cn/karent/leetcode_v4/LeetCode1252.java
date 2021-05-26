package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 奇数值单元格的数目
 * @author wan
 * @date 2021.05.26
 ********************************************/
public class LeetCode1252 {

    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        for (int[] idx : indices) {
            int r = idx[0];
            int c = idx[1];
            for (int i = 0; i < n; i++) {
                matrix[r][i]++;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][c]++;
            }
        }
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if( matrix[i][j] % 2 != 0) ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

    }

}
