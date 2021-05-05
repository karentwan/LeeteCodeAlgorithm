package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 优美的排列
 * @author wan
 * @date 2021.05.05
 ********************************************/
public class LeetCode667 {

    public int[] constructArray(int n, int k) {
        int[] rets = new int[n];
        int tmp = 1;
        for (int i = 0; i <= k; i+=2) {
            rets[i] = tmp++;
        }
        tmp = k+1;
        for (int i = 1; i <= k; i+=2) {
            rets[i] = tmp--;
        }
        for (int i = k+1; i < n; i++) {
            rets[i] = i+1;
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode667 lc = new LeetCode667();
        int n = 3;
        int k = 2;
        int[] rets = lc.constructArray(n, k);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
