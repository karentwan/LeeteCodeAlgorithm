package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 最大加号标志
 * @author wan
 * @date 2021.04.20
 */
public class LeetCode764 {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] matrix = new int[N][N];
        for (int[] mine : mines) {
            matrix[mine[0]][mine[1]] = 1;
        }
        int ret = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int t = 0;
                int len = Math.min(Math.min(i , j), Math.min(N-i-1, N-j-1));
                for (int k = 0; k <= len ; k++) {
                    int up = matrix[i-k][j];
                    int down = matrix[i+k][j];
                    int left = matrix[i][j-k];
                    int right = matrix[i][j+k];
                    if( up == 1 || down == 1 || left == 1 || right == 1) break;
                    t++;
                }
                ret = Math.max(ret, t);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode764 lc = new LeetCode764();
//        int N = 5;
//        int[][] mines = {{4,2}};
//        int N = 2;
//        int[][] mines = {};
        int N = 1;
        int[][] mines = {{0,0}};
        int ret = lc.orderOfLargestPlusSign(N, mines);
        System.out.println(ret);
    }

}
