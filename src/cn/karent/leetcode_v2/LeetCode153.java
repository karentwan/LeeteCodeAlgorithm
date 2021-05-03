package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 寻找旋转排序数组中的最小值
 * @author wan
 * @date 2021.04.08
 */
public class LeetCode153 {

    public int findMin(int[] nums) {
        if( nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length-1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if( nums[m] > nums[r]) {
                l = m+1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
//        int[] nums = {3,4,5,1,2};
        int[] nums = {4,5,6,7,0,1,2};
        LeetCode153 lc = new LeetCode153();
        int ret = lc.findMin(nums);
        System.out.println(ret);
    }

}
