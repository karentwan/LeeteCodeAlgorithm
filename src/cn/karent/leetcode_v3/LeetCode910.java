package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 最小差值 二
 * @author wan
 * @date 2021.04.12
 */
public class LeetCode910 {

    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length-1;
        int ret = A[n] - A[0];
        for (int i = 0; i < n; i++) {
            int min = Math.min(A[0] + K, A[i+1] - K);
            int max = Math.max(A[i] + K, A[n] - K);
            ret = Math.min(ret, max - min);
        }
        return ret;
    }

    public static void main(String[] args) {

    }

}
