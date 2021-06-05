package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 使数组和能被p整除
 * @author wan
 * @date 2021.06.05
 ********************************************/
public class LeetCode1590 {

    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        if( n == 0) return 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if( sum % p == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(((int) (sum % p)), -1);
        long wnd = 0;
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            wnd += nums[i];
            int m1 = ((int) (wnd % p));
            if( map.containsKey(m1)) {
                ret = Math.min(ret, i - map.get(m1));
            }
            m1 = ((int) ((wnd + sum) % p));
            map.put(m1, i);
        }
        return ret == Integer.MAX_VALUE || ret == n ? -1 : ret;
    }

    public static void main(String[] args) {
        LeetCode1590 lc = new LeetCode1590();
//        int[] arr = {3,1,4,2};
//        int p = 6;
//        int[] arr = {6,3,5,2};
//        int p = 9;
        int[] arr = {1,2,3};
        int p = 7;
//        int[] arr = {26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3};
//        int p = 26;
        int ret = lc.minSubarray(arr, p);
        System.out.println(ret);
    }

}
