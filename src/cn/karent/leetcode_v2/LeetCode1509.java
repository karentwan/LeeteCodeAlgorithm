package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 三次操作后最大值与最小值的最小差
 */
public class LeetCode1509 {

    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        if( nums.length < 5) {
            return 0;
        }
        int lastIdx = nums.length-1;
        int ret = Integer.MAX_VALUE;
        for (int i = 3; i >= 0; i--) {
            ret = Math.min(ret, nums[lastIdx--] - nums[i]);
        }
        return ret;
    }

}
