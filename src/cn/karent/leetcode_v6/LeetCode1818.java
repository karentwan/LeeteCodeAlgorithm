package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 绝对差值和
 * @author wan
 * @date 2021.07.14
 ***********************************************/
public class LeetCode1818 {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        TreeSet<Integer> ts = new TreeSet<>();
        int mod = 1000_000_007;
        long ret = 0, sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum += Math.abs(nums1[i] - nums2[i]);
            ts.add(nums1[i]);
        }
        ret = sum;
        for (int i = 0; i < nums2.length; i++) {
            int t = Math.abs(nums1[i] - nums2[i]);
            if( ts.floor(nums2[i]) != null) {
                ret = Math.min(ret, sum - t + Math.abs(ts.floor(nums2[i]) - nums2[i]));
            }
            if( ts.ceiling(nums2[i]) != null) {
                ret = Math.min(ret, sum - t + Math.abs(ts.ceiling(nums2[i]) - nums2[i]));
            }
        }
        return ((int) (ret % mod));
    }

    public static void main(String[] args) {
        LeetCode1818 lc = new LeetCode1818();
        int[] arr1 = {1,7,5};
        int[] arr2 = {2,3,5};
        int ret = lc.minAbsoluteSumDiff(arr1, arr2);
        System.out.println(ret);
    }

}
