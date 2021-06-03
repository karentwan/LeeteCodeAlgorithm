package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 转变数组后最接近目标值的数组和
 * @author wan
 * @date 2021.06.02
 ********************************************/
public class LeetCode1300 {

    private int gt(int[] arr, int target) {  // 大于等于
        int l = 0, r = arr.length;
        while (l < r) {
            int m = l + ( r - l)/2;
            if( arr[m] >= target) r = m;
            else l = m+1;
        }
        return l;
    }

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        if( n == 0) return 0;
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + arr[i-1];
        }
        int ret = 0, diff = target;
        int iterMax = arr[n-1];
        for (int i = 1; i <= iterMax; i++) {
            int idx = gt(arr, i);
            int t = sum[idx] + (n - idx) * i;
            int v = Math.abs(t - target);
            if( v < diff) {
                ret = i;
                diff = v;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        LeetCode1300 lc = new LeetCode1300();
        int[] arr = {4, 9, 3};
        int target = 10;
//        int[] arr = {2,3,5};
//        int target = 10;
//        int[] arr = {60864,25176,27249,21296,20204};
//        int target = 56803;
//        int[] arr = {2, 3, 5};
//        int target = 11;
        int ret = lc.findBestValue(arr, target);
        System.out.println(ret);
    }

}
