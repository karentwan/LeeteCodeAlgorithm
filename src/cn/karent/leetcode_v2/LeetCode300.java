package cn.karent.leetcode_v2;

import java.util.*;
import cn.karent.util.*;


/**
 * 最长递增子序列
 * @author wan
 * @date 2021.04.05
 */
public class LeetCode300 {

    private int binarySearch(int[] arr, int left, int right, int key) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if( arr[mid] >= key) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            int idx = binarySearch(dp, 0, ret, nums[i]);
            dp[idx] = nums[i];
            if( idx == ret) {
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        LeetCode300 lc = new LeetCode300();
        int ret = lc.lengthOfLIS(nums);
        System.out.println(ret);
    }

}
