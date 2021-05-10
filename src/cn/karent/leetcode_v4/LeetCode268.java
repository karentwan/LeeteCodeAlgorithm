package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 丢失的数字
 * @author wan
 * @date 2021.05.10
 ********************************************/
public class LeetCode268 {
/*
    public int missingNumber(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            while (nums[i] < n && nums[nums[i]] != nums[i]) {
                int t = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = t;
            }
            i++;
        }
        for (int j = 0; j < n; j++) {
            if( nums[j] != j) return j;
        }
        return n;
    }
    */

    public int missingNumber(int[] nums) {
        int t = nums.length;
        for (int i = 0; i < nums.length; i++) {
            t ^= nums[i];
            t ^= i;
        }
        return t;
    }

    public static void main(String[] args) {
        LeetCode268 lc = new LeetCode268();
        int[] nums = {3, 0, 1};
        int ret = lc.missingNumber(nums);
        System.out.println(ret);
    }

}
