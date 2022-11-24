package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 分汤
 * @author wan
 * @date 2022.11.24 16:38
 ******************************************/
public class LeetCode808 {

    public double soupServings(int n) {
        n = (int) Math.min(200, Math.ceil(n / 25.0));
        double[][] f = new double[n+10][n+10];
        f[0][0] = 0.5;
        for (int i = 0; i <= n; i++) {
            f[0][i] = 1;
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                double a = f[Math.max(i - 4, 0)][j], b = f[Math.max(i - 3, 0)][Math.max(j - 1, 0)];
                double c = f[Math.max(i - 2, 0)][Math.max(j - 2, 0)], d = f[Math.max(i - 1, 0)][Math.max(j - 3, 0)];
                f[i][j] = 0.25 * (a + b + c + d);
            }
        }
        return f[n][n];
    }

    public static void main(String[] args) {
        LeetCode808 lc = new LeetCode808();
    }

}
