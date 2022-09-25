package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 转变数组后最接近目标值得数组和
 * @author wan
 * @date 2022.09.25 11:46
 ******************************************/
public class LeetCode1300 {

    private long get(int[] arr, long[] preSum, int value) {
        int size = arr.length;
        int l = 0, r = size -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] >= value) {
                r = m-1;
            } else l = m+1;
        }
        return preSum[l] + (size - l) * value * 1L;
    }

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int size = arr.length;
        long[] preSum = new long[size +1];
        for (int i = 1; i <= size; i++) {
            preSum[i] = preSum[i-1] + arr[i-1];
        }
        int l = 0, r = arr[size-1];
        while ( l <= r) {
            int m = l + (r - l) / 2;
            if (get(arr, preSum, m) >= target) {
                r = m-1;
            } else l = m+1;
        }
        l = Math.min(l, arr[size-1]);
        return get(arr, preSum, l) - target < target - get(arr, preSum, r) ? l : r;
    }

    public static void main(String[] args) {
        LeetCode1300 lc = new LeetCode1300();
//        int[] arr = {4,9,3};
//        int target = 10;
//        int[] arr = {60864,25176,27249,21296,20204};
//        int target = 56803;
        int[] arr = {2,3,5};
        int target = 11;
        System.out.println(lc.findBestValue(arr, target));
    }

}
