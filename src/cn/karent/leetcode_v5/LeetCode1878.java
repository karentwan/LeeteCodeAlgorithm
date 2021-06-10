package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 矩阵中最大的三个菱形和
 * @author wan
 * @date 2021.06.10
 ********************************************/
public class LeetCode1878 {

    class Answer {
        int[] data = new int[3];

        void add(int x) {
            if( x > data[0]) {
                data[2] = data[1];
                data[1] = data[0];
                data[0] = x;
            }
            else if( x != data[0] && x > data[1]) {
                data[2] = data[1];
                data[1] = x;
            }
            else if( x != data[0] && x != data[1] && x > data[2]) data[2] = x;
        }

        int[] get() {
            List<Integer> tmps = new ArrayList<>();
            for (int datum : data) {
                if( datum != 0) tmps.add(datum);
            }
            int[] rets = new int[tmps.size()];
            for (int i = 0; i < rets.length; i++) {
                rets[i] = tmps.get(i);
            }
            return rets;
        }

    }

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        if( m == 0) return new int[0];
        int n = grid[0].length;
        int[][] sum1 = new int[m+2][n+2];
        int[][] sum2 = new int[m+2][n+2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum1[i][j] = sum1[i-1][j-1] + grid[i-1][j-1];
                sum2[i][j] = sum2[i-1][j+1] + grid[i-1][j-1];
            }
        }
        Answer answer = new Answer();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int ux = i, uy = j;
                answer.add(grid[i][j]);
                for (int k = 1; k < m; k++) {
                    int lx = ux+k, ly = uy-k;
                    int rx = ux+k, ry = uy+k;
                    int dx = ux+2*k, dy = uy;
                    if( ly < 0 || lx >= m || rx >= m || ry >= n || dx >= m) break;
                    int v =   sum1[rx+1][ry+1] - sum1[ux][uy]
                            + sum1[dx+1][dy+1] - sum1[lx][ly]
                            + sum2[lx+1][ly+1] - sum2[ux][uy+2]
                            + sum2[dx+1][dy+1] - sum2[rx][ry+2]
                            - grid[ux][uy] - grid[rx][ry] - grid[dx][dy] - grid[lx][ly];
                    System.out.println("v :" + v);
                    answer.add(v);
                }
            }
        }
        return answer.get();
    }

    public static void main(String[] args) {
        LeetCode1878 lc = new LeetCode1878();
        int[][] grid = {{3,4,5,1,3},{3,3,4,2,3},{20,30,200,40,10},{1,5,5,4,1},{4,3,2,2,5}};
        int[] rets = lc.getBiggestThree(grid);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
