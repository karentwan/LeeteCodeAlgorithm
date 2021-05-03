package cn.karent.leetcode;

import java.util.*;

/**
 * 连续差相同的数字
 */
public class LeetCode967 {

    private void dfs(int idx, int n, int k, int ret, int last, List<Integer> rets) {
        if( n == 0) {
            return;
        }
        if( idx >= n) {
            rets.add(ret);
            return;
        }
        if( idx == 0) {
            for (int i = 1; i <= 9; i++) {
                dfs(1, n, k, i, i, rets);
            }
        } else {
            if( last - k > 0) {
                dfs(idx+1, n, k, ret * 10 + last - k, last - k, rets);
            }
            if( k + last != last - k && k + last < 10) {
                dfs(idx+1, n, k, ret * 10 + k + last, last + k, rets);
            }
            if( k - last == 0) {
                dfs(idx+1, n, k, ret * 10, 0, rets);
            }
        }
    }

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(0, n, k, 0, 0, list);
        int[] rets = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rets[i] = list.get(i);
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode967 lc = new LeetCode967();
//        int n = 3;
//        int k = 7;
//        int n = 2;
//        int k = 1;
        int n = 2;
        int k = 0;
        int[] rets = lc.numsSameConsecDiff(n, k);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
