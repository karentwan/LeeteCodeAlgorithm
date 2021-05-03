package cn.karent.leetcode_v3;

import java.util.*;

/********************************************
 * description: 最大整除子集
 * @author wan
 * @date 2021.04.23
 ********************************************/
public class LeetCode368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 整除具有传递性, 当 a|b , b|c, 则a|c
        int[] dp = new int[nums.length];
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        int[] father = new int[nums.length];
        Arrays.fill(father, -1);
        int max = 0;
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if( nums[i] % nums[j] == 0 && dp[j]+1 > dp[i]) {
                    dp[i] = dp[j]+1;
                    father[i] = j;
                }
            }
            if( dp[i] > max) {
                max = dp[i];
                idx = i;
            }
        }
        List<Integer> ret = new ArrayList<>();
        while (idx != -1) {
            ret.add(nums[idx]);
            idx = father[idx];
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode368 lc = new LeetCode368();
//        int[] nums = {1,2,3};
//        int[] nums = {4,8,10,240};
//        int[] nums = {1,2,4,8};
        int[] nums = {1};
        List<Integer> ret = lc.largestDivisibleSubset(nums);
        System.out.println(ret);
    }

}
