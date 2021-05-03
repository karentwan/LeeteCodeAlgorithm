package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 删除与获得点数
 * @author wan
 * @date 2021.04.17
 */
public class LeetCode740 {

    public int deleteAndEarn(int[] nums) {
        int[] all = new int[10001];
        for (int num : nums) {
            all[num]++;
        }
        int[] dp = new int[10001];
        for (int i = 1; i < 10001; i++) {
            if( i == 1) dp[i] = Math.max(dp[0], all[i]);
            else dp[i] = Math.max(dp[i-1], dp[i-2] + all[i] * i);
        }
        return dp[10000];
    }

    public static void main(String[] args) {
        LeetCode740 lc = new LeetCode740();
//        int[] nums = {3, 4, 2};
        int[] nums = {2, 2, 3, 3, 3, 4};
        int ret = lc.deleteAndEarn(nums);
        System.out.println(ret);
    }

}
