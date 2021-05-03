package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 划分为k个相等的子集
 * @author wan
 * @date 2021.04.19
 */
public class LeetCode698 {

    private boolean dfs(int[] nums, int[] group, int row, int target) {
        // 当row < 0时, 所有的元素都已经放入桶内了
        if(row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < group.length; i++) {
            if( group[i] + v <= target) {
                group[i] += v;
                if( dfs(nums, group, row, target)) return true;
                group[i] -= v;
            }
            // 剪枝
            if( group[i] == 0) break;
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if( sum % k != 0) return false;
        int d = sum / k;
        Arrays.sort(nums);
        int row = nums.length-1;
        if( nums[row] > d) return false;
        while (row >= 0 && nums[row] == d) {
            row--;
            k--;
        }
        return dfs(nums, new int[k], row, d);
    }

    public static void main(String[] args) {
        LeetCode698 lc = new LeetCode698();
//        int[] nums = {4, 3, 2, 3, 5, 2, 1};
//        int k = 4;
        int[] nums = {10,10,10,7, 7,7,7,7, 7,6,6,6};
        int k = 3;
        boolean ret = lc.canPartitionKSubsets(nums, k);
        System.out.println(ret);
    }

}
