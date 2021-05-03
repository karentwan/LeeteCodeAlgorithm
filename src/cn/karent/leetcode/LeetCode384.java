package cn.karent.leetcode;

import java.util.*;

/**
 * 打乱数组
 * 洗牌算法
 */
public class LeetCode384 {

    private int[] nums = null;

    public LeetCode384(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    private int nextInt(int n) {
        return (int)(Math.random() * n);
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] tmps = Arrays.copyOf(nums, nums.length);
        for(int i = tmps.length-1; i >= 0; i--) {
            int idx = nextInt(i+1);
            swap(tmps, idx, i);
        }
        return tmps;
    }
}
