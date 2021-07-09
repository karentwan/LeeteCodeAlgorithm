package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 戳气球, 动态规划实际上就是将问题划分为子问题
 *              至于如何求解, 可以先不用考虑, 先列方程式, 最后
 *              总归能求解的
 * @author wan
 * @date 2021.07.09
 ***********************************************/
public class LeetCode312 {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = arr[n+1] = 1;
        int[][] dp = new int[n+2][n+2];
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i-1];
        }
        for (int i = n; i >= 0; i--) {
            for (int j = i+2; j <= n+1; j++) {
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], arr[i] * arr[k] * arr[j] +
                                dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n+1];
    }

    public static void main(String[] args) {
        LeetCode312 lc = new LeetCode312();
//        int[] arr = {3,1,5,8};
        int[] arr = {1,5};
        int ret = lc.maxCoins(arr);
        System.out.println(ret);
    }

}
