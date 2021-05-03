package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 基数排序
 * @author wan
 * @date 2021.04.10
 */
public class RadixSort {

    private void _sort(int[] nums, int e) {
        int[] bucket = new int[10];
        int[] tmps = new int[nums.length];
        for (int i = 0; i < tmps.length; i++) {
            bucket[(nums[i] / e) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            bucket[i] += bucket[i-1];
        }
        for(int i = nums.length-1; i >= 0; i--) {
            int idx = --bucket[(nums[i] / e) % 10];
            tmps[idx] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmps[i];
        }
    }

    private int getMax(int[] nums) {
        int ret = Integer.MIN_VALUE;
        for (int num : nums) {
            ret = Math.max(num, ret);
        }
        return ret;
    }

    public void sort(int[] nums) {
        int e = 1;
        int max = getMax(nums);
        while ( max / e > 0) {
            _sort(nums, e);
            e *= 10;
        }
    }

    public static void main(String[] args) {
        int[] nums = {26,3,49,556,81,9,863};
        RadixSort rs = new RadixSort();
        rs.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
