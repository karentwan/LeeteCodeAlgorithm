package cn.karent.leetcode_v2;

import java.util.*;


/**
 * 规划兼职工作
 * @author wan
 * @date 2021.04.03
 */
public class LeetCode1235 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int max = 0;
        for (int i : endTime) {
            max = Math.max(i, max);
        }
        int[] dp = new int[max+1];
        int n = startTime.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (k1, k2) -> {
            return startTime[k1] == startTime[k2] ? endTime[k2] - endTime[k1] :
                    startTime[k1] - startTime[k2];
        });
        int idx = 0;
        int j = n-1;
        for (int i = max-1; i >= 0; i--) {
            dp[i] = dp[i+1];
            while ( j >= 0 && startTime[idx = indices[j]] == i ) {
                dp[i] = Math.max(profit[idx] + dp[endTime[idx]], dp[startTime[idx]]);
                j--;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
//        int[] startTime = {1,2,3,3};
//        int[] endTime = {3,4,5,6};
//        int[] profit = {50,10,40,70};
        int[] startTime = {1,2,3,4,6};
        int[] endTime = {3,5,10,6,9};
        int[] profit = {20,20,100,70,60};
        LeetCode1235 lc = new LeetCode1235();
        int ret = lc.jobScheduling(startTime, endTime, profit);
        System.out.println(ret);
    }

}
