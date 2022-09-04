package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 *
 * @author wan
 * @date 2022.09.04 09:03
 ******************************************/
public class LeetCode1582 {

    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] += mat[i][j];
                cols[j] += mat[i][j];
            }
        }
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    ret++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1582 lc = new LeetCode1582();

    }

}
