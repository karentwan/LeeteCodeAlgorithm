package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 大小为k且平均值大于等于阈值的子数组数目
 * @author wan
 * @date 2021.06.03
 ********************************************/
public class LeetCode1343 {
/*
    private int gt(int[] arr, int t) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = l + (r-l)/2;
            if( arr[m] >= t) r = m;
            else l = m+1;
        }
        return l;
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int[] avg = new int[n - k + 1];
        int wnd = 0;
        for (int i = 0, j = 0; i < n; i++) {
            wnd += arr[i];
            if( i >= k - 1) {
                int t = wnd / k;
                avg[j] = t;
                wnd -= arr[j++];
            }
        }
        Arrays.sort(avg);
        int idx = gt(avg, threshold);
        int m = avg.length;
        return m - idx;
    }
   */

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int wnd = 0;
        int ret = 0;
        int avg = 0;
        for (int i = 0, j = 0; i < n; i++) {
            wnd += arr[i];
            if( i >= k - 1) {
                avg = wnd / k;
                if( avg >= threshold) ret++;
                wnd -= arr[j++];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1343 lc = new LeetCode1343();
        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int th = 7;
        int ret = lc.numOfSubarrays(arr, k, th);
        System.out.println(ret);
    }

}
