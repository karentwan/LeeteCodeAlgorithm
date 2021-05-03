package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 采购方案
 * @author wan
 * @date 2021.04.05
 */
public class LCP28 {

    private int binarySearch(int[] nums, int left, int right, long target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if( nums[mid] > target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        long ret = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            int idx = binarySearch(nums, 0, i,target-nums[i]);
            ret += idx;
        }
        return ((int) (ret % (1e9 + 7)));
    }

    public static void main(String[] args) {
        int[] nums = {2,5,3,5};
        int target = 6;
//        int[] nums = {2,2,1,9};
//        int target = 10;
        LCP28 lcp = new LCP28();
        int ret = lcp.purchasePlans(nums, target);
        System.out.println(ret);
    }

}
