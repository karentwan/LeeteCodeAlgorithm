package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 翻转对
 * @author wan
 * @date 2021.04.20
 */
public class LeetCode493 {

    private int count(int[] nums, int l1, int r1, int l2, int r2) {
        int i = l1, j = l2;
        int cnt = 0;
        while (i <= r1 ) {
            while ( j <= r2 && nums[i] > 2L * nums[j]) j++;
            cnt += j - l2;
            i++;
        }
        return cnt;
    }

    private int merge(int[] nums, int left, int right, int[] tmps) {
        if( left >= right) return 0;
        int m = left + ( right - left)/2;
        int s1 = merge(nums, left, m, tmps);
        int s2 = merge(nums, m+1, right, tmps);
        int ret = count(nums, left, m, m+1, right) + s1 + s2;
        int i = left, j = m+1, k = left;
        while (i <= m && j <= right) {
            if( nums[i] <= nums[j]) tmps[k] = nums[i++];
            else tmps[k] = nums[j++];
            k++;
        }
        while (i <= m) tmps[k++] = nums[i++];
        while (j <= right) tmps[k++] = nums[j++];
        i = left;
        for (; i <= right; i++) nums[i] = tmps[i];
        return ret;
    }

    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] tmps = new int[n];
        return merge(nums, 0, n-1, tmps);
    }

    public static void main(String[] args) {
        LeetCode493 lc = new LeetCode493();
//        int[] nums = {1,3,2,3,1};
        int[] nums = {2,4,3,5,1};
        int ret = lc.reversePairs(nums);
        System.out.println(ret);
    }

}
