package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 删除并获得点数(不能获得相邻数字之间的点数)
 * @author wan
 * @date 2021.05.05
 ********************************************/
public class LeetCode740 {

    public int deleteAndEarn(int[] nums) {
        int[] tmps = new int[20001];
        for (int num : nums) {
            tmps[num]++;
        }
        int[] dp = new int[2];
        dp[1] = tmps[1];
        for (int i = 2; i < 20001; i++) {
            int t = Math.max(dp[0] + i * tmps[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = t;
        }
        return dp[1];
    }

    public static void main(String[] args) {
        LeetCode740 lc = new LeetCode740();
//        int[] nums = {3,4,2};
        int[] nums = {2,2,3,3,3,4};
        int ret = lc.deleteAndEarn(nums);
        System.out.println(ret);
    }

}
