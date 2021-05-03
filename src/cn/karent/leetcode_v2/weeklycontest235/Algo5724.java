package cn.karent.leetcode_v2.weeklycontest235;

import java.util.*;

import cn.karent.util.*;


/**
 * 绝对差值和
 * @author wan
 * @date 2021.04.04
 */
public class Algo5724 {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        if( nums1.length == 0) {
            return 0;
        }
        long sum = 0;
        int MOD = ((int) (1e9 + 7));
        long t1 = 0, t2 = 0;
        long t = 0, max = 0;
        int idx = -1;
        for (int i = 0; i < nums1.length; i++) {
            t1 = nums1[i];
            t2 = nums2[i];
            t = Math.abs(t1 - t2);
            if( t > max) {
                idx = i;
                max = t;
            }
            sum += t;
        }
        if( idx == -1) {
            return 0;
        }
        t2 = nums2[idx];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            t1 = nums1[i];
            t = Math.abs(t1 - t2);
            if( t < min) {
                min = t;
            }
        }
        sum = (sum - max + min) % MOD;
        return (int)sum;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,7,5};
        int[] nums2 = {2,3,5};
//        int[] nums1 = {2,4,6,8,10};
//        int[] nums2 = {2,4,6,8,10};
//        int[] nums1 = {1,10,4,4,2,7};
//        int[] nums2 = {9,3,5,1,7,4};
        Algo5724 algo = new Algo5724();
        int ret = algo.minAbsoluteSumDiff(nums1, nums2);
        System.out.println(ret);
    }

}
