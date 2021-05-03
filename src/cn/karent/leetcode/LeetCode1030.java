package cn.karent.leetcode;

import java.util.*;

/**
 * 距离顺序排列矩阵单元格
 */
public class LeetCode1030 {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] rets = new int[R*C][2];
        int k = 0;
        for(int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                rets[k][0] = i;
                rets[k][1] = j;
                k++;
            }
        }
        Arrays.sort(rets, (int[] k1, int[] k2) -> {
            int t1 = Math.abs(k1[0] - r0) + Math.abs(k1[1] - c0);
            int t2 = Math.abs(k2[0] - r0) + Math.abs(k2[1] - c0);
            return t1 - t2;
        });
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1030 lc = new LeetCode1030();
//        int R = 2;
//        int C = 2;
//        int r0 = 0;
//        int c0 = 1;
        int R = 2;
        int C = 3;
        int r0 = 1;
        int c0 = 2;
        int[][] rets = lc.allCellsDistOrder(R, C, r0, c0);
        for (int[] ret : rets) {
            System.out.println("(" + ret[0] + "," + ret[1] + ")");
        }
    }

}
