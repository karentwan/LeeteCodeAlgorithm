package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 旋转盒子
 * @author wan
 * @date 2021.06.08
 ********************************************/
public class LeetCode1861 {

    private char[][] rotate(char[][] box, int m, int n) {
        char[][] rets = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rets[i][j] = box[m-j-1][i];
            }
        }
        return rets;
    }

    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        if( m == 0) return new char[0][0];
        int n = box[0].length;
        char[][] tmps = rotate(box, m, n);
        for (int i = 0; i < m; i++) {  // 每一列
            int j = n-1;
            while ( j >= 0) {
                while (j >= 0 && (tmps[j][i] == '*' || tmps[j][i] == '#')) {
                    j--;
                }
                int k = j;
                int sum = 0;
                while ( k >= 0 && tmps[k][i] != '*') {
                    if( tmps[k][i] == '#') sum++;
                    k--;
                }
                while (j > k && sum > 0) {
                    tmps[j][i] = '#';
                    j--;
                    sum--;
                }
                while (j > k) {
                    tmps[j][i] = '.';
                    j--;
                }
            }
        }
        return tmps;
    }

    public static void main(String[] args) {
        LeetCode1861 lc = new LeetCode1861();
        char[][] box = {{'#','#','*','.','*','.'},{'#','#','#','*','.','.'},{'#','#','#','.','#','.'}};
        print(box);
        char[][] rets = lc.rotateTheBox(box);
        print(rets);

    }

    private static void print(char[][] rets) {
        for (char[] ret : rets) {
            for (char c : ret) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println("==================================================");
    }


}
