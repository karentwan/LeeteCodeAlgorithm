package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 找出数组游戏的赢家
 * @author wan
 * @date 2021.06.05
 ********************************************/
public class LeetCode1535 {
/*
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int[] rets = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if( i == 0) max = i;
            else {
                if( arr[max] > arr[i]) {
                    rets[max]++;
                } else {
                    rets[i]++;
                    max = i;
                }
                if( rets[max] == k) return arr[max];
            }
        }
        return arr[max];
    }
   */
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int ret = 0, idx = 0;
        for (int i = 1; i < n; i++) {
            if( arr[i] > arr[idx]) {
                ret = 1;
                idx = i;
            } else ret++;
            if( ret == k) return arr[idx];
        }
        return arr[idx];
    }

    public static void main(String[] args) {
        LeetCode1535 lc = new LeetCode1535();
//        int[] arr = {2, 1, 3, 5, 4, 6, 7};
//        int k = 2;
        int[] arr = {3,2,1};
        int k = 10;
        int ret = lc.getWinner(arr, k);
        System.out.println(ret);

    }

}
