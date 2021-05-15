package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 环形子数组的最大和
 * @author wan
 * @date 2021.05.14
 ********************************************/
public class LeetCode918 {

    public int maxSubarraySumCircular(int[] nums) {
        if( nums.length == 0) return 0;
        int dp = Integer.MIN_VALUE/2;
        int dp1 = Integer.MAX_VALUE/2;
        int min = Integer.MAX_VALUE/2;
        int sum = 0;
        int max = Integer.MIN_VALUE/2;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(max, dp);
        }
        for (int i = 1; i < nums.length-1; i++) {
            dp1 = Math.min(dp1 + nums[i], nums[i]);
            min = Math.min(min, dp1);
        }
        return Math.max(max, sum - min);
    }

    public static void main(String[] args) {
        LeetCode918 lc = new LeetCode918();
//        int[] arr = {1, -2, 3, -2};
//        int[] arr = {5,-3,5};
//        int[] arr = {3,-2,2,-3};
        int[] arr = {-2,-3,-1};
        int ret = lc.maxSubarraySumCircular(arr);
        System.out.println(ret);
    }

}
