package cn.karent.leetcode_v5.weeklycontest244;

import java.util.*;

/********************************************
 * description: 判断矩阵经轮转后是否一致
 * @author wan
 * @date 2021.06.06
 ********************************************/
public class Algo5776 {

    private void rotate(int[][] mat) {
        int n = mat.length;
        int[][] tmps = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmps[i][j] = mat[n - j - 1][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = tmps[i][j];
            }
        }
    }

    private boolean consistence(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if( mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            rotate(mat);
            if( consistence(mat, target)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Algo5776 lc = new Algo5776();
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] target = {{1,1,1},{0,1,0},{0,0,0}};
        boolean ret = lc.findRotation(mat, target);
        System.out.println(ret);
    }

}
