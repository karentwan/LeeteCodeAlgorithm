package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 寻找两个正序数组的中位数
 * @author wan
 * @date 2021.04.09
 */
public class LeetCode4 {

    private double dfs(int[] nums1, int s1, int[] nums2, int s2, int k) {
        if( s1 >= nums1.length) {
            return nums2[s2 + k - 1];
        }
        if( s2 >= nums2.length) {
            return nums1[s1 + k - 1];
        }
        if( k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }
        int m = k / 2;
        int i = Math.min(s1 + m, nums1.length) - 1;
        int j = Math.min(s2 + m, nums2.length) - 1;
        if( nums1[i] <= nums2[j]) {  // 淘汰nums(s1 - i)
            return dfs(nums1, i+1, nums2, s2, k - i + s1 - 1);
        }
        return dfs(nums1, s1, nums2, j+1, k - j + s2 - 1);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        double r1 = dfs(nums1, 0, nums2, 0, (n1 + n2 + 2) / 2);
        double r2 = dfs(nums1, 0, nums2, 0, (n1 + n2 + 1) / 2);
        return r1 * 0.5 + r2 * 0.5;
    }

    public static void main(String[] args) {
        LeetCode4 lc = new LeetCode4();
        int[] nums1 = {1,3};
        int[] nums2 = {2};
//        int[] nums1 = {1,2};
//        int[] nums2 = {3,4};
//        int[] nums1 = {};
//        int[] nums2 = {1,2};
        double ret = lc.findMedianSortedArrays(nums1, nums2);
        System.out.println(ret);
    }

}
