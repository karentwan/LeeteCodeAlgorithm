package cn.karent.leetcode_v1.weeklycontest305;

import java.util.*;

/******************************************
 * 检查数组是否存在有效划分
 * @author wan
 * @date 2022.08.07 10:50
 ******************************************/
public class LeetCode6137 {

    public boolean validPartition(int[] nums) {
        // dp(i) 表示前i个元素是否满足有效划分
        boolean[] dp = new boolean[nums.length+1];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                dp[i+1] = nums[i] == nums[i-1];
            } else {
                dp[i+1] = (dp[i-1] && nums[i] == nums[i-1])
                || (dp[i-2] && ((nums[i] == nums[i-1] && nums[i] == nums[i-2])
                        || (nums[i] == nums[i-1]+1 && nums[i-1] == nums[i-2]+1)));
            }
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        LeetCode6137 lc = new LeetCode6137();
//        int[] nums = {4,4,4,5,6};
        int[] nums = {1,1,1,2};
        System.out.println(lc.validPartition(nums));
    }

}
