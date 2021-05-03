package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 重排排列后的最大矩阵
 * @author wan
 * @date 2021.04.03
 */
public class LeetCode1727 {

    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        if( m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int ret = 0;
        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == 1 ? heights[j] + 1 : 0;
            }
            int[] tmps = Arrays.copyOf(heights, n);
            Arrays.sort(tmps);
            int tmp = 0;
            for (int j = n-2; j >= -1; j--) {
                int w = n - j - 1;
                int h = tmps[j+1];
                tmp = Math.max(tmp, w * h);
            }
            ret = Math.max(ret, tmp);
        }
        return ret;
    }

    public static void main(String[] args) {
//        int[][] matrix =  {{0,0,1},{1,1,1},{1,0,1}};
        int[][] matrix = {{1,0,1,0,1}};
        LeetCode1727 lc = new LeetCode1727();
        int ret = lc.largestSubmatrix(matrix);
        System.out.println(ret);
    }

}
