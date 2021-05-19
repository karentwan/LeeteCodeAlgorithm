package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 最佳观光组合
 * @author wan
 * @date 2021.05.19
 ********************************************/
public class LeetCode1014 {

    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        if( n == 0) return 0;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = values[i] + i;
            b[i] = values[i] - i;
        }
        c[n-1] = Integer.MIN_VALUE/2;
        int max = b[n-1];
        for (int i = n-2; i >= 0; i--) {
            c[i] = max;
            max = Math.max(max, b[i]);
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, a[i] + c[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1014 lc = new LeetCode1014();
//        int[] values = {8, 1, 5, 2, 6};
        int[] values = {1,2};
        int ret = lc.maxScoreSightseeingPair(values);
        System.out.println(ret);
    }

}
