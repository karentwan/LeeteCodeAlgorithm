package cn.karent.leetcode_v3.weeklycontest238;

import java.util.*;

/********************************************
 * description: 最高频元素的频数
 * @author wan
 * @date 2021.04.25
 ********************************************/
public class Algo5739 {

    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        if( n == 0) return 0;
        Arrays.sort(nums);
        int[] pre = new int[n];
        for (int i = n-2; i >= 0; i--) {
            pre[i] = nums[i+1] - nums[i];
        }
        for (int i = n-2; i >= 0; i--) {
            pre[i] += pre[i+1];
        }
        int[] ppre = new int[n];
        for (int i = n-2; i >= 0; i--) {
            ppre[i] += ppre[i+1] + pre[i];
        }
        int max = 0;
        for (int i = n-1; i >= 0; i--) {
            int l = 0, r = i;
            while (l < r) {
                int m = l + (r - l)/2;
                int val = ppre[m] - ppre[i] - pre[i] * (i - m);
                if( val <= k) r = m;
                else l = m+1;
            }
            if( i - l + 1 > max) {
                max = i - l + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Algo5739 lc = new Algo5739();
        int[] nums = {1, 2, 4};
        int k = 5;
//        int[] nums = {1,4,8,13};
//        int k = 5;
//        int[] nums = {9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966};
//        int k = 3056;
        int ret = lc.maxFrequency(nums, k);
        System.out.println(ret);
    }

}
