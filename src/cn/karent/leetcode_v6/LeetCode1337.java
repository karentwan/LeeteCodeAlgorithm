package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 矩阵中战斗力最弱的k行
 * @author wan
 * @date 2021.08.01
 ***********************************************/
public class LeetCode1337 {

    public int[] kWeakestRows1(int[][] mat, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((k1, k2)->{
            return k1[0] == k2[0] ? k1[1] - k2[1] : k1[0] - k2[0];
        });
        int m = mat.length;
        if( m == 0) return new int[0];
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            int val = 0;
            for (int j = 0; j < n; j++) {
                val += mat[i][j];
            }
            que.offer(new int[]{val, i});
        }
        int[] rets = new int[k];
        for (int i = 0; i < k && !que.isEmpty(); i++) {
            rets[i] = que.poll()[1];
        }
        return rets;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((k1, k2)->{
            return k1[0] == k2[0] ? k1[1] - k2[1] : k1[0] - k2[0];
        });
        int m = mat.length;
        if( m == 0) return new int[0];
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            int l = 0, r = n-1;
            while (l <= r) {
                int mid = l + (r - l)/2;
                if( mat[i][mid] == 1) l = mid+1;
                else r = mid-1;
            }
            que.offer(new int[]{l, i});
        }
        int[] rets = new int[k];
        for (int i = 0; i < k && !que.isEmpty(); i++) {
            rets[i] = que.poll()[1];
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1337 lc = new LeetCode1337();
        int[][] mat = {{0,0,0,0,0}, {1,1,1,1,0}, {1,0,0,0,0}, {1,1,0,0,0}, {1,1,1,1,1}};
        int k = 3;
        int[] rets = lc.kWeakestRows(mat, k);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
