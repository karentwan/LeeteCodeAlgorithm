package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 下一个排列
 * @author wan
 * @date 2021.04.17
 */
public class LeetCode31 {

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length-1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while (i >= 0 && nums[i] >= nums[i+1]) i--;
        if( i >= 0) {
            int j = nums.length-1;
            while (j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        LeetCode31 lc = new LeetCode31();
//        int[] nums = {1,2,3};
        int[] nums = {3,2,1};
        lc.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
