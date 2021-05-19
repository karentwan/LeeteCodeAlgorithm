package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 不相交的线
 * @author wan
 * @date 2021.05.19
 ********************************************/
public class LeetCode1035 {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if( nums1[i-1] == nums2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LeetCode1035 lc = new LeetCode1035();
//        int[] arr1 = {1, 4, 2};
//        int[] arr2 = {1, 2, 4};
        int[] arr1 = {2,5,1,2,5};
        int[] arr2 = {10,5,2,1,5,2};
        int ret = lc.maxUncrossedLines(arr1, arr2);
        System.out.println(ret);
    }

}
