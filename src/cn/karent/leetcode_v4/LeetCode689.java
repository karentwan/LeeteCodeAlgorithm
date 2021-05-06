package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 三个无重叠子数组的最大和
 * @author wan
 * @date 2021.05.06
 ********************************************/
public class LeetCode689 {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ksum = new int[nums.length - k + 1];
        // 滚动求和不需要写两层for循环
        for (int i = 0; i < k; i++) {
            ksum[0] += nums[i];
        }
        for (int i = 1; i < ksum.length; i++) {
            ksum[i] = ksum[i-1] + nums[i+k-1] - nums[i-1];
        }
        int[] left = new int[nums.length - k + 1];
        int[] right = new int[nums.length - k + 1];
        int mx = 0;
        for (int i = 1; i < ksum.length; i++) {
            if( ksum[i] > ksum[mx]) {
                left[i] = i;
                mx = i;
            }
            else left[i] = mx;
        }
        mx = ksum.length-1;
        right[mx] = mx;
        for (int i = ksum.length-1; i >= 0; i--) {
            if( ksum[i] >= ksum[mx]) {
                right[i] = i;
                mx = i;
            } else right[i] = mx;
        }
        mx = 0;
        int[] rets = new int[3];
        for (int i = k; i < ksum.length-k; i++) {
            int t = ksum[left[i - k]] + ksum[i] + ksum[right[i + k]];
            if( t > mx) {
                mx = t;
                rets[0] = left[i-k];
                rets[1] = i;
                rets[2] = right[i+k];
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode689 lc = new LeetCode689();
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        int k = 2;
        int[] rets = lc.maxSumOfThreeSubarrays(nums, k);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
