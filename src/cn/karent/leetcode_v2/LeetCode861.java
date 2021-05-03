package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 翻转矩阵后的得分
 * @author wan
 * @date 2021.04.09
 */
public class LeetCode861 {

    public int matrixScore(int[][] A) {
        int m = A.length;
        if( m == 0) return m;
        int n = A[0].length;
        int ret = m * (1 << (n-1));
        for (int i = 1; i < n; i++) {
            int nOnes = 0;
            for (int j = 0; j < m; j++) {
                if( A[j][0] == 1) {
                    nOnes += A[j][i];
                } else {
                    nOnes += (1 - A[j][i]);
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ret += k * ( 1 << (n - i - 1));
        }
        return ret;
    }

    public static void main(String[] args) {

    }

}
