package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 分隔数组以得到最大和
 * @author wan
 * @date 2021.06.23
 ***********************************************/
public class LeetCode1043 {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int max = arr[i-1];
            for (int j = i-1; j >= 0 && i - j <= k; j--) {
                max = Math.max(arr[j], max);
                dp[i] = Math.max(dp[i], dp[j] + (i-j) * max);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode1043 lc = new LeetCode1043();
//        int[] arr = {1, 15, 7, 9, 2, 5, 10};
//        int k = 3;
        int[] arr = {1,4,1,5,7,3,6,1,9,9,3};
        int k = 4;
        int ret = lc.maxSumAfterPartitioning(arr, k);
        System.out.println(ret);
    }

}
