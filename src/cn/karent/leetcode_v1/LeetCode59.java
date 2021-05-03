package cn.karent.leetcode_v1;

/**
 * 螺旋矩阵 二
 */
public class LeetCode59 {

    public int[][] generateMatrix(int n) {
        int[][] rets = new int[n][n];
        int startx = 0, starty = 0;
        int m = n;
        m--;
        n--;
        int cnt = 1;
        while (startx <= m && starty <= n) {
            int i = startx++;
            int j = starty;
            while( j <= n) {
                rets[i][j++] = cnt++;
            }
            i = startx;
            j = n--;
            while( i <= m) {
                rets[i++][j] = cnt++;
            }
            j = n;
            i = m--;
            while( j >= starty) {
                rets[i][j--] = cnt++;
            }
            i = m;
            j = starty++;
            while( i >= startx) {
                rets[i--][j] = cnt++;
            }

        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode59 lc = new LeetCode59();
        int n = 1;
        int[][] rets = lc.generateMatrix(n);
        for (int[] ret : rets) {
            for (int r : ret) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }

}
