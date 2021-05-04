package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 图片平滑器
 * @author wan
 * @date 2021.05.04
 ********************************************/
public class LeetCode661 {

    private int getNeighbor(int[][] img, int x, int y, int m, int n) {
        int ret = 0;
        int cnt = 0;
        // 下一行
        for (int i = y+1, rown = 3; rown > 0 && x + 1 < m && i >= 0; i--, rown--) {
            if( i >= n ) continue;
            ret += img[x+1][i];
            cnt++;
        }
        // 第二行
        for (int i = y+1, rown = 3; rown > 0 && i >= 0 ; i--, rown--) {
            if( i >= n ) continue;
            ret += img[x][i];
            cnt++;
        }
        // 第一行
        for (int i = y+1, rown = 3; rown > 0 && x - 1 >= 0 && i >= 0 ; i--, rown--) {
            if( i >= n ) continue;
            ret += img[x-1][i];
            cnt++;
        }
        return ret / cnt;
    }


    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        if( m == 0) return img;
        int n = img[0].length;
        int[][] tmps = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmps[i][j] = getNeighbor(img, i, j, m, n);
            }
        }
        return tmps;
    }

    public static void main(String[] args) {
        LeetCode661 lc = new LeetCode661();
        int[][] img = {{1,1,1}, {1,0,1}, {1,1,1}};
        int[][] rets = lc.imageSmoother(img);
        for (int[] ret : rets) {
            for (int item : ret) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

}
