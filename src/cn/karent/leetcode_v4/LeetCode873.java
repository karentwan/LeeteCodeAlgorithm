package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 最长的斐波那契子序列的长度
 * @author wan
 * @date 2021.05.12
 ********************************************/
public class LeetCode873 {

    public int lenLongestFibSubseq(int[] arr) {
        if( arr.length < 3) return 0;
        int[][] dp = new int[arr.length][arr.length];
        int ret = 0;
        for (int i = 2; i < arr.length; i++) {
            for (int j = i-1; j >= 1; j--) {
                // 暴力查找直接超时, 可以考虑二分优化
//                for (int k = j-1; k >= 0; k--) {
//                    if( arr[j] + arr[k] == arr[i]) {
//                        if( dp[j][k] == 0) {
//                            dp[i][j] = Math.max(dp[i][j], dp[j][k] + 3);
//                        } else {
//                            dp[i][j] = Math.max(dp[i][j], dp[j][k] + 1);
//                        }
//                    }
//                }
                // 换成二分优化查找
                int l = 0, r = j-1;
                int t = arr[i] - arr[j];
                while (l < r) {
                    int m = l + (r - l)/2;
                    if( arr[m] >= t) r = m;
                    else l = m+1;
                }
                if( arr[l] == t) {
                    if( dp[j][l] == 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[j][l] + 3);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], dp[j][l] + 1);
                    }
                }
                ret = Math.max(ret, dp[i][j]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode873 lc = new LeetCode873();
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
//        int[] arr = {1,3,7,11,12,14,18};
        int[] arr = {2,4,5,6,7,8,11,13,14,15,21,22,34};
        int ret = lc.lenLongestFibSubseq(arr);
        System.out.println(ret);
    }

}
