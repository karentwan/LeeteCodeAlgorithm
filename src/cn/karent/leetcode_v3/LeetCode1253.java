package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 重构2行二进制矩阵
 * @author wan
 * @date 2021.04.16
 */
public class LeetCode1253 {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int[][] tmps = new int[2][colsum.length];
        List<List<Integer>> rets = new ArrayList<>();
        for (int i = 0; i < colsum.length; i++) {
            switch( colsum[i] ) {
                case 1:
                    if( upper == 0 && lower == 0) return rets;
                    if( upper > lower) {
                        tmps[0][i] = 1;
                        upper--;
                    }
                    else {
                        tmps[1][i] = 1;
                        lower--;
                    }
                    break;
                case 2:
                    if( upper == 0 || lower == 0) return rets;
                    tmps[0][i] = 1;
                    tmps[1][i] = 1;
                    upper--;
                    lower--;
                    break;
            }
        }
        if( upper > 0 || lower > 0) return rets;
        for (int i = 0; i < 2; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < colsum.length; j++) {
                list.add(tmps[i][j]);
            }
            rets.add(list);
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1253 lc = new LeetCode1253();
//        int upper = 2;
//        int lower = 1;
//        int[] colsum = {1,1,1};
//        int upper = 2;
//        int lower = 3;
//        int[] colsum = {2,2,1,1};
        int upper = 5;
        int lower = 5;
        int[] colsum = {2,1,2,0, 1,0,1,2,0,1};
//        int upper = 4;
//        int lower = 7;
//        int[] colsum = {2,1,2,2, 1,1,1};
        List<List<Integer>> rets = lc.reconstructMatrix(upper, lower, colsum);
        System.out.println(rets);
    }

}
