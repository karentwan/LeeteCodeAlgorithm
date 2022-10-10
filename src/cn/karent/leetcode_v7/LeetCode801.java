package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 使序列递增的最小交换次数
 * @author wan
 * @date 2022.10.10 07:38
 ******************************************/
public class LeetCode801 {

    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] f = new int[n][2];
        f[0][1] = 1;
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i][1] = n;
            // 可不交换或者i和i-1都交换
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                f[i][0] = f[i-1][0];
                f[i][1] = f[i-1][1] + 1;
            }
            // 只能交换i-1或者i其中一个
            if (nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1]) {
                f[i][0] = Math.min(f[i][0], f[i-1][1]);
                f[i][1] = Math.min(f[i][1], f[i-1][0] + 1);
            }
        }
        return Math.min(f[n-1][0], f[n-1][1]);
    }

    public static void main(String[] args) {
        LeetCode801 lc = new LeetCode801();
//        int[] nums1 = {1,3,5,4};
//        int[] nums2 = {1,2,3,7};
        int[] nums1 = {1,2,3};
        int[] nums2 = {5,6,7};
        System.out.println(lc.minSwap(nums1, nums2));
    }

}
