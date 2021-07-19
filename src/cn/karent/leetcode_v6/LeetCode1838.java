package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 最高频元素的频数
 * @author wan
 * @date 2021.07.19
 ***********************************************/
public class LeetCode1838 {

    private int binarySearch(long[] preSum, int bound, int k, int target) {
        int l = 0, r = bound;
        while ( l <= r) {
            int m = l + (r - l)/2;
            long t = preSum[bound] - preSum[m] + k;
            int len = bound - m;
            if( t >= target * len) r = m-1;
            else l = m+1;
        }
        return l;
    }

    // TODO 未完成
    public int maxFrequency1(int[] nums, int k) {
        Arrays.sort(nums);
        long[] preSum = new long[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        int ret = 0;
        for (int i = nums.length; i > 0; i--) {
            int l = binarySearch(preSum, i, k, nums[i-1]);
            ret = Math.max(ret, i - l);
        }
        return ret;
    }

    // 滑动窗口
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        if( nums.length == 0) return 0;
        int ret = 1;
        long total = 0;
        for (int i = 0, j = 1; j < nums.length; j++) {
            total += (nums[j] - nums[j-1]) * (j - i);
            if( total <= k) {
                ret = Math.max(ret, j - i + 1);
            } else {
                total -= nums[j] - nums[i];
                i++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1838 lc = new LeetCode1838();
        int[] nums = {1,2,4};
        int k = 5;
        int ret = lc.maxFrequency(nums, k);
        System.out.println(ret);
    }

}
