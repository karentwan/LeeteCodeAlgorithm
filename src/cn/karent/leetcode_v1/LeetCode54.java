package cn.karent.leetcode_v1;

import java.util.*;

/**
 * 螺旋矩阵
 */
public class LeetCode54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        List<Integer> rets = new ArrayList<>();
        if( m == 0) {
            return rets;
        }
        int n = matrix[0].length;
        int startx = 0,  starty = 0;
        m--;
        n--;
        while (startx <= m && starty <= n) {
            int i = startx++;
            int j = starty;
            while( j <= n) {
                rets.add(matrix[i][j++]);
            }
            i = startx;
            j = n;
            while( starty <= n && i <= m) {
                rets.add(matrix[i++][j]);
            }
            n--;
            i = m;
            j = n;
            while( startx <= m && j >= starty) {
                rets.add(matrix[i][j--]);
            }
            m--;
            i = m;
            j = starty;
            while (starty <= n && i >= startx) {
                rets.add(matrix[i--][j]);
            }
            starty++;
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode54 lc = new LeetCode54();
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = {{3},{2}};
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> rets = lc.spiralOrder(matrix);
        System.out.println(rets);
    }

}
