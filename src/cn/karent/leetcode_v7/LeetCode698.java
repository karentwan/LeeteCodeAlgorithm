package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 划分为k个相等的子集
 * @author wan
 * @date 2022.08.26 08:29
 ******************************************/
public class LeetCode698 {

    public boolean canPartitionKSubsets1(int[] nums, int k) {
        if (k == 1) return true;
        int len = nums.length;
//        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        int target = sum / k;
        if (nums[len-1] > target) {
            return false;
        }
        int size = 1 << len;
        boolean[] dp = new boolean[size];
        dp[0] = true;
        int[] currentSum = new int[size];
        for (int i = 0; i < size; i++) {
            if (!dp[i]) continue;
            for (int j = 0; j < len; j++) {
                // 从剩下的数里面挑选出
                if ( (i & (1<<j)) != 0) {
                    continue;
                }
                int next = i | (1 << j);
                if (dp[next]) {
                    continue;
                }
                if ((currentSum[i] % target) + nums[j] <= target) {
                    currentSum[next] = currentSum[i] + nums[j];
                    dp[next] = true;
                } else {
                    break;
                }
            }
        }
        return dp[size-1];
    }

    private boolean dfs(int[] nums, int idx, int[] group, int target) {
        if (idx < 0) return true;
        for (int i = 0; i < group.length; i++) {
            // 当桶内元素和相等时绝对是重复的, 不需要重复计算了
            if (i > 0 && group[i] == group[i-1]) continue;
            if (group[i] + nums[idx] <= target) {
                group[i] += nums[idx];
                if (dfs(nums, idx-1, group, target)) {
                    group[i] -= nums[idx];
                    return true;
                }
                group[i] -= nums[idx];
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) return true;
        int len = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        int target = sum / k;
        if (nums[len-1] > target) {
            return false;
        }
        int[] group = new int[k];
        return dfs(nums, nums.length-1, group, target);
    }

    public static void main(String[] args) {
        LeetCode698 lc = new LeetCode698();
//        int[] arr = {4,3,2,3,5,2,1};
//        int[] arr = {3,1,2,4};
//        int k = 2;
        int[] arr = {5309,7138,779,8949,8568,2250,1794,6539,4948,7189,4270,9866,5867,2112,9176,3162};
        int k = 2;
        System.out.println(lc.canPartitionKSubsets(arr, k));
    }

}
