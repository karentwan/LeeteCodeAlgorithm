package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 存在重复的元素 三
 * @author wan
 * @date 2021.04.17
 */
public class LeetCode220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if( k == 0) return false;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if( !set.isEmpty()) {
                Integer next = set.ceiling(num);
                Integer prev = set.floor(num);
                if( next != null && ((long) next) - num <= t) return true;
                if( prev != null && num - ((long) prev) <= t) return true;
            }
            if( i >= k) set.remove(nums[i-k]);
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode220 lc = new LeetCode220();
//        int[] nums = {1,2,3,1};
//        int k = 3;
//        int t = 0;
//        int[] nums = {1,5,9,1,5,9};
//        int k = 2;
//        int t = 3;
//        int[] nums = {1,0,1,1};
//        int k = 1;
//        int t = 2;
//        int[] nums = {1,2,3,1};
//        int k = 3;
//        int t = 0;
//        int[] nums = {1,2};
//        int k = 0;
//        int t = 1;
//        int[] nums = {1,5,9,1,5,9};
//        int k = 2;
//        int t = 3;
        int[] nums = {-2147483648,2147483647};
        int k = 1;
        int t = 1;
        boolean ret = lc.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(ret);
    }

}
