package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 在排序数组中查找数字一
 * @author wan
 * @date 2021.07.16
 ***********************************************/
public class Offer53 {

    private int lt(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if( nums[m] >= target) r = m-1;
            else l = m+1;
        }
        return r;
    }

    private int gt(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if( nums[m] > target) r = m-1;
            else l = m+1;
        }
        return l;
    }

    public int search(int[] nums, int target) {
        int r = gt(nums, target);
        int l = lt(nums, target);
        return r - l - 1;
    }

    public static void main(String[] args) {
        Offer53 lc = new Offer53();
//        int[] nums = {5,7,7,8,8,10};
//        int target = 6;
        int[] nums = {};
        int target = 6;
        int ret = lc.search(nums, target);
        System.out.println(ret);
    }

}
